package com.rsotf.ps4p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/salas/list",  "/edificio/list").permitAll()
		
		.antMatchers("/salas/formE/**").hasAnyRole("ADMIN")
		.antMatchers("/salas/verSala/**").hasAnyRole("ADMIN")
		.antMatchers("/salas/save/**").hasAnyRole("ADMIN")
		.antMatchers("/salas/form/**").hasAnyRole("ADMIN")
		.antMatchers("/salas/delete/**").hasAnyRole("ADMIN")
		.antMatchers("/edificio/save").hasAnyRole("ADMIN")
		.antMatchers("/edificio/form").hasAnyRole("ADMIN")
		.antMatchers("/edificio/form/**").hasAnyRole("ADMIN")
		.antMatchers("/edificio/delete/**").hasAnyRole("ADMIN")
		.and()
			.formLogin().loginPage("/login")
			.permitAll()
		.and()
		.logout().permitAll();
	}



	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
		PasswordEncoder encoder = passwordEncoder();
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);		
		
			builder.inMemoryAuthentication()
			.withUser(users.username("admin").password("12345").roles("ADMIN", "USER"))
			.withUser(users.username("brandon").password("12345").roles("USER"));
	}


	
	
}
