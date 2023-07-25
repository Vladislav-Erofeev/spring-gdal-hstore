package com.example.demoscriptspring;

import org.gdal.ogr.DataSource;
import org.gdal.ogr.ogr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoScriptSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoScriptSpringApplication.class, args);
    }

    @Bean(name = "gdalDatasource")
    public static DataSource dataSource(@Value("${converter.path}") String CONVERTER_PATH) {
        ogr.RegisterAll();
        return ogr.Open(CONVERTER_PATH);
    }

}
