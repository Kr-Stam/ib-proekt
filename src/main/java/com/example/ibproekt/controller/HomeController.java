package com.example.ibproekt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
class HomeController {


        @GetMapping("/home")
        public String home(Model model){
            return "home";
        }
        @GetMapping("/")
        public String blank(Model model){
            return "home";
        }
    }

