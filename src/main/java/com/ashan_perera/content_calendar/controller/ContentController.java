package com.ashan_perera.content_calendar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    // Read
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found"));
    }

    // Create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Content create(@RequestBody Content content){
        return repository.createContent(content);
    }
    
    //Update
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Content update(@PathVariable Integer id, @RequestBody Content content){
        if(!repository.isContentExist(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid content Id");
        }
        return repository.createContent(content);
    }

    // Delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if(!repository.isContentExist(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid content Id");
        }
        repository.deleteContent(id);
    }

}
