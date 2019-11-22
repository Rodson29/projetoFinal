package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.vo.ClienteVO;
import model.vo.PassagemVO;

public class PassagemDAO implements BaseDAO<PassagemVO> {
	
	
	
	


	public PassagemVO salvar(PassagemVO novaPassagemVO) {
		Connection conn = Banco.getConnection();
		
		Statement stmt = Banco.getStatement(conn);
		
		int resultado =0;
		
		String query = "INSERT INTO usuario (origem, destino, data, poltronas, valor, tipo_pgto, titular_cartao, numero_cartao) "
		+ " VALUES ('"
		+novaPassagemVO.getOrigem() + "','"
		+ novaPassagemVO.getDestino()+"','"
		+ novaPassagemVO.getData()+"','"
		+ novaPassagemVO.getPoltronas() + "','"
		+ novaPassagemVO.getValor() + "','"
		+ novaPassagemVO.getTipo_pgto() + "','"
		+ novaPassagemVO.getTitular_cartao() + "','"
		+ novaPassagemVO.getNumero_cartao();
		
		
		
		
		try {
			
			 resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			
			
			System.out.println("Erro ao executar a query de cadastro do  cliente");
			System.out.println("Erro: " + e.getMessage() );
			
		} finally {
			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
			
		}
		
		
		return novaPassagemVO; 
		
	}

	
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();

		Statement stmt = Banco.getStatement(conn);

		int resultado = 0;

		String query = "DELETE FROM cliente WHERE idcliente = "
		+ id;

		try {
			
			 resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			
			
			System.out.println("Erro ao executar a query de exclusão do  cliente");
			System.out.println("Erro: " + e.getMessage() );
			
		} finally {
			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
			
		}



		return resultado > 0;
		
	}

	public boolean alterar(PassagemVO passagemVO) {
			Connection conn = Banco.getConnection();
				
				Statement stmt = Banco.getStatement(conn);
				
				int resultado = 0;
				
				String query = "UPDATE  passagem SET origem =  '"+passagemVO.getOrigem()+"', Destino = '"
				                                               +passagemVO.getDestino()+"', data = '"
						                                        +passagemVO.getData()+"', poltronas = '"
				                                                 +passagemVO.getPoltronas()+"',valor = '"
				                                                 +passagemVO.getValor()+"', tipo_pgto = '"
				 				                                   +passagemVO.getTipo_pgto()+"', titular_cartao = '"
				 		                                            +passagemVO.getTitular_cartao()+"', numero_cartao = '" 
				 		                                           +passagemVO.getNumero_cartao()
						                                         +"' WHERE idusuario =  "
						                                            +passagemVO.getIdPassagem();
				
				try {
					
					 resultado = stmt.executeUpdate(query);
					
				} catch (SQLException e) {
					
					
					System.out.println("Erro ao executar a query de atualização do  usuário");
					System.out.println("Erro: " + e.getMessage() );
					
				} finally {
					
					Banco.closeStatement(stmt);
					Banco.closeConnection(conn);
					
					
				}
				
				
				
				return resultado>0;
	}

	

	
	

public PassagemVO consultarPorId(int idpassagem) {
	
	   Connection conn = Banco.getConnection();
		
	   Statement stmt = Banco.getStatement(conn);
	
	   ResultSet resultado = null;
	   
	   PassagemVO passagem = new PassagemVO();
	   
	   String query = "SELECT idpassagem, origem, destino, data, poltronas, valor, tipo_pgto, titular_pgto, numero_cartao FROM passagem WHERE idpassagem = "+passagem.getIdPassagem();
	   
	   
	   try {
		   
		resultado = stmt.executeQuery(query);
		
		while(resultado.next()) {
			   
			   
			   passagem.setIdPassagem(resultado.getInt(1));
			   passagem.setOrigem(resultado.getString(2));
			   passagem.setDestino(resultado.getString(3));
			   passagem.setData(LocalDate.parse(resultado.getString(4)));
			   if (resultado.getString(5) != null) {
					passagem.setPoltronas(resultado.getString(5));
			   passagem.setValor(Double.parseDouble(resultado.getString(3)));
			   passagem.setTipo_pgto(resultado.getString(3));
			   passagem.setTitular_cartao(resultado.getString(3));
			   passagem.setNumero_cartao(resultado.getString(3));
			   
			   
			      
				
			}
		
		}
		
	} catch (SQLException e) {
		
		System.out.println("Erro ao executar a query de consulta da passagem");
		System.out.println("Erro:   "    +e.getMessage());
	} finally {
		
		Banco.closeResultSet(resultado);
		Banco.closeStatement(stmt);
		Banco.closeConnection(conn);
	}
	   
	return passagem;
}


public ArrayList<PassagemVO>consultarTodos() {
	
	  Connection conn = Banco.getConnection();
		
	   Statement stmt = Banco.getStatement(conn);
	
	   ResultSet resultado = null;
	   
	   ArrayList<PassagemVO> passagensVO = new ArrayList<PassagemVO>();
	   
	   String query = "SELECT * FROM passagem";
	   
	   try {
		   
		resultado = stmt.executeQuery(query);
		
		while(resultado.next()) {
		   PassagemVO passagemVO = new PassagemVO();
		   
		   passagemVO.setIdPassagem(resultado.getInt(1));
		   passagemVO.setOrigem(resultado.getString(2));
		   passagemVO.setDestino(resultado.getString(3));
		   passagemVO.setData(LocalDate.parse(resultado.getString(4)));
		   passagemVO.setPoltronas(resultado.getString(5));
		   passagemVO.setValor(Double.parseDouble(resultado.getString(6)));
		   passagemVO.setTipo_pgto(resultado.getString(7));
		   passagemVO.setTitular_cartao(resultado.getString(8));
		   passagemVO.setNumero_cartao(resultado.getString(9));


		  
		   
		   passagensVO.add(passagemVO);   
			
		}
		
		
	} catch (SQLException e) {
		
		System.out.println("Erro ao executar a query de consulta de todas as passagens");
		System.out.println("Erro:   "    +e.getMessage());
	} finally {
		
		Banco.closeResultSet(resultado);
		Banco.closeStatement(stmt);
		Banco.closeConnection(conn);
	}
	   
	return passagensVO;

	}


public ArrayList<PassagemVO> adicionarPassageiroDAO(int lugar,ClienteVO c) {
	
	Connection conn = Banco.getConnection();
	Statement stmt = Banco.getStatement(conn);
	ResultSet resultado = null;
	String query = "SELECT poltronas from Passagem WHERE poltrona.lugar =" +c ;
	return null;
	
}
 
}


	
	