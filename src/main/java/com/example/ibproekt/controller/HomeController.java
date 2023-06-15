package com.example.ibproekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
class HomeController {


        @GetMapping("/home")
        public String Login(Model model){
            return "master-template";
        }
    }

