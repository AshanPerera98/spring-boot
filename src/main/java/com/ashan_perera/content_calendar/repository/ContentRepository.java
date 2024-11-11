package com.ashan_perera.content_calendar.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.ashan_perera.content_calendar.model.Content;

// This ListCrudRepository automatically ymark this as a repository in the run time and provide all the CRUD operations.
// first argument is the model that this repository managing and second is the data type of the id
public interface ContentRepository extends ListCrudRepository<Content,Integer>{

}
