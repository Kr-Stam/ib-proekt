package com.example.ibproekt.security.config;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration  {

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf((csrf) -> {
                    csrf.disable();
                })
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
                                .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
                                .requestMatchers("/home").permitAll()
                                .requestMatchers("/home/**").hasRole("USER")
                                .requestMatchers("/categories/**", "/manufacturers/**").hasRole("ADMIN")
                                .requestMatchers("/products/**").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/endpoint").permitAll()
                                .requestMatchers("/register","/login").anonymous()
                                .anyRequest().authenticated()
                )
                .authenticationProvider(authenticationProvider)
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .loginProcessingUrl("/perform_login")
                        .defaultSuccessUrl("/home", true)
                        .failureForwardUrl("/login_failure")
                        .failureUrl("/login?error")
                )
                .logout(logout -> logout
                        .logoutUrl("/perform_logout")
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true)
                        .logoutSuccessUrl("/home")
                );

        return http.build();
    }
}
