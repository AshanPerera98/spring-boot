package com.ashan_perera.content_calendar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashan_perera.content_calendar.model.Content;
import com.ashan_perera.content_calendar.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    // auto wire the repository instance available in the application to the controller
    public ContentController(ContentCollectionRepository repository){
        this.repository = repository;
    }

    // create api route to get all content
    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
    }

}
