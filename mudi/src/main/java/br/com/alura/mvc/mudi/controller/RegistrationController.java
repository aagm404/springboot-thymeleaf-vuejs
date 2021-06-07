package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoUsuario;
import br.com.alura.mvc.mudi.model.Authorities;
import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repository.AuthoritiesRepository;

@Controller
public class RegistrationController {
	
	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	@GetMapping
	@RequestMapping("/registration")
	public String register(RequisicaoNovoUsuario requisicao) {
		return "registration";
	}
	
	@PostMapping("/registeruser")
	public String cadastarUsuario(@Valid RequisicaoNovoUsuario requisicao, BindingResult result) {
		User user = requisicao.toUser();
		
		Authorities authorities = new Authorities();
		authorities.setUser(user);
		authorities.setAuthority("ROLE_USER");
		
		authoritiesRepository.save(authorities);
		
		return "redirect:/login";
	}
}
