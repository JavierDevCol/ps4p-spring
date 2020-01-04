//package com.rsotf.ps4p;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configurable
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder builder) {
//		
//		PasswordEncoder encoder = passwordEncoder();
//		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
//		
//		try {
//			builder.inMemoryAuthentication()
//			.withUser(users.username("admin").password("12345").roles("ADMIN", "USER"))
//			.withUser(users.username("BRANDON").password("12345").roles("USER"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
//}
