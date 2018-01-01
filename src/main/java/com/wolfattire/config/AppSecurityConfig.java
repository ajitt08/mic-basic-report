package com.wolfattire.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import com.wolfattire.authentication.AppAuthenticationFailureHandler;
import com.wolfattire.authentication.AppAuthenticationProvider;
import com.wolfattire.authentication.AppAuthenticationSuccessHandler;
import com.wolfattire.authentication.AppHttp401AuthEntryPoint;

public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private AppAuthenticationFailureHandler appAuthenticationFailureHandler;
	
	@Autowired
	private AppAuthenticationProvider appAuthenticationProvider;
	
	@Autowired
	private AppAuthenticationSuccessHandler appAuthenticationSuccessHandler;
	
	@Autowired
	private AppHttp401AuthEntryPoint appHttp401AuthEntryPoint;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
        	.antMatchers("/#/login").permitAll()
        	.antMatchers("/public/modules/**/**").permitAll()
            .antMatchers("/public/lib/**").permitAll()
            .antMatchers("/public/*.js").permitAll()
            .anyRequest().authenticated()
        	.and().formLogin().loginPage("/#/login").loginProcessingUrl("/login")
            // specify the authentication success handler
            .successHandler(appAuthenticationSuccessHandler)
            // specify the authentication success handler
            .failureHandler(appAuthenticationFailureHandler).usernameParameter("username")
            .passwordParameter("password").permitAll()
            // delete cookies upon logout

            // add the csrf header filter
            .and().exceptionHandling()

            // add exception handling
            .authenticationEntryPoint(appHttp401AuthEntryPoint)

            .and()
            .logout().logoutUrl("/logout").logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())

            // control csrf
            .and().csrf().disable();
	}
	
	@Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(appAuthenticationProvider);
        auth.eraseCredentials(false);
    }

}
