package com.mdtalalwasim.takenote.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	//Core interface which loads user-specific data.
	//It is used throughout the framework as a user DAO 
	//and is the strategy used by the DaoAuthenticationProvider.
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
		
		dap.setUserDetailsService(userDetailsService);
		dap.setPasswordEncoder(passwordEncoder());
		
		return dap;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//Example
		//http://localhost:8080/register, signin, - these are accessible without login or authorization--publicly accessible
		//http:/localhost:8080/user/add-notes, view-notes, --- these types of request will not accessible without login. 
		//or authorized user only can acces these urls.
		
		http.csrf()
		.disable()
		.authorizeHttpRequests().requestMatchers("/user/**")//** indicate "any request after 'user' mapping"
		.hasRole("USER")
		
		// '/**' if any request then permitAll.
		.requestMatchers("/**").permitAll()
		.and()
		
		//not going to use spring boot default form based login page 
		//-> using my custom login page except spring boot login page.
		.formLogin().loginPage("/signin") 
		
		//after signin -> particular process happens on which url? here '/user-login' my user Login page form action :url
		.loginProcessingUrl("/user-login") 
		.defaultSuccessUrl("/user/add-notes").permitAll();
		
		DefaultSecurityFilterChain build = http.build();
		
		return build;
		
		
	}
	
	
	
	
	

	   
}
