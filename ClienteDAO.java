package model.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.ClienteVO;

public class ClienteDAO implements BaseDAO<ClienteVO>{

	public ClienteVO salvar(ClienteVO clienteVO) {
		  Connection conn = Banco.getConnection();
			
			Statement stmt = Banco.getStatement(conn);
			
			int resultado =0;
			
			String query = "INSERT INTO cliente (nome, cpf, telefone, email) "
			+ " VALUES ('"
			+ clienteVO.getNome() + "','"
			+ clienteVO.getCpf()+"','"
			+ clienteVO.getTelefone()+"','"
			+ clienteVO.getEmail();
			
			
			
			try {
				
				 resultado = stmt.executeUpdate(query);
				
			} catch (SQLException e) {
				
				
				System.out.println("Erro ao executar a query de cadastro do  cliente");
				System.out.println("Erro: " + e.getMessage() );
				
			} finally {
				
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
				
				
			}
			
			
			return clienteVO; 
			
			}
		
	

	public boolean excluir(int id) {
Connection conn = Banco.getConnection();
		
		Statement stmt = Banco.getStatement(conn);
		
		int resultado = 0;
		
		String query = "DELETE FROM cliente WHERE idcliente = "
		+id;
		
		try {
			
			 resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			
			
			System.out.println("Erro ao executar a query de exclusão do  cliente");
			System.out.println("Erro: " + e.getMessage() );
			
		} finally {
			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
			
		}
		
		
		
		return resultado>0;
	}


	
	public boolean alterar(ClienteVO clienteVO) {
		  Connection conn = Banco.getConnection();
			
			Statement stmt = Banco.getStatement(conn);
			
			int resultado = 0;
			
			String query = "UPDATE  cliente SET nome =  '"+clienteVO.getNome()+"', Cpf = '"
			                                               +clienteVO.getCpf()+"', telefone = '"
					                                        +clienteVO.getTelefone()+"', email = '"
			                                                 +clienteVO.getEmail() 
					                                         +"' WHERE idusuario =  "
					                                            +clienteVO.getIdCliente();
			
			try {
				
				 resultado = stmt.executeUpdate(query);
				
			} catch (SQLException e) {
				
				
				System.out.println("Erro ao executar a query de atualização do  usuário");
				System.out.println("Erro: " + e.getMessage() );
				
			} finally {
				
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
				
				
			}
			
			
			
			return resultado > 0;
			
	}


	
	public ClienteVO consultarPorId(int id) {
		 Connection conn = Banco.getConnection();
			
		   Statement stmt = Banco.getStatement(conn);
		
		   ResultSet resultado = null;
		   
		   ClienteVO cliente = new ClienteVO();
		   
		   String query = "SELECT idcliente, nome, cpf, telefone, email FROM cliente WHERE idcliente = " +id;
		   
		   
		   try {
			   
			resultado = stmt.executeQuery(query);
			
			while(resultado.next()) {
				   
				   
				   cliente.setIdCliente(resultado.getInt(1));
				   cliente.setNome(resultado.getString(2));
				   cliente.setCpf(resultado.getString(3));
				   cliente.setTelefone(resultado.getString(4));
				   cliente.setEmail(resultado.getString(5));
				   
				   
				      
					
				}
			
			
			
		} catch (SQLException e) {
			
			System.out.println("Erro ao executar a query de consulta do cliente");
			System.out.println("Erro:   "    +e.getMessage());
		} finally {
			
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		   
		return cliente;
		
	}



	@Override
	public ArrayList<ClienteVO> consultarTodos() {
		
		 Connection conn = Banco.getConnection();
			
		   Statement stmt = Banco.getStatement(conn);
		
		   ResultSet resultado = null;
		   
		   ArrayList<ClienteVO> clientesVO = new ArrayList<ClienteVO>();
		   
		   String query = "SELECT idcliente, nome, cpf, telefone, email FROM cliente";
		   
		   try {
			resultado = stmt.executeQuery(query);
			
			while(resultado.next()) {
			   ClienteVO clienteVO = new ClienteVO();
			   
			   clienteVO.setIdCliente(resultado.getInt(1));
			   clienteVO.setNome(resultado.getString(2));
			   clienteVO.setCpf(resultado.getString(3));
			   clienteVO.setTelefone(resultado.getString(4));
			   clienteVO.setEmail(resultado.getString(5));
			  
			   
			   clientesVO.add(clienteVO);   
		
	}	
			
			
		} catch (SQLException e) {
			
			System.out.println("Erro ao executar a query de consulta de todos os clientes");
			System.out.println("Erro:   "    +e.getMessage());
		} finally {
			
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		   
		return clientesVO;
			
		   
		   }
	public boolean verificaRegistroPorIdCliente(int idCliente) {
		
        Connection conn = Banco.getConnection();
		
		   Statement stmt = Banco.getStatement(conn);
		
		   ResultSet resultado = null;
		
		String query = "SELECT idcliente FROM cliente WHERE idcliente = " + idCliente;
		
		try {
			
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
				
			}
		} catch (SQLException e) {
			
			System.out.println("Erro ao executar a query que verifica a existência de um cliente por ID");
			System.out.println("Erro: " + e.getMessage() );
			
		} finally {
			
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
	
		return false;
	}

	public boolean existeRegistroPorCpf(String cpf) {
          Connection conn = Banco.getConnection();
		
		Statement stmt = Banco.getStatement(conn);
		
		ResultSet resultado = null;
		
		String query = "SELECT CPF FROM cliente WHERE cpf = '"+ cpf +"'";
		
		try {
			
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
				
			}
		} catch (SQLException e) {
			
			System.out.println("Erro ao executar a query que verifica a existência de um cliente por CPF");
			System.out.println("Erro: " + e.getMessage() );
			
		} finally {
			
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		
		return false;
	}




	
}

	
		
	


	

