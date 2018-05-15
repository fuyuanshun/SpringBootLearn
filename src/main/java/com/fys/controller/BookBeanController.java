package com.fys.controller;

import com.fys.model.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookBeanController {

    @Autowired
    private BookBean bookBean;

    /*@RequestMapping(value = "/", produces = "text/plain;charset=UTF-8")
    public String findUser() {
        return "book name :"+bookBean.getName() + " book author:" + bookBean.getAuthor()+ " book price: "+bookBean.getPrice();
    }*/
}
