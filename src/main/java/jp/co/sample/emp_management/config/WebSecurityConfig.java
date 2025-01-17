package jp.co.sample.emp_management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Spring Securityの設定を行うためのクラス.
 * 
 * @author takara.miyazaki
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/img/**", "/js/**");
    }
			
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		//http.formLogin().disable();
		
		http.authorizeRequests()
			.antMatchers("/","/toInsert","/insert").permitAll()
			.anyRequest().authenticated();
		
		http.formLogin()
			.loginPage("/")
			.loginProcessingUrl("/login")
			.failureUrl("/?error=true") 
			.defaultSuccessUrl("/employee/showList",true)
			.usernameParameter("mailAddress")
			.passwordParameter("password");
		
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
			.logoutSuccessUrl("/?logout")
			.deleteCookies("JSESSIONID")
			.invalidateHttpSession(true);
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
		
	}
	/**
	 * パスワードのハッシュ化を行うためのエンコーダー.
	 * 
	 * @return エンコーダー
	 */
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
