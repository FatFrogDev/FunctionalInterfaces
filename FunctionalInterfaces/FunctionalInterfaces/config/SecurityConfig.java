package org.globant.globerMarket.users.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.test.context.jdbc.Sql;




@Configuration
@Sql(scripts = "classpath:import.sql")
public class SecurityConfig extends WebSecurityConfiguration{

}