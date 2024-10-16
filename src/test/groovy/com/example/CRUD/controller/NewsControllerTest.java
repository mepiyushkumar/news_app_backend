//package com.example.CRUD.controller;
//
//import com.example.CRUD.entity.News;
//import com.example.CRUD.service.NewsService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(NewsController.class)
//class NewsControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private NewsService newsService;
//
//    private News news;
//
//    @BeforeEach
//    void setUp() {
//        // Using builder to set up the news object for the test
//        news = News.builder()
//                .headline("Breaking News")
//                .body("This is the news body content.")
//                .date("2024-10-01")
//                .image("https://example.com/news-image.jpg")
//                .build();
//    }
//
//    @Test
//    void getAllNews() throws Exception {
//        // Mocking the behavior of newsService to return the news object
//        when(newsService.getNews()).thenReturn(List.of(news));
//
//        // Performing a GET request and verifying the response
//        mockMvc.perform(get("/news"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].headline").value("Breaking News"))
//                .andExpect(jsonPath("$[0].body").value("This is the news body content."))
//                .andExpect(jsonPath("$[0].date").value("2024-10-01"));
//    }
//}
