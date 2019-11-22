package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;

public class TelaLogin extends JInternalFrame {
	private JTextField txtLogin;
	private JPasswordField passwordSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(50, 87, 64, 14);
		getContentPane().add(lblCliente);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(50, 106, 184, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setBounds(50, 148, 46, 14);
		getContentPane().add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Arial", Font.ITALIC, 14));
		btnEntrar.setBounds(176, 218, 89, 41);
		getContentPane().add(btnEntrar);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(50, 173, 184, 20);
		getContentPane().add(passwordSenha);

	}
}
