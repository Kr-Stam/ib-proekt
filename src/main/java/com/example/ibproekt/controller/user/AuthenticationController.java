package com.example.ibproekt.controller.user;


import com.example.ibproekt.entity.dto.UserDto;
import com.example.ibproekt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
//@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(
            @ModelAttribute("user") UserDto user
            ){
        try {
            userService.register(RegisterRequest.builder()
                    ._username(user.getUsername())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .build());

            return "redirect:/home";
        }catch (Exception e){
            return "redirect:/register?error";
        }
    }

    @GetMapping("/register")
    public String getRegisterPage(
            Model model,
            @RequestParam("error") Optional<Object> error
    ){
        if(error.isPresent()){
            model.addAttribute("registerError", true);
        }
        return "register";
    }
    @GetMapping("/login")
    public String login(
            Model model,
            @RequestParam("error") Optional<Object> error
    ){
        if(error.isPresent()){
            model.addAttribute("loginError", true);
        }
        return "login";
    }

    @PostMapping("/login_failure")
    public String loginFailure(Model model){

        return "redirect:/login?error";
    }


    @GetMapping("/logout")
    public String logout(Model model){
        return "redirect:/home";
    }
}
