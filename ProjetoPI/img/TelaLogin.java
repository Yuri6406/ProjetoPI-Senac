package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel TelaLogin;
	private JLabel lblNovoUsuario;
	private JButton btnEntrar;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		TelaLogin = new JPanel();
		TelaLogin.setForeground(SystemColor.text);
		TelaLogin.setBackground(new Color(255, 238, 255));
		TelaLogin.setBorder(null);

		setContentPane(TelaLogin);
		TelaLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Cambria", Font.BOLD, 12));
		lblLogin.setBounds(135, 56, 45, 19);
		TelaLogin.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Cambria", Font.BOLD, 12));
		lblSenha.setBounds(135, 108, 45, 19);
		TelaLogin.add(lblSenha);
		
		lblNovoUsuario = new JLabel("Cadastrar novo usu\u00E1rio");
		lblNovoUsuario.setFont(new Font("Cambria", Font.PLAIN, 10));
		lblNovoUsuario.setBounds(161, 166, 106, 13);
		TelaLogin.add(lblNovoUsuario);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(SystemColor.activeCaption);
		btnEntrar.setForeground(new Color(255, 166, 255));
		btnEntrar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnEntrar.setBounds(135, 189, 173, 21);
		TelaLogin.add(btnEntrar);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(UIManager.getColor("PasswordField.background"));
		passwordField.setBounds(135, 137, 173, 19);
		TelaLogin.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(Color.WHITE);
		passwordField_1.setBounds(135, 79, 173, 19);
		TelaLogin.add(passwordField_1);
	}
}
