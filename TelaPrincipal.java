package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setFont(new Font("Verdana", Font.ITALIC, 18));
		setTitle("SEIXAS BUS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 355);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cliente");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mnNewMenu.add(mntmCadastrar);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mnNewMenu.add(mntmAlterar);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mnNewMenu.add(mntmExcluir);
		
		JMenu mnNewMenu_1 = new JMenu("Passagem");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mnNewMenu_1.add(mntmCadastrar_1);
		
		JMenuItem mntmAlterar_1 = new JMenuItem("Alterar");
		mnNewMenu_1.add(mntmAlterar_1);
		
		JMenuItem mntmExcluir_1 = new JMenuItem("Excluir");
		mnNewMenu_1.add(mntmExcluir_1);
		
		JMenuItem mntmComprar = new JMenuItem("Comprar");
		mnNewMenu_1.add(mntmComprar);
		
		JMenu mnConsultarPassagem = new JMenu("Consultar Passagem");
		menuBar.add(mnConsultarPassagem);
		
		JMenuItem mntmConsultarTodos = new JMenuItem("Consultar Todas");
		mntmConsultarTodos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/procurar.png")));
		mnConsultarPassagem.add(mntmConsultarTodos);
		
		JMenuItem mntmConsultarPoltronas = new JMenuItem("Consultar Poltronas");
		mnConsultarPassagem.add(mntmConsultarPoltronas);
		
		JMenuItem mntmConsultarHorriosdatas = new JMenuItem("Consultar Hor\u00E1rios/Destinos");
		mnConsultarPassagem.add(mntmConsultarHorriosdatas);
		
		JMenu mnConsultarCliente = new JMenu("Consultar Cliente");
		menuBar.add(mnConsultarCliente);
		
		JMenuItem mntmConsultarTodos_1 = new JMenuItem("Consultar Todos");
		mnConsultarCliente.add(mntmConsultarTodos_1);
		
		JMenuItem mntmConsultarPassageiro = new JMenuItem("Consultar Passageiro");
		mnConsultarCliente.add(mntmConsultarPassageiro);
		
		JMenu mnNewMenu_2 = new JMenu("Sobre");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ajuda");
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenuItem mntmRelatorios = new JMenuItem("Relatorios");
		mnNewMenu_2.add(mntmRelatorios);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
