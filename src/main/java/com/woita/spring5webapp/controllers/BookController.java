package com.woita.spring5webapp.controllers;

import com.woita.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mcbrydr on 25/07/19
 */
@Controller
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        // Spring MVC will pass in an instance of the model. We then add an attribute to the model called books which is
        // a list of all the books, via the book repository which underneath the covers is using JPA and Hibernate from the DB
        model.addAttribute("books", bookRepository.findAll());
        // Thymeleaf view name
        return "books";
    }
}
