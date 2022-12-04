package com.driver.services;

import com.driver.models.Author;
import com.driver.models.Book;
import com.driver.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;

    public void createBook(Book book){
        Author author = book.getAuthor();
        if(author != null){
            if(author.getBooksWritten() == null){
                author.setBooksWritten(new ArrayList<>());
            }
            author.getBooksWritten().add(book);
        }
        bookRepository2.save(book);
    }

    public List<Book> getBooks(String genre, boolean available, String author){
        if(genre != null && author != null){
            List<Book> books = bookRepository2.findBooksByGenreAuthor(genre,author,available);
            return books;
        } //find the elements of the list by yourself

        if(genre != null){
            List<Book> byGenre = bookRepository2.findBooksByGenre(genre,available);
            return byGenre;
        }
        else{
            List<Book> byAuthor = bookRepository2.findBooksByAuthor(author,available);
            return byAuthor;
        }
    }
}
