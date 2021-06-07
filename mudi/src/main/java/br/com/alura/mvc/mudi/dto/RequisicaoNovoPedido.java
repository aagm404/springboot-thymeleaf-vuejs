package br.com.alura.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

public class RequisicaoNovoPedido {
	
	/*
	 * Esta classe faz o papel de um DTO - Data Transfer Object
	 * Ela e' argumento de uma action de um controller
	 * Nesse caso, em especifico, este objeto e' argumento da action "novo", do controller "PedidoController"
	 * 
	 * Classes deste padrao servem para trasferir dados entre a view e o modelo. Um pedido pode ter mais atributos
	 * do que estes abaixo, porem esta classe serve para transferir apenas estes atributos
	 * 
	 * Os seus atributos DEVEM TER O MESMO NOME que os "names" dos inputs passados pelo formulario da view
	 */

	/*
	 * Toda vez que a validacao da anotacao @NotBlank abaixo encontrar um erro, ela 
	 * gera uma mensagem de erro default, com a seguinte chave/valor
	 * NotBlank.requisicaoNovoPedido.nomeProduto=nao pode estar em branco
	 * 
	 * Alteramos esta o valor desta chave no arquivo messages.properties
	 */
	@NotBlank
	private String nomeProduto;
	
	/*
	 * Toda vez que a validacao da anotacao @NotBlank abaixo encontrar um erro, ela 
	 * gera uma mensagem de erro default, com a seguinte chave/valor
	 * NotBlank.requisicaoNovoPedido.urlProduto=nao pode estar em branco
	 * 
	 * Alteramos esta o valor desta chave no arquivo messages.properties
	 */
	@NotBlank
	private String urlProduto;
	
	/*
	 * Toda vez que a validacao da anotacao @NotBlank abaixo encontrar um erro, ela 
	 * gera uma mensagem de erro default, com a seguinte chave/valor
	 * NotBlank.requisicaoNovoPedido.urlImagem=nao pode estar em branco
	 * 
	 * Alteramos esta o valor desta chave no arquivo messages.properties
	 */
	@NotBlank
	private String urlImagem;
	
	private String descricao;
	
	
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlProduto(urlProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setDescricao(descricao);
		pedido.setStatus(StatusPedido.AGUARDANDO);
				
		return pedido;
	}
	
	// Daqui para baixo, somente getters and setters
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public String getUrlProduto() {
		return urlProduto;
	}
	
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}
	
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
