package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	/*
	 * O atributo da anotacao abaixo indica o endereco que este metodo pode ser
	 * requisitado via HTTP. Para o caso em questao e subindo o tomcat em localhost
	 * na porta 8080, o metodo abaixo vai ser chamado pela url
	 * http://localhost:8080/hello
	 */
	@GetMapping("/hello")
	public String hello(Model model) {
		/*
		 * Um metodo anotado com @GetMapping, dentro de uma classe anotada
		 * com @Controller, devolve uma string que representa o nome de uma view. Ou
		 * seja o retorno deste metodo direciona a aplicacao para uma view com o nome
		 * hello.html
		 * 
		 * Este comportamento e' chamado de "action". Este metodo e' uma "action"
		 * Ele vai processar uma requisicao HTTP de um cliente e redirecionar o fluxo
		 * da aplicacao para uma determinada view. No caso do Spring, as actions
		 * sao metodos de classe @Controller
		 */

		// Abaixo, definimos um atributo de nome "nome" e valor "Mundo" que vai ser
		// passado a view
		model.addAttribute("nome", "Mundo");
		return "hello";
	}
}
