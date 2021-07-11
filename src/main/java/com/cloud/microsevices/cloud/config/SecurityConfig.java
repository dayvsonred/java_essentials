package com.cloud.microsevices.cloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		LOGGER.info("************ password encode" + passwordEncoder.encode("essentials"));
		auth.inMemoryAuthentication()
				.withUser("dayvson")
				.password("essentials")//.password(passwordEncoder.encode("essentials"))
				.roles("ADMIN")
				.and()
				.withUser("comum")
				.password("essentials")
				.roles("USER");
				
				
		//auth.userDetailsService(securityBdUserService);//.passwordEncoder(passwordEncoder);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic();
		//http.authorizeRequests()
			//.antMatchers("/anime/by/**").hasRole("ADMIN");
            //.and().formLogin();
	
		/*	  
		http.csrf().disable()
//        csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .and()
        .httpBasic();
	
		//http.csrf().disable()
		//.authorizeRequests()
		//.anyRequest()
		//.authenticated()
		//.and()
		//.httpBasic();
		
		
		//CODIGO PARA ABILITAR AUTH
		//http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
			//.authorizeRequests()
			//.anyRequest()
			//.authenticated()
			//.and()
			//.httpBasic();
	*/				
	}
	
	
	
	@Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
	

}
