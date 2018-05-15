package com.fys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeLeafController {

    @RequestMapping("/testThymeLeaf")
    public ModelAndView testThymeLeaf() {
        List<String> list = new ArrayList();
        list.add("fysname1");
        list.add("fysname2");
        list.add("fysname3");
        ModelAndView modelAndView = new ModelAndView("/index");

        modelAndView.addObject("list", list);
        return modelAndView;
    }
}
