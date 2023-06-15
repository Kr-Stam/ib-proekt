package com.example.ibproekt.controller.user;


import com.example.ibproekt.entity.User;
import com.example.ibproekt.entity.dto.UserDto;
import com.example.ibproekt.security.api.AuthenticationRequest;
import com.example.ibproekt.security.api.AuthenticationResponse;
import com.example.ibproekt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(
            @ModelAttribute("user") UserDto user
            ){
        authService.register(RegisterRequest.builder()
                        ._username(user.getUsername())
                        .email(user.getEmail())
                        .password(user.getPassword())
                .build());

        return "redirect:/home";
    }

    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }

//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> authenticate(
//            @RequestBody AuthenticationRequest request
//    ){
//        return ResponseEntity.ok(authService.authenticate(request));
//    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
