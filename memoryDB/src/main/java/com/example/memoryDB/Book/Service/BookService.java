package com.example.memoryDB.Book.Service;

import com.example.memoryDB.Book.db.Entity.BookEntity;
import com.example.memoryDB.Book.db.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //create, update
    public BookEntity create(BookEntity entity){
        return bookRepository.save(entity);
    }

    //all
    public List<BookEntity> findAll(){
        return bookRepository.findAll();
    }


    //delete

    //find one
}
