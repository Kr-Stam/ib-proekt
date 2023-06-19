package com.example.ibproekt.service;

import com.example.ibproekt.controller.user.RegisterRequest;
import com.example.ibproekt.entity.User;
import com.example.ibproekt.repository.UserRepository;
import com.example.ibproekt.security.Role;
import com.example.ibproekt.util.UserExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public User register(RegisterRequest request) throws UserExistsException {
        User user = User.builder()
                ._username(request.get_username())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();

        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new UserExistsException();
        }

        userRepository.save(user);

        return user;
    }

}
