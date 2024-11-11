package com.ashan_perera.content_calendar.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.ashan_perera.content_calendar.model.Content;
import com.ashan_perera.content_calendar.model.Status;

// This ListCrudRepository automatically ymark this as a repository in the run time and provide all the CRUD operations.
// first argument is the model that this repository managing and second is the data type of the id
public interface ContentRepository extends ListCrudRepository<Content,Integer>{

    // query derivation
    // the name of the method can be constructed by nesting required methods and it will perform the filteration automatically
    List<Content> findAllByTitleContains(String keyword);

    // any custom SQL query can be added to the method
    @Query("""
            SELECT * FROM Content
            WHERE status = :status
            """)
    List<Content> listByStatus(@Param("status") Status status);

}
