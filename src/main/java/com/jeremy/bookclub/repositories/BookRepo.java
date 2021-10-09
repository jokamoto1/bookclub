package com.jeremy.bookclub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jeremy.bookclub.models.Book;



@Repository
public interface  BookRepo extends CrudRepository<Book, Long>{}
