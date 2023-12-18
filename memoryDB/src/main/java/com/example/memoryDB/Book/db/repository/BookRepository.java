package com.example.memoryDB.Book.db.repository;

import com.example.memoryDB.Book.db.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.memoryDB.db.SimpleDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
