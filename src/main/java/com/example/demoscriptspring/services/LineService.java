package com.example.demoscriptspring.services;

import com.example.demoscriptspring.domain.entities.Line;
import com.example.demoscriptspring.repositories.LineRepository;
import lombok.RequiredArgsConstructor;
import org.gdal.ogr.DataSource;
import org.gdal.ogr.Feature;
import org.gdal.ogr.Layer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LineService {
    private final LineRepository lineRepository;
    @Qualifier("gdalDatasource")
    private final DataSource dataSource;

    public List<Line> getLinesByLayername(String layername, int page, int limit) {
        Layer layer = dataSource.GetLayer(0);
        layer.SetAttributeFilter(String.format("\"layer\" = '%s'", layername));
        Feature feature;
        List<String> values = new LinkedList<>();
        String tag = "";
        while ((feature = layer.GetNextFeature()) != null) {
            values.add(feature.GetFieldAsString("value"));
            tag = feature.GetFieldAsString("tag");
        }
        return lineRepository.findAllByTagAndValues(tag, values, page, limit);
    }
}
