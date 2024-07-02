package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class TelaLogin {

	private JFrame contentPane;
	private JTextField tfLogin;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.contentPane.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		contentPane = new JFrame();
		contentPane.setTitle("Tela de Login");
		contentPane.getContentPane().setBackground(new Color(192, 192, 192));
		contentPane.setBounds(100, 100, 710, 403);
		contentPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(219, 243, 255));
		panel.setBounds(159, 67, 387, 249);
		contentPane.getContentPane().add(panel);
		panel.setLayout(null);

		tfLogin = new JTextField();
		tfLogin.setBounds(62, 93, 257, 23);
		panel.add(tfLogin);
		tfLogin.setColumns(10);

		pfSenha = new JPasswordField();
		pfSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkLogin();
				}

			}

		});
		pfSenha.setBounds(62, 147, 257, 23);
		panel.add(pfSenha);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBackground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Cambria", Font.BOLD, 12));
		lblLogin.setBounds(62, 63, 46, 23);
		panel.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Cambria", Font.BOLD, 12));
		lblSenha.setBounds(62, 126, 46, 23);
		panel.add(lblSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Cambria", Font.BOLD, 12));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();

			}

		});
		btnEntrar.setBounds(62, 180, 99, 23);
		panel.add(btnEntrar);

		JLabel lblLawyers = new JLabel("LAWYER'S");
		lblLawyers.setForeground(new Color(49, 49, 85));
		lblLawyers.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblLawyers.setBackground(new Color(244, 252, 255));
		lblLawyers.setBounds(137, 22, 99, 31);
		panel.add(lblLawyers);

		JLabel lblSimbolo = new JLabel("");
		lblSimbolo.setBounds(103, 9, 46, 44);
		panel.add(lblSimbolo);

		JLabel lblNovoCadastro = new JLabel("<html><u>Clique aqui se ainda não está cadastrado</u></html>");
		lblNovoCadastro.setFocusable(true);
		lblNovoCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) { // single click
					// perform action on click
					System.out.println("Label clicked!");
					JOptionPane.showMessageDialog(null,
							"ATENÇÃO! Cadastro destinado a pessoas físicas que estejam com demandas "
									+ "em PROCESSOS JUDICIAIS no estritório.",
							"Cadastro de Usuário Externo", JOptionPane.OK_CANCEL_OPTION);
				}
			}
		});

		lblNovoCadastro.setFont(new Font("Cambria", Font.PLAIN, 12));
		lblNovoCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoCadastro.setBounds(79, 213, 228, 13);
		panel.add(lblNovoCadastro);

		JButton btnEsqueciSenha = new JButton("Esqueci a senha");
		btnEsqueciSenha.setFont(new Font("Cambria", Font.BOLD, 12));
		btnEsqueciSenha.setBounds(176, 181, 143, 21);
		panel.add(btnEsqueciSenha);

	}

	private void checkLogin() {
		String senhaCorreta = "admin";
		String loginCorreto = "admin";

		String tentativaLogin = tfLogin.getText();
		String tentativaSenha = new String(pfSenha.getPassword());

		if (tfLogin.getText() != null && !tfLogin.getText().isEmpty() && pfSenha.getPassword() != null
				&& !pfSenha.getPassword().toString().isEmpty()) {
			if (tentativaLogin.equals(loginCorreto) && tentativaSenha.equals(tentativaSenha)) {
				abrirPainelPrincipal();

			}
		} else {

		}

	}

	private void abrirPainelPrincipal() {
		TelaCadastro telaPrincipal = new TelaCadastro();
		telaPrincipal.setLocationRelativeTo(telaPrincipal);
		telaPrincipal.setVisible(true);
		contentPane.dispose();

	}
}
