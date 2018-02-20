package com.bakbj.controller;

import com.bakbj.domain.Account;
import com.bakbj.domain.AccountRepository;
import com.bakbj.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/anyone")
public class AnyoneController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("page1")
    public String page1() {
        return "anyone/page1";
    }

    @GetMapping("page2")
    public String page2() {
        return "anyone/page2";
    }

    @GetMapping("/register/form")
    public String registerForm() {
        return "anyone/register/form";
    }

    @PostMapping("/register")
    public String register(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.save(account);

        MyUserDetails userDetails = new MyUserDetails(account);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/";
    }

    @GetMapping("/accounts")
    public String accounts(Model model) {
        model.addAttribute("accounts", accountRepository.findAll());
        return "accounts";
    }

}
