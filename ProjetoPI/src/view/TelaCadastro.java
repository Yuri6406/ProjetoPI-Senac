package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import controller.AdvogadoDao;
import controller.ClienteFisicoDao;
import controller.ClienteJuridicoDao;
import model.Advogado;
import model.ClienteFisico;
import model.ClienteJuridico;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastro {

	private JFrame frame;
	private JPanel painelCltF;
	private JTextField textNomeCltF;
	private JTextField textCpf;
	private JTextField textLogCltF;
	private JTextField textNumCasa;
	private JTextField textBairroCltF;
	private JTextField textCidadeCltF;
	private JTextField textTelCltF;
	private JTextField textEmailCltF;
	private JTextField textCepCltF;
	private JTextField textEstadoCltJ;
	private JTextField textEstadoCltF;
	private JTextField textRSocial;
	private JTextField textCnpj;
	private JTextField textLogradouroCltJ;
	private JTextField textNumCsCltJ;
	private JTextField textBairroCltJ;
	private JTextField textCidadeCltJ;
	private JTextField textTelCltJ;
	private JTextField textEmailCltJ;
	private JTextField textCepCltJ;
	private JTextField textNomeAdv;
	private JTextField textNumOAB;
	private JTextField textLogAgv;
	private JTextField textNunCs;
	private JTextField textBairroAdv;
	private JTextField textCidadeAdv;
	private JTextField textTelAdv;
	private JTextField textEmailAdv;
	private JTextField textCepAdv;
	private JTextField textEspecializacao;
	private JTextField textEstadoAdv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 716, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(176, 107, 520, 335);
		panel.setBackground(new Color(213, 241, 255));
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));

		JPanel layeredPane;
		painelCltF = new JPanel();
		painelCltF.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 192), new Color(0, 128, 192),
				new Color(0, 128, 192), new Color(0, 128, 192)));
		painelCltF.setBackground(new Color(251, 254, 255));
		panel.add(painelCltF, "tela1");
		painelCltF.setLayout(null);

		// Cliente Físico

		JLabel lblCadastroCltF = new JLabel("    Cliente F\u00EDsico");
		lblCadastroCltF.setForeground(new Color(0, 128, 192));
		lblCadastroCltF.setBackground(new Color(0, 128, 192));
		lblCadastroCltF.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblCadastroCltF.setBounds(166, 0, 135, 40);
		painelCltF.add(lblCadastroCltF);

		JLabel lblNomeCltF = new JLabel("Nome:");
		lblNomeCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNomeCltF.setBounds(20, 38, 45, 13);
		painelCltF.add(lblNomeCltF);

		textNomeCltF = new JTextField();
		textNomeCltF.setBounds(20, 53, 304, 19);
		painelCltF.add(textNomeCltF);
		textNomeCltF.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCpf.setBounds(334, 34, 30, 20);
		painelCltF.add(lblCpf);

		textCpf = new JTextField();
		textCpf.setBounds(334, 53, 156, 19);
		painelCltF.add(textCpf);
		textCpf.setColumns(10);

		JLabel lblLogradouroCltF = new JLabel("Logradouro:");
		lblLogradouroCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblLogradouroCltF.setBounds(20, 134, 78, 19);
		painelCltF.add(lblLogradouroCltF);

		textLogCltF = new JTextField();
		textLogCltF.setBounds(20, 152, 115, 19);
		painelCltF.add(textLogCltF);
		textLogCltF.setColumns(10);

		JLabel lblNunCasa = new JLabel("N\u00BA:");
		lblNunCasa.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNunCasa.setBounds(146, 134, 22, 13);
		painelCltF.add(lblNunCasa);

		textNumCasa = new JTextField();
		textNumCasa.setBounds(145, 152, 39, 19);
		painelCltF.add(textNumCasa);
		textNumCasa.setColumns(10);

		JLabel lblBairroCltF = new JLabel("Bairro:");
		lblBairroCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblBairroCltF.setBounds(196, 134, 45, 13);
		painelCltF.add(lblBairroCltF);

		textBairroCltF = new JTextField();
		textBairroCltF.setColumns(10);
		textBairroCltF.setBounds(196, 152, 128, 19);
		painelCltF.add(textBairroCltF);

		JLabel lblCidadeCltF = new JLabel("Cidade:");
		lblCidadeCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCidadeCltF.setBounds(20, 181, 45, 13);
		painelCltF.add(lblCidadeCltF);

		textCidadeCltF = new JTextField();
		textCidadeCltF.setColumns(10);
		textCidadeCltF.setBounds(20, 199, 129, 19);
		painelCltF.add(textCidadeCltF);

		JLabel lblEstadoCltF = new JLabel("Estado:");
		lblEstadoCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEstadoCltF.setBounds(158, 181, 45, 13);
		painelCltF.add(lblEstadoCltF);

		textEstadoCltF = new JTextField();
		textEstadoCltF.setBounds(158, 199, 166, 19);
		painelCltF.add(textEstadoCltF);
		textEstadoCltF.setColumns(10);

		JLabel lblTelCltF = new JLabel("Telefone:");
		lblTelCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblTelCltF.setBounds(20, 82, 78, 19);
		painelCltF.add(lblTelCltF);

		textTelCltF = new JTextField();
		textTelCltF.setColumns(10);
		textTelCltF.setBounds(20, 100, 129, 19);
		painelCltF.add(textTelCltF);

		JLabel lblEmailCltF = new JLabel("E-mail:");
		lblEmailCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEmailCltF.setBounds(158, 82, 45, 19);
		painelCltF.add(lblEmailCltF);

		textEmailCltF = new JTextField();
		textEmailCltF.setColumns(10);
		textEmailCltF.setBounds(158, 100, 166, 19);
		painelCltF.add(textEmailCltF);

		JLabel lblCepCltF = new JLabel("CEP:");
		lblCepCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCepCltF.setBounds(334, 134, 45, 13);
		painelCltF.add(lblCepCltF);

		textCepCltF = new JTextField();
		textCepCltF.setColumns(10);
		textCepCltF.setBounds(334, 152, 156, 19);
		painelCltF.add(textCepCltF);

		JButton btnCadCltF = new JButton("Cadastrar");
		btnCadCltF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Botão cadastra Pessoa Fisica
				cadastrarCltF();
			}
		});

		btnCadCltF.setForeground(Color.WHITE);
		btnCadCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		btnCadCltF.setBackground(new Color(0, 64, 128));
		btnCadCltF.setBounds(406, 296, 104, 29);
		painelCltF.add(btnCadCltF);

		JLabel lblDescCltF = new JLabel("Descri\u00E7\u00E3o:");
		lblDescCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblDescCltF.setBounds(20, 228, 66, 13);
		painelCltF.add(lblDescCltF);

		JTextPane textCltF = new JTextPane();
		textCltF.setBackground(UIManager.getColor("Slider.background"));
		textCltF.setBounds(20, 251, 359, 74);
		painelCltF.add(textCltF);

		JPanel painelCltJ = new JPanel();
		painelCltJ.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 192), new Color(0, 128, 192),
				new Color(0, 128, 192), new Color(0, 128, 192)));
		painelCltJ.setBackground(new Color(251, 254, 255));
		panel.add(painelCltJ, "tela2");
		painelCltJ.setLayout(null);

		JLabel lblRSocial = new JLabel("Raz\u00E3o Social:");
		lblRSocial.setFont(new Font("Cambria", Font.BOLD, 12));
		lblRSocial.setBounds(20, 38, 78, 13);
		painelCltJ.add(lblRSocial);

		textRSocial = new JTextField();
		textRSocial.setColumns(10);
		textRSocial.setBounds(20, 53, 304, 19);
		painelCltJ.add(textRSocial);

		JLabel lblCnpj = new JLabel("Cnpj:");
		lblCnpj.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCnpj.setBounds(334, 34, 30, 20);
		painelCltJ.add(lblCnpj);

		textCnpj = new JTextField();
		textCnpj.setColumns(10);
		textCnpj.setBounds(334, 53, 156, 19);
		painelCltJ.add(textCnpj);

		JLabel lblLogradouroCltJ = new JLabel("Logradouro:");
		lblLogradouroCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		lblLogradouroCltJ.setBounds(20, 134, 78, 19);
		painelCltJ.add(lblLogradouroCltJ);

		textLogradouroCltJ = new JTextField();
		textLogradouroCltJ.setColumns(10);
		textLogradouroCltJ.setBounds(20, 152, 115, 19);
		painelCltJ.add(textLogradouroCltJ);

		JLabel lblNunCsCltj = new JLabel("N\u00BA:");
		lblNunCsCltj.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNunCsCltj.setBounds(146, 134, 22, 13);
		painelCltJ.add(lblNunCsCltj);

		textNumCsCltJ = new JTextField();
		textNumCsCltJ.setColumns(10);
		textNumCsCltJ.setBounds(145, 152, 39, 19);
		painelCltJ.add(textNumCsCltJ);

		JLabel lblBairroCltJ = new JLabel("Bairro:");
		lblBairroCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		lblBairroCltJ.setBounds(196, 134, 45, 13);
		painelCltJ.add(lblBairroCltJ);

		textBairroCltJ = new JTextField();
		textBairroCltJ.setColumns(10);
		textBairroCltJ.setBounds(196, 152, 128, 19);
		painelCltJ.add(textBairroCltJ);

		JLabel lblCidadeCltJ = new JLabel("Cidade:");
		lblCidadeCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCidadeCltJ.setBounds(20, 181, 45, 13);
		painelCltJ.add(lblCidadeCltJ);

		textCidadeCltJ = new JTextField();
		textCidadeCltJ.setColumns(10);
		textCidadeCltJ.setBounds(20, 199, 129, 19);
		painelCltJ.add(textCidadeCltJ);

		JLabel lblEstadoCltJ = new JLabel("Estado:");
		lblEstadoCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEstadoCltJ.setBounds(158, 181, 45, 13);
		painelCltJ.add(lblEstadoCltJ);

		textEstadoCltJ = new JTextField();
		textEstadoCltJ.setBounds(159, 199, 165, 19);
		painelCltJ.add(textEstadoCltJ);
		textEstadoCltJ.setColumns(10);

		JLabel lblTelefoneCltJ = new JLabel("Telefone:");
		lblTelefoneCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		lblTelefoneCltJ.setBounds(20, 82, 78, 19);
		painelCltJ.add(lblTelefoneCltJ);

		textTelCltJ = new JTextField();
		textTelCltJ.setColumns(10);
		textTelCltJ.setBounds(20, 100, 129, 19);
		painelCltJ.add(textTelCltJ);

		JLabel lblEmailCltJ = new JLabel("E-mail:");
		lblEmailCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEmailCltJ.setBounds(158, 82, 45, 19);
		painelCltJ.add(lblEmailCltJ);

		textEmailCltJ = new JTextField();
		textEmailCltJ.setColumns(10);
		textEmailCltJ.setBounds(158, 100, 166, 19);
		painelCltJ.add(textEmailCltJ);

		JLabel lblCepCltJ = new JLabel("CEP:");
		lblCepCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCepCltJ.setBounds(334, 134, 45, 13);
		painelCltJ.add(lblCepCltJ);

		textCepCltJ = new JTextField();
		textCepCltJ.setColumns(10);
		textCepCltJ.setBounds(334, 152, 156, 19);
		painelCltJ.add(textCepCltJ);

		JButton btnCadCltJ = new JButton("Cadastrar");
		btnCadCltJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Botão cadastrar Pessoa Juridica
				cadastrarCltJ();

			}
		});

		btnCadCltJ.setForeground(Color.WHITE);
		btnCadCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		btnCadCltJ.setBackground(new Color(0, 64, 128));
		btnCadCltJ.setBounds(406, 296, 104, 29);
		painelCltJ.add(btnCadCltJ);

		JLabel lblNewLabel_3_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_3_1.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(20, 228, 66, 13);
		painelCltJ.add(lblNewLabel_3_1);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(UIManager.getColor("Button.background"));
		textPane_1.setBounds(20, 251, 359, 74);
		painelCltJ.add(textPane_1);

		JLabel lblClienteJurdico = new JLabel("    Cliente Jur\u00EDdico");
		lblClienteJurdico.setForeground(new Color(0, 128, 192));
		lblClienteJurdico.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblClienteJurdico.setBackground(new Color(0, 128, 192));
		lblClienteJurdico.setBounds(146, 0, 147, 40);
		painelCltJ.add(lblClienteJurdico);

		// Painel Advogado

		JPanel painelAdv = new JPanel();
		painelAdv.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 192), new Color(0, 128, 192),
				new Color(0, 128, 192), new Color(0, 128, 192)));
		painelAdv.setBackground(new Color(251, 254, 255));
		panel.add(painelAdv, "tela3");
		painelAdv.setLayout(null);

		JLabel nomeAdv = new JLabel("Nome:");
		nomeAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		nomeAdv.setBounds(20, 38, 78, 13);
		painelAdv.add(nomeAdv);

		textNomeAdv = new JTextField();
		textNomeAdv.setColumns(10);
		textNomeAdv.setBounds(20, 53, 304, 19);
		painelAdv.add(textNomeAdv);

		JLabel lblNunOAB = new JLabel("NumeroOAB:");
		lblNunOAB.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNunOAB.setBounds(334, 34, 78, 20);
		painelAdv.add(lblNunOAB);

		textNumOAB = new JTextField();
		textNumOAB.setColumns(10);
		textNumOAB.setBounds(334, 53, 156, 19);
		painelAdv.add(textNumOAB);

		JLabel lblLogradouroAdv = new JLabel("Logradouro:");
		lblLogradouroAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblLogradouroAdv.setBounds(20, 134, 78, 19);
		painelAdv.add(lblLogradouroAdv);

		textLogAgv = new JTextField();
		textLogAgv.setColumns(10);
		textLogAgv.setBounds(20, 152, 115, 19);
		painelAdv.add(textLogAgv);

		JLabel lblNunCs = new JLabel("N\u00BA:");
		lblNunCs.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNunCs.setBounds(146, 134, 22, 13);
		painelAdv.add(lblNunCs);

		textNunCs = new JTextField();
		textNunCs.setColumns(10);
		textNunCs.setBounds(145, 152, 39, 19);
		painelAdv.add(textNunCs);

		JLabel lblBairroAdv = new JLabel("Bairro:");
		lblBairroAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblBairroAdv.setBounds(196, 134, 45, 13);
		painelAdv.add(lblBairroAdv);

		textBairroAdv = new JTextField();
		textBairroAdv.setColumns(10);
		textBairroAdv.setBounds(196, 152, 128, 19);
		painelAdv.add(textBairroAdv);

		JLabel lblCidadeAdv = new JLabel("Cidade:");
		lblCidadeAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCidadeAdv.setBounds(20, 181, 45, 13);
		painelAdv.add(lblCidadeAdv);

		textCidadeAdv = new JTextField();
		textCidadeAdv.setColumns(10);
		textCidadeAdv.setBounds(20, 199, 129, 19);
		painelAdv.add(textCidadeAdv);

		JLabel lblEstadoAdv = new JLabel("Estado:");
		lblEstadoAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEstadoAdv.setBounds(158, 181, 45, 13);
		painelAdv.add(lblEstadoAdv);

		textEstadoAdv = new JTextField();
		textEstadoAdv.setBounds(159, 199, 165, 19);
		painelAdv.add(textEstadoAdv);
		textEstadoAdv.setColumns(10);

		JLabel lblTelefoneAdv = new JLabel("Telefone:");
		lblTelefoneAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblTelefoneAdv.setBounds(20, 82, 78, 19);
		painelAdv.add(lblTelefoneAdv);

		textTelAdv = new JTextField();
		textTelAdv.setColumns(10);
		textTelAdv.setBounds(20, 100, 129, 19);
		painelAdv.add(textTelAdv);

		JLabel lblEmailAdv = new JLabel("E-mail:");
		lblEmailAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEmailAdv.setBounds(158, 82, 45, 19);
		painelAdv.add(lblEmailAdv);

		textEmailAdv = new JTextField();
		textEmailAdv.setColumns(10);
		textEmailAdv.setBounds(158, 100, 166, 19);
		painelAdv.add(textEmailAdv);

		JLabel lblCepAdv = new JLabel("CEP:");
		lblCepAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCepAdv.setBounds(334, 134, 45, 13);
		painelAdv.add(lblCepAdv);

		textCepAdv = new JTextField();
		textCepAdv.setColumns(10);
		textCepAdv.setBounds(334, 152, 156, 19);
		painelAdv.add(textCepAdv);

		JLabel lblEspeciAdv = new JLabel("Especializa\u00E7\u00F5es:");
		lblEspeciAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEspeciAdv.setBounds(334, 86, 95, 13);
		painelAdv.add(lblEspeciAdv);

		textEspecializacao = new JTextField();
		textEspecializacao.setBounds(334, 100, 156, 19);
		painelAdv.add(textEspecializacao);
		textEspecializacao.setColumns(10);

		JButton btnNewCadastrarAdv = new JButton("Cadastrar");
		btnNewCadastrarAdv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cadastro Advogado
				cadastrarAdvogado();

			}
		});
		btnNewCadastrarAdv.setForeground(Color.WHITE);
		btnNewCadastrarAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		btnNewCadastrarAdv.setBackground(new Color(0, 64, 128));
		btnNewCadastrarAdv.setBounds(386, 251, 104, 29);
		painelAdv.add(btnNewCadastrarAdv);

		JLabel lblCadastroAdv = new JLabel("Advogado");
		lblCadastroAdv.setForeground(new Color(0, 128, 192));
		lblCadastroAdv.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblCadastroAdv.setBackground(new Color(0, 128, 192));
		lblCadastroAdv.setBounds(163, 0, 135, 40);
		painelAdv.add(lblCadastroAdv);

		JButton btnNewButton = new JButton("Cliente F\u00EDsico");
		btnNewButton.setBounds(176, 88, 109, 22);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "tela1");

			}
		});
		frame.getContentPane().add(btnNewButton);

		JButton btnPainel = new JButton("Cliente Jur\u00EDdico");
		btnPainel.setBounds(284, 88, 112, 22);
		btnPainel.setFont(new Font("Calibri", Font.BOLD, 12));
		btnPainel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "tela2");
			}
		});
		frame.getContentPane().add(btnPainel);

		JButton btnNewButton_1_1 = new JButton("Advogado");
		btnNewButton_1_1.setBounds(396, 88, 95, 22);
		btnNewButton_1_1.setFont(new Font("Calibri", Font.BOLD, 12));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "tela3");
			}
		});
		frame.getContentPane().add(btnNewButton_1_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastros");
		mntmNewMenuItem.setBounds(10, 0, 156, 26);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		mntmNewMenuItem.setFont(new Font("Cambria", Font.PLAIN, 12));
		mntmNewMenuItem.setBackground(new Color(138, 217, 255));
		frame.getContentPane().add(mntmNewMenuItem);

		JMenuItem mntmAdvogados = new JMenuItem("Advogados");
		mntmAdvogados.setBounds(10, 23, 156, 26);
		mntmAdvogados.setFont(new Font("Cambria", Font.PLAIN, 12));
		mntmAdvogados.setBackground(new Color(138, 217, 255));
		frame.getContentPane().add(mntmAdvogados);

		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Agendamento");
		mntmNewMenuItem_1_1.setBounds(10, 48, 156, 26);
		mntmNewMenuItem_1_1.setFont(new Font("Cambria", Font.PLAIN, 12));
		mntmNewMenuItem_1_1.setBackground(new Color(138, 217, 255));
		frame.getContentPane().add(mntmNewMenuItem_1_1);

		JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("Lista de clientes");
		mntmNewMenuItem_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		mntmNewMenuItem_1_1_1.setBounds(10, 74, 156, 26);
		mntmNewMenuItem_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListaCltF clistaCltF = new ListaCltF(null);
				clistaCltF.setVisible(true);
				
				clistaCltF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mntmNewMenuItem_1_1_1.setFont(new Font("Cambria", Font.PLAIN, 12));
		mntmNewMenuItem_1_1_1.setBackground(new Color(138, 217, 255));
		frame.getContentPane().add(mntmNewMenuItem_1_1_1);

		JMenuItem mntmNewMenuItem_1_1_1_1 = new JMenuItem("Sair");
		mntmNewMenuItem_1_1_1_1.setBounds(10, 98, 156, 26);
		mntmNewMenuItem_1_1_1_1.setFont(new Font("Cambria", Font.PLAIN, 12));
		mntmNewMenuItem_1_1_1_1.setBackground(new Color(138, 217, 255));
		frame.getContentPane().add(mntmNewMenuItem_1_1_1_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(182, 0, 510, 78);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Usu\u00E1rio\\Downloads\\advogado.png"));
		frame.getContentPane().add(lblNewLabel_2);
	}

	public void cadastrarAdvogado() {
		AdvogadoDao dao = new AdvogadoDao();

		String nomeAdv = textNomeAdv.getText();
		String numOAB = textNumOAB.getText();
		String logAdv = textLogAgv.getText();
		String nunCasa = textNunCs.getText();
		String bairroAdv = textBairroAdv.getText();
		String cidadeAdv = textCidadeAdv.getText();
		String estadoAdv = textEstadoAdv.getText();
		String telAdv = textTelAdv.getText();
		String emailAdv = textEmailAdv.getText();
		String cepAdv = textCepAdv.getText();
		String espec = textEspecializacao.getText();
		Advogado advogado = new Advogado(nomeAdv, numOAB, espec, telAdv, emailAdv, cepAdv, logAdv, nunCasa, bairroAdv,
				cidadeAdv, estadoAdv);
		dao.Inserir(advogado);
	}

	public void cadastrarCltF() {
		ClienteFisicoDao dao = new ClienteFisicoDao();

		String nome = textNomeCltF.getText();
		String cpf = textCpf.getText();
		String tel = textCepCltF.getText();
		String email = textEmailCltF.getText();
		String cep = textCepCltF.getText();
		String logra = textLogCltF.getText();
		String nunCasa = textNumCasa.getText();
		String bairro = textBairroCltF.getText();
		String cidade = textCidadeCltF.getText();
		String estado = textEstadoCltF.getText();
		ClienteFisico CltF = new ClienteFisico(0, nome, cpf, tel, email, cep, logra, nunCasa, bairro, cidade, estado);

		dao.Inserir(CltF);
	}

	public void cadastrarCltJ() {
		ClienteJuridicoDao dao = new ClienteJuridicoDao();

		String razaoSocial = textRSocial.getText();
		String cnpj = textCnpj.getText();
		String tel = textCepCltJ.getText();
		String email = textEmailCltJ.getText();
		String cep = textCepCltJ.getText();
		String logra = textLogradouroCltJ.getText();
		String nunCasa = textNumCsCltJ.getText();
		String bairro = textBairroCltJ.getText();
		String cidade = textCidadeCltJ.getText();
		String estado = textEstadoCltJ.getText();
		ClienteJuridico CltJ = new ClienteJuridico(0, razaoSocial, cnpj, tel, email, cep, logra, nunCasa, bairro,
				cidade, estado);

		dao.Inserir(CltJ);
	}
}
