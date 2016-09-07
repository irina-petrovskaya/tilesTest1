package com.mytests.springmvc.tiles.tilesTest1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("/")
public class MyController {
 
    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "home";
    }
 
    @RequestMapping(value = { "/page1"}, method = RequestMethod.GET)
    public String productsPage(ModelMap model) {
        model.addAttribute("today", new Date());
        return "page1";
    }
 
    @RequestMapping(value = { "/page2"}, method = RequestMethod.GET)
    public String contactUsPage(ModelMap model) {
        model.addAttribute("page2Attr","have a good day!");
        return "page2";
    }
}