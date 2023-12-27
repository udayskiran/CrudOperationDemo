package com.example.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.crud.entity.Book;

@Repository
public interface bookRepo extends JpaRepository<Book, Integer>{

}
