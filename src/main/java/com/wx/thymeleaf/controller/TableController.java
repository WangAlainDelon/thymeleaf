package com.wx.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TableController {

    @RequestMapping("/dynamicallyaddonerow")
    public String dynamicallyAddOneRow()
    {
        return "dynamicallyaddonerow";
    }
}
