package com.gb.tech.apioperation.config;

import com.gb.financial.assistant.lib.jwt.impl.JwtRsaParser;
import com.gb.financial.assistant.lib.jwt.spring.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public JwtRsaParser jwtRsaParser (@Value(value = "${jwt.publicKey}") String publicKey) {
        return new JwtRsaParser(publicKey);
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(JwtRsaParser jwtRsaParser){
        return new JwtAuthenticationFilter(jwtRsaParser);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        http
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(jwtAuthenticationFilter)
                .authorizeRequests()
                .antMatchers("/financialOperation").authenticated();
        return http.build();
    }
}
