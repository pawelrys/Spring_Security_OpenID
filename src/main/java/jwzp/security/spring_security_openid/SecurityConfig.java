package jwzp.security.spring_security_openid;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //Przypisujemy obowiązkowe uwierzytelnienie przy wywołaniu innych żądań, niż Get /books
        http.csrf().disable()
                .antMatcher("/**").authorizeRequests()
                .antMatchers(HttpMethod.GET, "/books").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }
}
