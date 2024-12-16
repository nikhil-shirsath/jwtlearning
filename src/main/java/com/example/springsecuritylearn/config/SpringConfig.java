package com.example.springsecuritylearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity//used to bypass the security so the default security is changed S
public class SpringConfig {

	
	@Bean //to make it as a bean of the springboot to make changes in it 
	public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(customizer-> customizer.disable());// to disable the csrf 
		http.authorizeHttpRequests(request->request.anyRequest().authenticated());// no direct access from any other window //it needed authentication
		
		//http.formLogin(Customizer.withDefaults());//to allow the login form // but it returns forms code in the postman so to allow postman we uses
		http.httpBasic(Customizer.withDefaults());//to allow rest request using postman
		
		//to make httpsession stateless 
		//we need to change session management session creation policy to change to stateless it will work on the postman but on browser it will 
		//again and again show the login form for that we needed to remove http.formlogin 
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		return http.build();
		
	}
}
