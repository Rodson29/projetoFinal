package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ControllerCliente;
import controller.ControllerPassagem;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

public class TelaCompraPassagem extends JPanel {
	private JTextField txtData;
	private JTextField txtValor;
	private JLabel lblValor;
	private JTextField txtNumero_Cartao;
	private JTextField txtTitular_Cartao;

	/**
	 * Create the panel.
	 */
	public TelaCompraPassagem() {
		setLayout(null);
		
		JLabel lblOrigem = new JLabel("Origem:");
		lblOrigem.setFont(new Font("Arial", Font.PLAIN, 14));
		lblOrigem.setBounds(10, 76, 79, 14);
		add(lblOrigem);
		
		JComboBox cbOrigem = new JComboBox();
		cbOrigem.setBounds(80, 74, 142, 20);
		add(cbOrigem);
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDestino.setBounds(247, 76, 52, 14);
		add(lblDestino);
		
		JComboBox cbDestino = new JComboBox();
		cbDestino.setBounds(309, 74, 158, 20);
		add(cbDestino);
		
		JLabel lblComprarPassagem = new JLabel("COMPRAR PASSAGEM");
		lblComprarPassagem.setFont(new Font("Calibri", Font.BOLD, 18));
		lblComprarPassagem.setBounds(151, 23, 190, 14);
		add(lblComprarPassagem);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Arial", Font.PLAIN, 14));
		lblData.setBounds(10, 127, 74, 14);
		add(lblData);
		
		txtData = new JTextField();
		txtData.setBounds(80, 125, 104, 20);
		add(txtData);
		txtData.setColumns(10);
		
		JLabel lblPoltrona = new JLabel("Poltrona:");
		lblPoltrona.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPoltrona.setBounds(39, 176, 86, 14);
		add(lblPoltrona);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(117, 174, 162, 20);
		add(comboBox_2);
		
		JButton btnFinalizarCompra = new JButton("Finalizar Compra");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 String origemInformada = (String) cbOrigem.getSelectedItem();
				 String destinoInformado = (String) cbDestino.getSelectedItem();
			     String dataDigitada = txtData.getText();
			     String valorDigitado = txtValor.getText();
			     String poltronasSelecionada =  (String) cbDestino.getSelectedItem();
			       String Tipo_pgto ="";
			         if(rdbCartao_Credito.isSelected()){
			    	 
			    	   Tipo_pgto= "Cartão de Crédito foi selecionado";
			    	 
			    	   }else if(rdbCartao_Debito.isSelected()){
			    	 
			    		   Tipo_pgto= "Cartão de Débito foi selecionado";
			    	 
			    	   }
			     String numero_cartaoSelecionado = txtNumero_Cartao.getText();
			     String titular_cartaoSelecionado = txtTitular_Cartao.getText();
			      
				
				String mensagem = 
						ControllerPassagem.cadastrarPassagemController(origemInformada, destinoInformado,dataDigitada,valorDigitado,poltronasSelecionada,numero_cartaoSelecionado, titular_cartaoSelecionado );
		
				
			}
		});
		btnFinalizarCompra.setFont(new Font("Arial", Font.PLAIN, 16));
		btnFinalizarCompra.setBounds(134, 380, 207, 40);
		add(btnFinalizarCompra);
		
		lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Arial", Font.PLAIN, 14));
		lblValor.setBounds(253, 127, 46, 14);
		add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(292, 125, 103, 20);
		add(txtValor);
		txtValor.setColumns(10);
		
		JRadioButton rdbCartao_Credito = new JRadioButton("Cartao Credito");
		rdbCartao_Credito.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbCartao_Credito.setBounds(194, 224, 133, 23);
		add(rdbCartao_Credito);
		
		JRadioButton rdbCartao_Debito = new JRadioButton("Cartao Debito");
		rdbCartao_Debito.setFont(new Font("Arial", Font.PLAIN, 14));
		rdbCartao_Debito.setBounds(329, 224, 142, 23);
		add(rdbCartao_Debito);
		
		JLabel lblNumero_Cartao = new JLabel("Numero Cartao:");
		lblNumero_Cartao.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNumero_Cartao.setBounds(80, 271, 104, 14);
		add(lblNumero_Cartao);
		
		MaskFormatter mascaraCartao;
		try {
			mascaraCartao = new MaskFormatter("####.####.####-####");
		}catch (ParseException e){

		}
		
		txtNumero_Cartao = new JTextField();
		txtNumero_Cartao.setBounds(228, 269, 198, 20);
		add(txtNumero_Cartao);
		txtNumero_Cartao.setColumns(10);
		
		JLabel lblTitular_Cartao = new JLabel("Titular Cartao:");
		lblTitular_Cartao.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTitular_Cartao.setBounds(80, 315, 104, 14);
		add(lblTitular_Cartao);
		
		txtTitular_Cartao = new JTextField();
		txtTitular_Cartao.setBounds(228, 313, 198, 20);
		add(txtTitular_Cartao);
		txtTitular_Cartao.setColumns(10);
		
		JLabel lblTipo_Pgto = new JLabel("TIPO PAGAMENTO:");
		lblTipo_Pgto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTipo_Pgto.setBounds(51, 228, 133, 14);
		add(lblTipo_Pgto);

	}
}
