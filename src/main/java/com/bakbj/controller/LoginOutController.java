package com.bakbj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginOutController {

    @GetMapping("/login")
    public void login() {}

    @GetMapping("/logout")
    public void logout() {}
}
