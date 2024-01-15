package com.example.demo1mvc.controller;

import com.example.demo1mvc.reposity.BlogReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    BlogReposity blogReposity;
    @GetMapping
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("blog/list");
        modelAndView.addObject("list",blogReposity.findAll());
        return modelAndView;
    }

}
