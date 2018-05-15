package com.fys.controller;

import com.fys.model.Book;
import com.fys.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("findBook")
    public String findBookByAuthor(String authorName) {
        List<Book> books = bookRepository.findAllByAuthorName(authorName);
        for (Book book: books) {
            System.out.println(book.getAuthor());
        }
        return " "+books.size();
    }

    @RequestMapping("/testSession")
    public String testSession(String authorName) {
        String book = findBookByAuthor(authorName);
        System.out.println(book);
        return "";
    }

    @RequestMapping("findBookByAuthorName")
    public String findFirstAuthor(String authorName) {
        Book book = bookRepository.findBookByAuthorName(authorName);
        System.out.println(book.getName());
        return "";
    }
}
