package com.example.CRUD.controller;

import com.example.CRUD.entity.News;
import com.example.CRUD.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "${cors.allowed.origins}")
public class NewsController {

    @Autowired
    NewsService newsService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(NewsController.class);


    @PostMapping("/create")
    public ResponseEntity<String> createNews(@RequestBody News news){
        return newsService.createNews(news);

    }

    @PutMapping("/update/{date}")
    public News updateNews(@PathVariable("date") String date,@RequestBody News news){
        return newsService.updateNewsByDate(date,news);
    }

    @GetMapping("/get")
    public List<News> getAllNews(){
        LOGGER.info("All News Retrieved!!");
        return newsService.getNews();
    }

    @GetMapping("/get/{date}")
    public News getNews(@PathVariable("date") String date){
        return newsService.getNewsByDate(date);
    }

    @DeleteMapping("/delete/{date}")
    public void deleteNews(@PathVariable("date") String date){
        newsService.deleteNewsByDate(date);
    }


}
