package com.example.CRUD.service;

import com.example.CRUD.entity.News;
import com.example.CRUD.repository.NewsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    public ResponseEntity<String> createNews(News news){
//        String date = String.valueOf(getNewsByDate(news.getDate()));
//        if(!date.equals("null")){
//            System.out.println(date);
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("News with this date already exists!!");
//        }
        newsRepository.save(news);
        return ResponseEntity.status(HttpStatus.CREATED).body("News Created Successfully "+news);
    }

    public List<News> getNews(){
       return newsRepository.findAll();
    }

    public News getNewsByDate(String date) {
        return newsRepository.findByDate(date);
    }


    @Transactional
    public void deleteNewsByDate(String date){
        newsRepository.deleteByDate(date);
    }

    public News updateNewsByDate(String date,News news){
        News existingNews = newsRepository.findByDate(date);
        if (Objects.nonNull(news.getImage())) {
            existingNews.setImage(news.getImage());
        }
        if (Objects.nonNull(news.getHeading())) {
            existingNews.setHeading(news.getHeading());
        }
        if (Objects.nonNull(news.getBody())) {
            existingNews.setBody(news.getBody());
        }
        if (Objects.nonNull(news.getTail())) {
            existingNews.setTail(news.getTail());
        }

        return newsRepository.save(existingNews);

    }

}
