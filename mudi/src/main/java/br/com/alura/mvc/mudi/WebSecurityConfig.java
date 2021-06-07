package br.com.alura.mvc.mudi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	// O metodo abaixo e' para jogar o usuario nao logado para a pagina de login
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/home/**").permitAll()
				.antMatchers("/registration*").permitAll()
				.antMatchers("/registeruser*").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin(form -> form
	            .loginPage("/login")
	            .defaultSuccessUrl("/usuario/pedido", true)
	            .permitAll())
			.logout(logout -> 
				logout.logoutUrl("/logout")
					.logoutSuccessUrl("/home"))
			.csrf().disable();
	}
	
	// O metodo abaixo e' para autenticacao de usuarios
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
//		// Colocamos um usuario inicial na base de dados -- login: admin / password: admin1234
//		UserDetails user1 =
//				 User.builder()
//					.username("admin")
//					.password(encoder.encode("admin1234"))
//					.roles("ADM")
//					.build();
//		
//		// Colocamos um usuario inicial na base de dados -- login: root / password: root
//		UserDetails user2 =
//				 User.builder()
//					.username("root")
//					.password(encoder.encode("root"))
//					.roles("ADM")
//					.build();
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(encoder);
	}
}