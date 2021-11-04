package com.miluo.gateway.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author by ZhangLei
 * @date 2021/11/3 15:58
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private CustomLogoutSuccessHandler customLogoutSuccessHandler;

    @Autowired
    public SecurityConfig(CustomLogoutSuccessHandler customLogoutSuccessHandler){
        this.customLogoutSuccessHandler = customLogoutSuccessHandler;
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        http.logout().logoutSuccessHandler(this.customLogoutSuccessHandler);
    }

}
