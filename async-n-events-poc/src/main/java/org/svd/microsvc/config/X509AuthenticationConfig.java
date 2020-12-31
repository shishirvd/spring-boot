package org.svd.microsvc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class X509AuthenticationConfig extends WebSecurityConfigurerAdapter {
	@Value("${client.certificate.users}")
	private String clientCertificateUsers;

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests().anyRequest().authenticated()
	          .and()
	          .x509()
	            .subjectPrincipalRegex("CN=(.*?)(?:,|$)")
	            .userDetailsService(userDetailsService());
	    }

	    @Bean
	    public UserDetailsService userDetailsService() {
	        return new UserDetailsService() {
	            @Override
	            public UserDetails loadUserByUsername(String username) {
	            	String[] usernames = clientCertificateUsers.split(",");
	            	
	                if (Arrays.asList(usernames).contains(username)) {
	                    return new User(username, "", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
	                }
	                throw new UsernameNotFoundException("User not found!");
	            }
	        };
	    }
}
