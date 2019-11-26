package com.github.lebw.simplelb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LBW
 */
@Controller
public class SimpleController {
    @RequestMapping("/")
    public String getRequest() {
        return "hello";
    }
}
