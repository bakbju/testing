package com.bakbj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("page1")
    public String page1() {
        return "user/page1";
    }

    @GetMapping("page2")
    public String page2() {
        return "user/page2";
    }
}
