//package com.example.newtrainingapp.part6;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
//
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/api/cars").hasAnyRole("ADMIN", "CARS")
//                .antMatchers(HttpMethod.POST, "/api/cars").authenticated()
//                .antMatchers("/api/users/**").hasRole("USER_ADMIN")
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic()
//                .and()
//                .logout()
//                .and()
//                .headers().frameOptions().disable()
//                .and()
//                .csrf().ignoringAntMatchers("/api/**");
//    }
//
//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("{noop}Secret_123").roles("ADMIN", "CARS")
//                .and()
//                .withUser("admin2").password("{noop}Secret_123").roles("USER_ADMIN")
//                .and()
//                .withUser("admin3").password("{noop}Secret_123").roles("CARS");
//    }
//}