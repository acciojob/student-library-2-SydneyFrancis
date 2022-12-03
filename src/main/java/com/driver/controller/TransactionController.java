package com.driver.controller;

import com.driver.models.Book;
import com.driver.models.Card;
import com.driver.repositories.BookRepository;
import com.driver.repositories.CardRepository;
import com.driver.services.BookService;
import com.driver.services.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Add required annotations

@RestController
@Slf4j
public class TransactionController {

    //Add required annotations

    @Autowired
    TransactionService transactionService;

    @PutMapping("/issueBook")
    public ResponseEntity issueBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
        log.info("issuing book");
        transactionService.issueBook(cardId,bookId);
       return new ResponseEntity<>("transaction completed", HttpStatus.ACCEPTED);
    }

    //Add required annotations
    @PutMapping("/returnBook")

    public ResponseEntity returnBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception{
        transactionService.returnBook(cardId,bookId);
        return new ResponseEntity<>("transaction completed", HttpStatus.ACCEPTED);
    }
}
