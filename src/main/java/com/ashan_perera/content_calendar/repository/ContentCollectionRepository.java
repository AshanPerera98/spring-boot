package com.ashan_perera.content_calendar.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ashan_perera.content_calendar.model.Content;
import com.ashan_perera.content_calendar.model.Status;
import com.ashan_perera.content_calendar.model.Type;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public Content createContent(Content content){
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
        return content;
    }

    public void deleteContent(Integer id){
        contentList.removeIf(c -> c.id().equals(id));
    }

    public Boolean isContentExist(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    //this annotation will run after dependancy injection
    @PostConstruct
    public void init(){
        Content c = new Content(
            1, 
            "Frist Content", 
            "This is the sample for first content", 
            Status.IN_PROGRESS, 
            Type.BLOG, 
            LocalDateTime.now(), 
            null, 
            ""
        );

        contentList.add(c);
    }

}
