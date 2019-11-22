package model.vo;

import java.time.LocalDate;
import java.util.ArrayList;

public class PassagemVO {
	private int idPassagem;
	private ClienteVO cliente;
	private String origem;
	private String destino;
	private LocalDate data;
	private ArrayList<String> poltronas;
	private double valor;
	private String tipo_pgto;
	private String titular_cartao;
	private String numero_cartao;
	
	
	
	
	public PassagemVO(int idPassagem, ClienteVO cliente, String origem, String destino, LocalDate data,
			ArrayList<String> poltronas, double valor, String tipo_pgto, String titular_cartao, String numero_cartao) {
		super();
		this.idPassagem = idPassagem;
		this.cliente = cliente;
		this.origem = origem;
		this.destino = destino;
		this.data = data;
		this.poltronas = poltronas;
		this.valor = valor;
		this.tipo_pgto = tipo_pgto;
		this.titular_cartao = titular_cartao;
		this.numero_cartao = numero_cartao;
	}



	public ClienteVO getCliente() {
		return cliente;
	}



	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}



	public PassagemVO() {
		super();
		
	}
	public String getTipo_pgto() {
		return tipo_pgto;
	}
	public void setTipo_pgto(String tipo_pgto) {
		this.tipo_pgto = tipo_pgto;
	}
	public String getTitular_cartao() {
		return titular_cartao;
	}
	public void setTitular_cartao(String titular_cartao) {
		this.titular_cartao = titular_cartao;
	}
	public String getNumero_cartao() {
		return numero_cartao;
	}
	public void setNumero_cartao(String numero_cartao) {
		this.numero_cartao = numero_cartao;
	}
	public int getIdPassagem() {
		return idPassagem;
	}
	public void setIdPassagem(int idPassagem) {
		this.idPassagem = idPassagem;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public ArrayList<String> getPoltronas() {
		return poltronas;
	}
	public void setPoltronas(ArrayList<String> poltronas) {
		this.poltronas = poltronas;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	

}
