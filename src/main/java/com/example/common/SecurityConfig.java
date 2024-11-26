package com.example.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.formLogin(login -> login
                .loginProcessingUrl("/login")
                .loginPage("/")
                .defaultSuccessUrl("/employee/showList")
                .failureUrl("/?result=error")
                .usernameParameter("mailAddress")
                .passwordParameter("password")
                .permitAll()).logout(logout -> logout
                        .logoutSuccessUrl("/"))
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/", "/toInsert", "/insert", "/css/**",
                                "/img/**", "/js/**")
                        .permitAll()
                        .anyRequest().authenticated());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
