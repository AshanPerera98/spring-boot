package com.ashan_perera.content_calendar.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.ashan_perera.content_calendar.model.Content;

// This ListCrudRepository automatically ymark this as a repository in the run time and provide all the CRUD operations.
// first argument is the model that this repository managing and second is the data type of the id
public interface ContentRepository extends ListCrudRepository<Content,Integer>{

    // the name of the method can be constructed by nesting required expressions and it will perform the filteration automatically
    List<Content> findAllByTitleContains(String keyword);

}
