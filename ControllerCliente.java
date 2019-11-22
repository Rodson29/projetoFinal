package controller;

import model.bo.ClienteBO;
import model.vo.ClienteVO;

public class ControllerCliente {

	public static String cadastrarClienteController(String nome, String cpf, String telefone, String email) {
		String mensagem = "";

		if(nome.isEmpty() || nome.trim().length() < 3) {
			mensagem += "Nome deve possuir no m�nimo 3 letras \n";
		}

		if(cpf.isEmpty() || cpf.trim().length() != 11) {
			mensagem += "CPF deve possuir 11 d�gitos \n";
		}
		
		if(telefone.isEmpty() || telefone.trim().length() != 12) {
			mensagem += "Telefone deve possuir 12 d�gitos incluindo o ddd \n";
		}

		if(email.isEmpty() ) {
			mensagem += "Email n�o pode constar vazio \n";
		}
		return mensagem;
	}
  public ClienteVO salvar(ClienteVO clienteVO){
	    ClienteBO clienteBO = new ClienteBO();
	    return clienteBO.cadastrarClienteBO(clienteVO);
  }
}
