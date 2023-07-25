package com.example.demoscriptspring.repositories;

import com.example.demoscriptspring.domain.entities.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineRepository extends JpaRepository<Line, Long> {
    String CASE = "CASE :tag when 'highway' then highway end";

    @Query(value = "select * from lines where " + CASE + " in" +
            " (:values) offset (:page * :limit) fetch next :limit rows only", nativeQuery = true)
    List<Line> findAllByTagAndValues(@Param("tag") String tag, @Param("values") List<String> values,
                                     @Param("page") int page, @Param("limit") int limit);
}
