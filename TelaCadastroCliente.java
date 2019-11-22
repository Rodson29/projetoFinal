package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ControllerCliente;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroCliente extends JPanel {
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtCpf;

	/**
	 * Create the panel.
	 */
	public TelaCadastroCliente() {
		setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 80, 166, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(66, 111, 166, 20);
		add(txtCpf);
		txtCpf.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(66, 173, 166, 20);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(66, 142, 166, 20);
		add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNome.setBounds(10, 83, 46, 14);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCpf.setBounds(10, 110, 46, 14);
		add(lblCpf);
		
		MaskFormatter mascaraCpf;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(mascaraCpf);
			txtCpf.setBounds(400, 10, 100, 20);
			add(txtCpf);
			txtCpf.setColumns(10);
		}catch (ParseException e){

		}
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEmail.setBounds(10, 176, 46, 14);
		add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTelefone.setBounds(10, 145, 46, 14);
		add(lblTelefone);
		
		MaskFormatter mascaraTelefone;
		try {
			mascaraTelefone = new MaskFormatter("(##) #####-####");
			txtTelefone = new JFormattedTextField(mascaraTelefone);
			txtTelefone.setBounds(400, 10, 100, 20);
			add(txtTelefone);
			txtTelefone.setColumns(10);
		}catch (ParseException e){

		}

		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Cadastrar Cliente");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel.setBounds(158, 28, 199, 32);
		add(lblNewLabel);
		
			
				
				JButton btnNewButton = new JButton("Salvar");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						String nomeDigitado = txtNome.getText();
					     String cpfDigitado = txtCpf.getText().replace("-", "").replace(".", "");;
					     String telefoneDigitado = txtTelefone.getText();
					     String emailDigitado = txtEmail.getText();
					      
						
						String mensagem = 
								ControllerCliente.cadastrarClienteController(nomeDigitado, cpfDigitado,telefoneDigitado,emailDigitado);
				
					}
				});
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				btnNewButton.setFont(new Font("Arial", Font.ITALIC, 14));
				btnNewButton.setBounds(125, 228, 89, 32);
				add(btnNewButton);
		
		
		
		JLabel lblFundoCadastro = new JLabel("New label");
		lblFundoCadastro.setIcon(new ImageIcon(TelaCadastroCliente.class.getResource("/imagens/fundotelaLogin.png")));
		lblFundoCadastro.setBounds(-59, 8, 509, 289);
		add(lblFundoCadastro);
		
	
	}
	
}
