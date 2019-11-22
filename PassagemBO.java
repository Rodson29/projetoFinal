package model.bo;

import model.dao.ClienteDAO;
import model.dao.PassagemDAO;
import model.vo.ClienteVO;
import model.vo.PassagemVO;

public class PassagemBO {

	public PassagemVO cadastrarPassagemBO(PassagemVO passagemVO) {
		 
			
			PassagemDAO dao = new PassagemDAO();
			
			return dao.salvar(passagemVO);
		}
		
	public String adicionarPassageiroBO(int lugar,ClienteVO c) {
	  int poltronas[] = new int[42];
             PassagemDAO dao = new PassagemDAO();
              if(lugar<this.poltronas[].length && lugar>=0){
            	  if(poltronas[lugar]==0){
            		  PassagemVO passagem = new PassagemVO();
            		  passagem.setCliente(c);
            		  this.adicionarPassageiroBO(lugar, c);
            		  return dao.adicionarPassageiroDAO();
            		  
            		  }else {
            			  return null;
              }
      }

		
	}

}
