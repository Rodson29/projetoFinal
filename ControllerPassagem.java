package controller;

import javax.swing.JOptionPane;

import model.bo.ClienteBO;
import model.bo.PassagemBO;
import model.vo.ClienteVO;
import model.vo.PassagemVO;

public class ControllerPassagem {
	
	public static String cadastrarPassagemController(String origemInformado, String destinoInformado, String dataDigitada, String valorDigitado,String poltronaSelecionada,String numero_cartaoSelecionado, String titular_cartaoSelecionado){
			
		String mensagem = "";

		if(origemInformado == null) {
			mensagem += "Origem deve ser selecionada \n";
		}

		if(destinoInformado == null) {
			mensagem += "Destino deve ser selecionado \n";
		}
		
		if(dataDigitada.isEmpty() || dataDigitada.trim().length() != 8) {
			mensagem += "Data deve possuir 8 dígitos no formato dd/mm/yyyy \n";
		}

		if(valorDigitado.isEmpty() ) {
			mensagem += "valor  não pode constar vazio \n";
		}
		if(poltronaSelecionada == null) {
			mensagem += "Poltrona  não pode constar vazio \n";
		}
		if(numero_cartaoSelecionado.isEmpty() || numero_cartaoSelecionado.trim().length() != 16 ) {
			mensagem += "cartao deve possuir 16 dígitos \n";
		}
		if(titular_cartaoSelecionado.isEmpty() || titular_cartaoSelecionado.trim().length() !=3 ) {
			mensagem += "Titular deve possuir no mínimo 3 letras \n";
		}
		return mensagem;
	}
  public PassagemVO salvar(PassagemVO passagemVO){
	    PassagemBO passagemBO = new PassagemBO();
	    return passagemBO.cadastrarPassagemBO(passagemVO);
  }

}


