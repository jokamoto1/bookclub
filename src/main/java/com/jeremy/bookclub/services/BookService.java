package com.jeremy.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jeremy.bookclub.models.Book;
import com.jeremy.bookclub.repositories.BookRepo;



@Service
public class BookService {

		private final BookRepo repo;
	    
	    public BookService(BookRepo repo) {
	        this.repo = repo;
	    }

	    public List<Book> findAll() {
	        return (List<Book>) repo.findAll();
	    }
	 
	    public Book create(Book book) {
	        return repo.save(book);
	    }
	    public void delete(Long id) {
	    	 repo.deleteById(id);
	    }
//
	    public Book findOne(Long id) {
	        Optional<Book> optional = repo.findById(id);
	        if(optional.isPresent()) {
	            return optional.get();
	        } else {
	            return null;
	        }
	    }
//	    public List<Ninja> findAllFromDojoId(Long id){
//	    	return (List<Ninja>) repo.findNinjaByDojoId(id);
//	    }
	  

}
