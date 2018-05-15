package com.fys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestJspController {

    @RequestMapping("/testJsp")
    public String testJsp() {
        return "HelloWorld";
    }
}
