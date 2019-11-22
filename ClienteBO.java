package model.bo;

import java.util.ArrayList;

import model.dao.ClienteDAO;

import model.vo.ClienteVO;


public class ClienteBO {

	public ClienteVO cadastrarClienteBO(ClienteVO clienteVO) {
		ClienteDAO clienteDAO = new ClienteDAO();
		if (clienteDAO.existeRegistroPorCpf(clienteVO.getCpf())) {
			System.out.println("\nCliente j� Cadastrado");
		} else {
			clienteVO = clienteDAO.salvar(clienteVO);
			if (clienteVO.getIdCliente() > 0) {
				System.out.println("\nCliente cadastrado com Sucesso.");
			} else {
				System.out.println("\nN�o foi poss�vel cadastrar o Cliente.");
			}
		}
	

		return clienteVO;
	}

	public void excluirUsuarioBO(ClienteVO clienteVO) {
		ClienteDAO clienteDAO = new ClienteDAO();
		if (clienteDAO.verificaRegistroPorIdCliente(clienteVO.getIdCliente())) {
			boolean conseguiuExcluir = clienteDAO.excluir(clienteVO.getIdCliente());
			if (conseguiuExcluir) {
				System.out.println("\nCliente exclu�do com Sucesso.");
			} else {
				System.out.println("\nN�o foi poss�vel excluir o Cliente.");
			}
		} else {
			System.out.println("\nCliente n�o existe na base da dados.");
		}
	}

	public void atualizarClienteBO(ClienteVO clienteVO) {
		ClienteDAO clienteDAO = new ClienteDAO();
		if (clienteDAO.verificaRegistroPorIdCliente(clienteVO.getIdCliente())) {
			boolean alterou = clienteDAO.alterar(clienteVO);
			if (alterou) {
				System.out.println("\nCliente atualizado com Sucesso.");
			} else {
				System.out.println("\nN�o foi poss�vel atualizar o Cliente.");
			}
		} else {
			System.out.println("\nCliente ainda n�o foi cadastrado.");
		}
	}

	public ArrayList<ClienteVO> consultarClientesBO() {
		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<ClienteVO> clientesVO = clienteDAO.consultarTodos();
		if (clientesVO.isEmpty()) {
			System.out.println("\nLista de Clientes est� vazia.");
		}
		return clientesVO;
	}

	public ClienteVO consultarClienteBO(ClienteVO clienteVO) {
		ClienteDAO clienteDAO = new ClienteDAO();
		ClienteVO cliente = clienteDAO.consultarPorId(clienteVO.getIdCliente());
		if (clienteVO == null) {
			System.out.println("\nCliente n�o Localizado.");
		}
		return clienteVO;
	}
}

