package com.example.CRUD.repository;

import com.example.CRUD.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News,Long> {

    public News findByDate(@Param("date") String date);

    @Modifying
    @Query("DELETE FROM News n WHERE n.date = :date")
    public void deleteByDate(@Param("date") String date);
}
