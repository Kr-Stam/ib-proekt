package com.example.ibproekt.util;

import com.example.ibproekt.entity.User;
import com.example.ibproekt.repository.UserRepository;
import com.example.ibproekt.security.Role;
import com.example.ibproekt.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        User admin = User.builder()
                ._username("admin")
                .email("admin")
                .password(passwordEncoder.encode("123"))
                .role(Role.ROLE_ADMIN)
                .build();

        if(userRepository.findByEmail(admin.getEmail()).isEmpty()){
            userRepository.save(admin);
        }
    }
}
