package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AdvogadoDao;
import controller.ClienteFisicoDao;
import controller.ClienteJuridicoDao;
import model.Advogado;
import model.ClienteFisico;
import model.ClienteJuridico;

public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
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
	private JTextField textEstadoCltF;
	private JTable tableCltF;

	private JTextField textEstadoCltJ;
	private JTextField textRSocial;
	private JTextField textCnpJ;
	private JTextField textLogradouroCltJ;
	private JTextField textNumCsCltJ;
	private JTextField textBairroCltJ;
	private JTextField textCidadeCltJ;
	private JTextField textTelCltJ;
	private JTextField textEmailCltJ;
	private JTextField textCepCltJ;
	private JTable tableCltJ;

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
	private JTable tableAdv;

	private List<ClienteJuridico> listaCltJ = new ArrayList<>();
	private ClienteJuridicoDao daoCltJ = new ClienteJuridicoDao();
	private List<ClienteFisico> listaCltF = new ArrayList<>();
	private ClienteFisicoDao daoCltF = new ClienteFisicoDao();
	private List<Advogado> listaAdv = new ArrayList<>();
	private AdvogadoDao daoAdv = new AdvogadoDao();
	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1222, 778);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(70, 189, 925, 519);
		panel.setBackground(new Color(213, 241, 255));
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		JPanel layeredPane;

		// Painel Lista Cliente Fisico
		JPanel painelListaCltF = new JPanel();
		painelListaCltF.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 192), new Color(0, 128, 192),
				new Color(0, 128, 192), new Color(0, 128, 192)));
		painelListaCltF.setBackground(new Color(251, 254, 255));
		panel.add(painelListaCltF, "tela4");
		painelListaCltF.setLayout(null);

		JScrollPane scrollCltF = new JScrollPane();
		scrollCltF.setBounds(56, 59, 822, 349);
		painelListaCltF.add(scrollCltF);

		tableCltF = new JTable();
		scrollCltF.setViewportView(tableCltF);

		tableCltF.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Id ", "Nome ", "Telefone ", "Email " }));
		painelListaCltF.add(scrollCltF);

		JButton btnListaCltF = new JButton("Lista Clientes");
		btnListaCltF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabelaCltF();
			}
		});
		btnListaCltF.setBounds(57, 418, 101, 21);
		painelListaCltF.add(btnListaCltF);

		JButton btnDeletarCltF = new JButton("Excluir");
		btnDeletarCltF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerCltF();
				atualizarTabelaCltF();
			}
		});
		btnDeletarCltF.setBounds(160, 418, 85, 21);
		painelListaCltF.add(btnDeletarCltF);

		JButton btnAlterarCltF = new JButton("Alterar");
		btnAlterarCltF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCltF();
				atualizarTabelaCltF();

			}
		});
		btnAlterarCltF.setBounds(249, 418, 85, 21);
		painelListaCltF.add(btnAlterarCltF);

		JLabel lblNewLabel = new JLabel("Clientes F\u00EDsicos");
		lblNewLabel.setForeground(new Color(0, 128, 192));
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 22));
		lblNewLabel.setBounds(371, 10, 177, 32);
		painelListaCltF.add(lblNewLabel);

		// Painel lista Cliente Juridico
		JPanel painelListaCltJ = new JPanel();
		painelListaCltJ.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 192), new Color(0, 128, 192),
				new Color(0, 128, 192), new Color(0, 128, 192)));
		painelListaCltJ.setBackground(new Color(251, 254, 255));
		panel.add(painelListaCltJ, "tela5");
		painelListaCltJ.setLayout(null);

		JScrollPane scrollPaneCltJ = new JScrollPane();
		scrollPaneCltJ.setBounds(57, 52, 811, 354);
		painelListaCltJ.add(scrollPaneCltJ);

		tableCltJ = new JTable();
		scrollPaneCltJ.setViewportView(tableCltJ);

		tableCltJ.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id ", "Razão Social ", "Telefone ", "Email " }));
		painelListaCltJ.add(scrollPaneCltJ);

		JButton btnListaCltJ = new JButton("Lista Clientes");
		btnListaCltJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabelaCltJ();
			}
		});
		btnListaCltJ.setBounds(54, 416, 133, 21);
		painelListaCltJ.add(btnListaCltJ);

		JButton btnDeletarCltJ = new JButton("Excluir");
		btnDeletarCltJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerCltJ();
				atualizarTabelaCltJ();
			}
		});
		btnDeletarCltJ.setBounds(197, 416, 85, 21);
		painelListaCltJ.add(btnDeletarCltJ);

		JButton btnAltCltJ = new JButton("Alterar");
		btnAltCltJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCltJ();
			}
		});

		btnAltCltJ.setBounds(292, 416, 85, 21);
		painelListaCltJ.add(btnAltCltJ);

		JLabel lblCltJ = new JLabel("Clientes Juridico");
		lblCltJ.setForeground(new Color(0, 128, 192));
		lblCltJ.setFont(new Font("Cambria", Font.BOLD, 18));
		lblCltJ.setBounds(384, 10, 177, 32);
		painelListaCltJ.add(lblCltJ);

		// Ppainel Lista de Advogado
		JPanel panelListaAdv = new JPanel();
		panelListaAdv.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 192), new Color(0, 128, 192),
				new Color(0, 128, 192), new Color(0, 128, 192)));
		panelListaAdv.setBackground(new Color(251, 254, 255));
		panel.add(panelListaAdv, "tela6");
		panelListaAdv.setLayout(null);

		JScrollPane scrollAdv = new JScrollPane();
		scrollAdv.setBounds(58, 52, 816, 342);
		panelListaAdv.add(scrollAdv);

		tableAdv = new JTable();
		scrollAdv.setViewportView(tableAdv);

		tableAdv.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "id", "Nome ", "OAB ", "E-mail ", "Área " }));
		panelListaAdv.add(scrollAdv);

		JButton btnListaAdv = new JButton("Lista Advogados");
		btnListaAdv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				atualizarTabelaAdv();
			}
		});
		btnListaAdv.setBounds(58, 420, 133, 21);
		panelListaAdv.add(btnListaAdv);

		JButton btnDeletarAdv = new JButton("Excluir");
		btnDeletarAdv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerAdv();
				atualizarTabelaAdv();
			}
		});
		btnDeletarAdv.setBounds(201, 420, 85, 21);
		panelListaAdv.add(btnDeletarAdv);

		JButton btnAlterarAdv = new JButton("Alterar");
		btnAlterarAdv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarAdv();
			}
		});
		btnAlterarAdv.setBounds(296, 420, 85, 21);
		panelListaAdv.add(btnAlterarAdv);

		JLabel lblAdv = new JLabel("Advogados");
		lblAdv.setForeground(new Color(0, 128, 192));
		lblAdv.setFont(new Font("Cambria", Font.BOLD, 18));
		lblAdv.setBounds(421, 10, 99, 32);
		panelListaAdv.add(lblAdv);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 128, 192));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBounds(0, 0, 179, 28);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Cadastrar");
		menuBar.add(mnNewMenu);
		mnNewMenu.setBackground(new Color(0, 128, 192));

		JButton btnNewButton_1_1 = new JButton("Advogado");
		mnNewMenu.add(btnNewButton_1_1);
		btnNewButton_1_1.setFont(new Font("Calibri", Font.BOLD, 12));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "tela1");
			}
		});

		JButton btnCltF = new JButton("Cliente F\u00EDsico");
		mnNewMenu.add(btnCltF);
		btnCltF.setFont(new Font("Calibri", Font.BOLD, 12));

		JButton btnPainel = new JButton("Cliente Jur\u00EDdico");
		mnNewMenu.add(btnPainel);
		btnPainel.setFont(new Font("Calibri", Font.BOLD, 12));

		JMenu mnLista = new JMenu("Listas");
		menuBar.add(mnLista);

		JMenuItem mntmAdvogados = new JMenuItem("Advogados");
		mnLista.add(mntmAdvogados);
		mntmAdvogados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "tela6");

			}
		});
		mntmAdvogados.setFont(new Font("Cambria", Font.PLAIN, 12));
		mntmAdvogados.setBackground(new Color(138, 217, 255));

		JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("Clientes Físicos");
		mnLista.add(mntmNewMenuItem_1_1_1);
		mntmNewMenuItem_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		mntmNewMenuItem_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "tela4");
			}
		});
		mntmNewMenuItem_1_1_1.setFont(new Font("Cambria", Font.PLAIN, 12));
		mntmNewMenuItem_1_1_1.setBackground(new Color(138, 217, 255));

		JMenuItem mntmNewMenuItem_1_1_1_2 = new JMenuItem("Clientes Jurídicos");
		mnLista.add(mntmNewMenuItem_1_1_1_2);
		mntmNewMenuItem_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "tela5");

			}
		});
		mntmNewMenuItem_1_1_1_2.setFont(new Font("Cambria", Font.PLAIN, 12));
		mntmNewMenuItem_1_1_1_2.setBackground(new Color(138, 217, 255));

		JMenuItem mntmNewMenuItem_1_1_1_1 = new JMenuItem("Sair");
		mntmNewMenuItem_1_1_1_1.setForeground(new Color(0, 0, 0));
		menuBar.add(mntmNewMenuItem_1_1_1_1);
		mntmNewMenuItem_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resultado = JOptionPane.showConfirmDialog(null, "Você deseja sair?", "Confirmação!",
						JOptionPane.YES_NO_OPTION);

				if (resultado == JOptionPane.YES_OPTION) {

					dispose();
				}

			}
		});
		mntmNewMenuItem_1_1_1_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		mntmNewMenuItem_1_1_1_1.setBackground(new Color(0, 128, 192));
		btnPainel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "tela2");
			}
		});
		btnCltF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout cl = (CardLayout) panel.getLayout();
				cl.show(panel, "tela3");

			}
		});

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\Users\\Usu\u00E1rio\\OneDrive - SENAC-SC\\Documentos\\WsSoftware\\ProjetoPI\\img\\imagensAdv.jpeg"));
		label.setBounds(70, 32, 925, 157);
		contentPane.add(label);

		JPanel painelCltJ = new JPanel();
		painelCltJ.setBounds(0, 325, 1039, 382);
		panel.add(painelCltJ, "tela2");
		painelCltJ.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 192), new Color(0, 128, 192),
				new Color(0, 128, 192), new Color(0, 128, 192)));
		painelCltJ.setBackground(new Color(251, 254, 255));
		painelCltJ.setLayout(null);

		JLabel lblRSocial = new JLabel("Raz\u00E3o Social:");
		lblRSocial.setFont(new Font("Cambria", Font.BOLD, 12));
		lblRSocial.setBounds(229, 89, 78, 13);
		painelCltJ.add(lblRSocial);

		textRSocial = new JTextField();
		textRSocial.setColumns(10);
		textRSocial.setBounds(229, 104, 304, 19);
		painelCltJ.add(textRSocial);

		JLabel lblCnpj = new JLabel("Cnpj:");
		lblCnpj.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCnpj.setBounds(543, 85, 30, 20);
		painelCltJ.add(lblCnpj);

		textCnpJ = new JTextField();
		textCnpJ.setColumns(10);
		textCnpJ.setBounds(543, 104, 156, 19);
		painelCltJ.add(textCnpJ);

		JLabel lblLogradouroCltJ = new JLabel("Logradouro:");
		lblLogradouroCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		lblLogradouroCltJ.setBounds(229, 185, 78, 19);
		painelCltJ.add(lblLogradouroCltJ);

		textLogradouroCltJ = new JTextField();
		textLogradouroCltJ.setColumns(10);
		textLogradouroCltJ.setBounds(229, 203, 115, 19);
		painelCltJ.add(textLogradouroCltJ);

		JLabel lblNunCsCltj = new JLabel("N\u00BA:");
		lblNunCsCltj.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNunCsCltj.setBounds(355, 185, 22, 13);
		painelCltJ.add(lblNunCsCltj);

		textNumCsCltJ = new JTextField();
		textNumCsCltJ.setColumns(10);
		textNumCsCltJ.setBounds(354, 203, 39, 19);
		painelCltJ.add(textNumCsCltJ);

		JLabel lblBairroCltJ = new JLabel("Bairro:");
		lblBairroCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		lblBairroCltJ.setBounds(405, 185, 45, 13);
		painelCltJ.add(lblBairroCltJ);

		textBairroCltJ = new JTextField();
		textBairroCltJ.setColumns(10);
		textBairroCltJ.setBounds(405, 203, 128, 19);
		painelCltJ.add(textBairroCltJ);

		JLabel lblCidadeCltJ = new JLabel("Cidade:");
		lblCidadeCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCidadeCltJ.setBounds(229, 232, 45, 13);
		painelCltJ.add(lblCidadeCltJ);

		textCidadeCltJ = new JTextField();
		textCidadeCltJ.setColumns(10);
		textCidadeCltJ.setBounds(229, 250, 129, 19);
		painelCltJ.add(textCidadeCltJ);

		JLabel lblEstadoCltJ = new JLabel("Estado:");
		lblEstadoCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEstadoCltJ.setBounds(367, 232, 45, 13);
		painelCltJ.add(lblEstadoCltJ);

		textEstadoCltJ = new JTextField();
		textEstadoCltJ.setBounds(368, 250, 165, 19);
		painelCltJ.add(textEstadoCltJ);
		textEstadoCltJ.setColumns(10);

		JLabel lblTelefoneCltJ = new JLabel("Telefone:");
		lblTelefoneCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		lblTelefoneCltJ.setBounds(229, 133, 78, 19);
		painelCltJ.add(lblTelefoneCltJ);

		textTelCltJ = new JTextField();
		textTelCltJ.setColumns(10);
		textTelCltJ.setBounds(229, 151, 129, 19);
		painelCltJ.add(textTelCltJ);

		JLabel lblEmailCltJ = new JLabel("E-mail:");
		lblEmailCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEmailCltJ.setBounds(367, 133, 45, 19);
		painelCltJ.add(lblEmailCltJ);

		textEmailCltJ = new JTextField();
		textEmailCltJ.setColumns(10);
		textEmailCltJ.setBounds(367, 151, 166, 19);
		painelCltJ.add(textEmailCltJ);

		JLabel lblCepCltJ = new JLabel("CEP:");
		lblCepCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCepCltJ.setBounds(543, 185, 45, 13);
		painelCltJ.add(lblCepCltJ);

		textCepCltJ = new JTextField();
		textCepCltJ.setColumns(10);
		textCepCltJ.setBounds(543, 203, 156, 19);
		painelCltJ.add(textCepCltJ);

		JButton btnCadCltJ = new JButton("Cadastrar");
		btnCadCltJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cadastrarCltJ();

			}
		});

		btnCadCltJ.setForeground(Color.WHITE);
		btnCadCltJ.setFont(new Font("Cambria", Font.BOLD, 12));
		btnCadCltJ.setBackground(new Color(0, 64, 128));
		btnCadCltJ.setBounds(595, 461, 104, 29);
		painelCltJ.add(btnCadCltJ);

		JLabel lblNewLabel_3_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_3_1.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(229, 296, 66, 13);
		painelCltJ.add(lblNewLabel_3_1);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(UIManager.getColor("Button.background"));
		textPane_1.setBounds(229, 319, 470, 131);
		painelCltJ.add(textPane_1);

		JLabel lblClienteJurdico = new JLabel("    Clientes Jur\u00EDdicos");
		lblClienteJurdico.setForeground(new Color(0, 128, 192));
		lblClienteJurdico.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 22));
		lblClienteJurdico.setBackground(new Color(0, 128, 192));
		lblClienteJurdico.setBounds(382, 35, 191, 40);
		painelCltJ.add(lblClienteJurdico);
		
		// Cliente Fisico
		painelCltF = new JPanel();
		painelCltF.setBounds(70, 189, 159, 154);
		panel.add(painelCltF,"tela3");
		painelCltF.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 192), new Color(0, 128, 192),
				new Color(0, 128, 192), new Color(0, 128, 192)));
		painelCltF.setBackground(new Color(251, 254, 255));
		painelCltF.setLayout(null);


		JLabel lblCadastroCltF = new JLabel("    Clientes F\u00EDsicos");
		lblCadastroCltF.setForeground(new Color(0, 128, 192));
		lblCadastroCltF.setBackground(new Color(0, 128, 192));
		lblCadastroCltF.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 22));
		lblCadastroCltF.setBounds(378, 20, 198, 40);
		painelCltF.add(lblCadastroCltF);

		JLabel lblNomeCltF = new JLabel("Nome:");
		lblNomeCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNomeCltF.setBounds(232, 74, 45, 13);
		painelCltF.add(lblNomeCltF);

		textNomeCltF = new JTextField();
		textNomeCltF.setBounds(232, 89, 304, 19);
		painelCltF.add(textNomeCltF);
		textNomeCltF.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCpf.setBounds(546, 70, 30, 20);
		painelCltF.add(lblCpf);

		textCpf = new JTextField();
		textCpf.setBounds(546, 89, 156, 19);
		painelCltF.add(textCpf);
		textCpf.setColumns(10);

		JLabel lblLogradouroCltF = new JLabel("Logradouro:");
		lblLogradouroCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblLogradouroCltF.setBounds(232, 170, 78, 19);
		painelCltF.add(lblLogradouroCltF);

		textLogCltF = new JTextField();
		textLogCltF.setBounds(232, 188, 115, 19);
		painelCltF.add(textLogCltF);
		textLogCltF.setColumns(10);

		JLabel lblNunCasa = new JLabel("N\u00BA:");
		lblNunCasa.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNunCasa.setBounds(358, 170, 22, 13);
		painelCltF.add(lblNunCasa);

		textNumCasa = new JTextField();
		textNumCasa.setBounds(357, 188, 39, 19);
		painelCltF.add(textNumCasa);
		textNumCasa.setColumns(10);

		JLabel lblBairroCltF = new JLabel("Bairro:");
		lblBairroCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblBairroCltF.setBounds(408, 170, 45, 13);
		painelCltF.add(lblBairroCltF);

		textBairroCltF = new JTextField();
		textBairroCltF.setColumns(10);
		textBairroCltF.setBounds(408, 188, 128, 19);
		painelCltF.add(textBairroCltF);

		JLabel lblCidadeCltF = new JLabel("Cidade:");
		lblCidadeCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCidadeCltF.setBounds(232, 217, 45, 13);
		painelCltF.add(lblCidadeCltF);

		textCidadeCltF = new JTextField();
		textCidadeCltF.setColumns(10);
		textCidadeCltF.setBounds(232, 235, 129, 19);
		painelCltF.add(textCidadeCltF);

		JLabel lblEstadoCltF = new JLabel("Estado:");
		lblEstadoCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEstadoCltF.setBounds(370, 217, 45, 13);
		painelCltF.add(lblEstadoCltF);

		textEstadoCltF = new JTextField();
		textEstadoCltF.setBounds(370, 235, 166, 19);
		painelCltF.add(textEstadoCltF);
		textEstadoCltF.setColumns(10);

		JLabel lblTelCltF = new JLabel("Telefone:");
		lblTelCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblTelCltF.setBounds(232, 118, 78, 19);
		painelCltF.add(lblTelCltF);

		textTelCltF = new JTextField();
		textTelCltF.setColumns(10);
		textTelCltF.setBounds(232, 136, 129, 19);
		painelCltF.add(textTelCltF);

		JLabel lblEmailCltF = new JLabel("E-mail:");
		lblEmailCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEmailCltF.setBounds(370, 118, 45, 19);
		painelCltF.add(lblEmailCltF);

		textEmailCltF = new JTextField();
		textEmailCltF.setColumns(10);
		textEmailCltF.setBounds(370, 136, 166, 19);
		painelCltF.add(textEmailCltF);

		JLabel lblCepCltF = new JLabel("CEP:");
		lblCepCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCepCltF.setBounds(546, 170, 45, 13);
		painelCltF.add(lblCepCltF);

		textCepCltF = new JTextField();
		textCepCltF.setColumns(10);
		textCepCltF.setBounds(546, 188, 156, 19);
		painelCltF.add(textCepCltF);

		JButton btnCadCltF = new JButton("Cadastrar");
		btnCadCltF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cadastrarCltF();
			}
		});

		btnCadCltF.setForeground(Color.WHITE);
		btnCadCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		btnCadCltF.setBackground(new Color(0, 64, 128));
		btnCadCltF.setBounds(598, 451, 104, 29);
		painelCltF.add(btnCadCltF);

		JLabel lblDescCltF = new JLabel("Descri\u00E7\u00E3o:");
		lblDescCltF.setFont(new Font("Cambria", Font.BOLD, 12));
		lblDescCltF.setBounds(232, 280, 66, 13);
		painelCltF.add(lblDescCltF);

		JTextPane textCltF = new JTextPane();
		textCltF.setBackground(UIManager.getColor("Slider.background"));
		textCltF.setBounds(232, 303, 470, 140);
		painelCltF.add(textCltF);

		// Painel Advogado

		JPanel painelAdv = new JPanel();
		painelAdv.setBounds(10, 128, 159, 154);
		panel.add(painelAdv, "tela1");
		painelAdv.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 192), new Color(0, 128, 192),
				new Color(0, 128, 192), new Color(0, 128, 192)));
		painelAdv.setBackground(new Color(251, 254, 255));
		painelAdv.setLayout(null);

		JLabel nomeAdv = new JLabel("Nome:");
		nomeAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		nomeAdv.setBounds(265, 133, 78, 13);
		painelAdv.add(nomeAdv);

		textNomeAdv = new JTextField();
		textNomeAdv.setColumns(10);
		textNomeAdv.setBounds(265, 148, 304, 19);
		painelAdv.add(textNomeAdv);

		JLabel lblNunOAB = new JLabel("NumeroOAB:");
		lblNunOAB.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNunOAB.setBounds(579, 129, 78, 20);
		painelAdv.add(lblNunOAB);

		textNumOAB = new JTextField();
		textNumOAB.setColumns(10);
		textNumOAB.setBounds(579, 148, 156, 19);
		painelAdv.add(textNumOAB);

		JLabel lblLogradouroAdv = new JLabel("Logradouro:");
		lblLogradouroAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblLogradouroAdv.setBounds(265, 229, 78, 19);
		painelAdv.add(lblLogradouroAdv);

		textLogAgv = new JTextField();
		textLogAgv.setColumns(10);
		textLogAgv.setBounds(265, 247, 115, 19);
		painelAdv.add(textLogAgv);

		JLabel lblNunCs = new JLabel("N\u00BA:");
		lblNunCs.setFont(new Font("Cambria", Font.BOLD, 12));
		lblNunCs.setBounds(391, 229, 22, 13);
		painelAdv.add(lblNunCs);

		textNunCs = new JTextField();
		textNunCs.setColumns(10);
		textNunCs.setBounds(390, 247, 39, 19);
		painelAdv.add(textNunCs);

		JLabel lblBairroAdv = new JLabel("Bairro:");
		lblBairroAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblBairroAdv.setBounds(441, 229, 45, 13);
		painelAdv.add(lblBairroAdv);

		textBairroAdv = new JTextField();
		textBairroAdv.setColumns(10);
		textBairroAdv.setBounds(441, 247, 128, 19);
		painelAdv.add(textBairroAdv);

		JLabel lblCidadeAdv = new JLabel("Cidade:");
		lblCidadeAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCidadeAdv.setBounds(265, 276, 45, 13);
		painelAdv.add(lblCidadeAdv);

		textCidadeAdv = new JTextField();
		textCidadeAdv.setColumns(10);
		textCidadeAdv.setBounds(265, 294, 129, 19);
		painelAdv.add(textCidadeAdv);

		JLabel lblEstadoAdv = new JLabel("Estado:");
		lblEstadoAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEstadoAdv.setBounds(403, 276, 45, 13);
		painelAdv.add(lblEstadoAdv);

		textEstadoAdv = new JTextField();
		textEstadoAdv.setBounds(404, 294, 165, 19);
		painelAdv.add(textEstadoAdv);
		textEstadoAdv.setColumns(10);

		JLabel lblTelefoneAdv = new JLabel("Telefone:");
		lblTelefoneAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblTelefoneAdv.setBounds(265, 177, 78, 19);
		painelAdv.add(lblTelefoneAdv);

		textTelAdv = new JTextField();
		textTelAdv.setColumns(10);
		textTelAdv.setBounds(265, 195, 129, 19);
		painelAdv.add(textTelAdv);

		JLabel lblEmailAdv = new JLabel("E-mail:");
		lblEmailAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEmailAdv.setBounds(403, 177, 45, 19);
		painelAdv.add(lblEmailAdv);

		textEmailAdv = new JTextField();
		textEmailAdv.setColumns(10);
		textEmailAdv.setBounds(403, 195, 166, 19);
		painelAdv.add(textEmailAdv);

		JLabel lblCepAdv = new JLabel("CEP:");
		lblCepAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCepAdv.setBounds(579, 229, 45, 13);
		painelAdv.add(lblCepAdv);

		textCepAdv = new JTextField();
		textCepAdv.setColumns(10);
		textCepAdv.setBounds(579, 247, 156, 19);
		painelAdv.add(textCepAdv);

		JLabel lblEspeciAdv = new JLabel("Especializa\u00E7\u00F5es:");
		lblEspeciAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		lblEspeciAdv.setBounds(579, 181, 95, 13);
		painelAdv.add(lblEspeciAdv);

		textEspecializacao = new JTextField();
		textEspecializacao.setBounds(579, 195, 156, 19);
		painelAdv.add(textEspecializacao);
		textEspecializacao.setColumns(10);

		JButton btnNewCadastrarAdv = new JButton("Cadastrar");
		btnNewCadastrarAdv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cadastro Advogado
				cadastrarAdv();

			}
		});
		btnNewCadastrarAdv.setForeground(Color.WHITE);
		btnNewCadastrarAdv.setFont(new Font("Cambria", Font.BOLD, 12));
		btnNewCadastrarAdv.setBackground(new Color(0, 64, 128));
		btnNewCadastrarAdv.setBounds(631, 370, 104, 29);
		painelAdv.add(btnNewCadastrarAdv);

		JLabel lblCadastroAdv = new JLabel("Advogado");
		lblCadastroAdv.setForeground(new Color(0, 128, 192));
		lblCadastroAdv.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 22));
		lblCadastroAdv.setBackground(new Color(0, 128, 192));
		lblCadastroAdv.setBounds(405, 36, 135, 40);
		painelAdv.add(lblCadastroAdv);
	}

	// Metodos De Advogado

	public void cadastrarAdv() {

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
		daoAdv.Inserir(advogado);
	}

	public void atualizarTabelaAdv() {
		modelo = (DefaultTableModel) tableAdv.getModel();

		modelo.setRowCount(0);

		listaAdv = daoAdv.listaAdvogados();

		for (Advogado advogado : listaAdv) {

			modelo.addRow(new Object[] { advogado.getIdAdvogado(), advogado.getNome(), advogado.getNumeroOAB(),
					advogado.getEmail(), advogado.getEspecializacao() });
		}

	}

	public void removerAdv() {

		int linha = tableAdv.getSelectedRow();

		if (linha != -1) {

			Object idObj = modelo.getValueAt(linha, 0);
			int id = (Integer) idObj;

			Advogado advogado = new Advogado(id, null, null, null, null, null, null, null, null, null, null, null);

			daoAdv.deletarAdv(advogado);

		} else {
			JOptionPane.showMessageDialog(null, "Selecione um advogado para remover");
		}

	}

	public void editarAdv() {

		int linha = tableAdv.getSelectedRow();

		if (linha != -1) {

			Object idObj = tableAdv.getValueAt(linha, 0);
			int id = (Integer) idObj;

			Advogado advogado = new Advogado(id, null, null, null, null, null, null, null, null, null, null, null);

			daoAdv.selecionarAdv(advogado);

			// Criando os campos de texto
			JTextField tfNome = new JTextField(advogado.getNome());
			JTextField tfNumOAB = new JTextField(advogado.getNumeroOAB());
			JTextField tfEspec = new JTextField(advogado.getEspecializacao());
			JTextField tfTel = new JTextField(advogado.getTelefone());
			JTextField tfEmail = new JTextField(advogado.getEmail());
			JTextField tfCep = new JTextField(advogado.getCep());
			JTextField tfLogradouro = new JTextField(advogado.getLogradouro());
			JTextField tfNunCs = new JTextField(advogado.getNumCasa());
			JTextField tfBairro = new JTextField(advogado.getBairro());
			JTextField tfCidade = new JTextField(advogado.getCidade());
			JTextField tfEstado = new JTextField(advogado.getEstado());

			// Criando os rótulos
			JLabel lblNome = new JLabel("Nome");
			JLabel lblNumOAB = new JLabel("NumeroOAB");
			JLabel lblEspc = new JLabel("Especialização");
			JLabel lblTel = new JLabel("Telefone");
			JLabel lblEmail = new JLabel("Email");
			JLabel lblCep = new JLabel("Cep");
			JLabel lblLogradouro = new JLabel("Logradouro");
			JLabel lblNumCs = new JLabel("Numero");
			JLabel lblBairro = new JLabel("Bairro");
			JLabel lblCidade = new JLabel("Cidade");
			JLabel lblEstado = new JLabel("Estado");

			// Criando o painel
			JPanel painel = new JPanel(new GridLayout(0, 1));
			painel.add(lblNome);
			painel.add(tfNome);
			painel.add(lblNumOAB);
			painel.add(tfNumOAB);
			painel.add(lblEspc);
			painel.add(tfEspec);
			painel.add(lblTel);
			painel.add(tfTel);
			painel.add(lblEmail);
			painel.add(tfEmail);
			painel.add(lblCep);
			painel.add(tfCep);
			painel.add(lblLogradouro);
			painel.add(tfLogradouro);
			painel.add(lblNumCs);
			painel.add(tfNunCs);
			painel.add(lblBairro);
			painel.add(tfBairro);
			painel.add(lblCidade);
			painel.add(tfCidade);
			painel.add(lblEstado);
			painel.add(tfEstado);

			int resultado = JOptionPane.showConfirmDialog(null, painel, "Editar", JOptionPane.OK_CANCEL_OPTION);

			if (resultado == JOptionPane.OK_OPTION) {

				String nome = tfNome.getText();
				String numOAB = tfNumOAB.getText();
				String espec = tfEspec.getText();
				String tel = tfTel.getText();
				String email = tfEmail.getText();
				String cep = tfCep.getText();
				String logradouro = tfLogradouro.getText();
				String numero = tfNunCs.getText();
				String bairro = tfBairro.getText();
				String cidade = tfEstado.getText();
				String estado = tfEstado.getText();
				advogado = new Advogado(nome, numero, espec, tel, email, cep, logradouro, numero, bairro, cidade,
						estado);

				daoAdv.alterarAdvogado(advogado);
				atualizarTabelaAdv();

			}

		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma pessoa para editar");
		}
	}

	// Metodos Cliente Fisico

	public void cadastrarCltF() {

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

		daoCltF.Inserir(CltF);
	}

	public void atualizarTabelaCltF() {
		modelo = (DefaultTableModel) tableCltF.getModel();

		modelo.setRowCount(0);

		listaCltF = daoCltF.listaClientesFisico();

		for (ClienteFisico cltF : listaCltF) {

			modelo.addRow(
					new Object[] { cltF.getIdClienteFisico(), cltF.getNome(), cltF.getTelefone(), cltF.getEmail() });
		}

	}

	public void removerCltF() {

		int linha = tableCltF.getSelectedRow();

		if (linha != -1) {

			Object idObj = tableCltF.getValueAt(linha, 0);
			int id = (Integer) idObj;

			ClienteFisico clienteFisico = new ClienteFisico(id, null, null, null, null, null, null, null, null, null,
					null);

			daoCltF.deletarClienteFisico(clienteFisico);

		} else {
			JOptionPane.showMessageDialog(null, "Selecione um cliente para remover");
		}

	}

	public void editarCltF() {

		int linha = tableCltF.getSelectedRow();

		if (linha != -1) {

			Object idObj = tableCltF.getValueAt(linha, 0);
			int id = (Integer) idObj;

			ClienteFisico cltF = daoCltF.selecionarClienteFisico(id);

			System.out.println(cltF);
			// Criando os campos de texto
			JTextField tfNome = new JTextField(cltF.getNome());
			JTextField tfCpf = new JTextField(cltF.getCpf());
			JTextField tfTelefone = new JTextField(cltF.getTelefone());
			JTextField tfEmail = new JTextField(cltF.getEmail());
			JTextField tfCep = new JTextField(cltF.getCep());
			JTextField tfLogradouro = new JTextField(cltF.getLogradouro());
			JTextField tfNumCasa = new JTextField(cltF.getNumCasa());
			JTextField tfBairro = new JTextField(cltF.getBairro());
			JTextField tfCidade = new JTextField(cltF.getCidade());
			JTextField tfEstado = new JTextField(cltF.getEstado());

			// Criando os rótulos
			JLabel lblRazaoSocial = new JLabel("Nome");
			JLabel lblCpf = new JLabel("Cpf");
			JLabel lblTelefone = new JLabel("Telefone");
			JLabel lblEmail = new JLabel("Email");
			JLabel lblCep = new JLabel("Cep");
			JLabel lblLogradouro = new JLabel("Logradouro");
			JLabel lblNumCasa = new JLabel("Numero");
			JLabel lblBairro = new JLabel("Bairro");
			JLabel lblCidade = new JLabel("Cidade");
			JLabel lblEstado = new JLabel("Estado");

			// Criando o painel
			JPanel painel = new JPanel(new GridLayout(0, 1));
			painel.add(lblRazaoSocial);
			painel.add(tfNome);
			painel.add(lblCpf);
			painel.add(tfCpf);
			painel.add(lblTelefone);
			painel.add(tfTelefone);
			painel.add(lblEmail);
			painel.add(tfEmail);
			painel.add(lblCep);
			painel.add(tfCep);
			painel.add(lblLogradouro);
			painel.add(tfLogradouro);
			painel.add(lblNumCasa);
			painel.add(tfNumCasa);
			painel.add(lblBairro);
			painel.add(tfBairro);
			painel.add(lblCidade);
			painel.add(tfCidade);
			painel.add(lblEstado);
			painel.add(tfEstado);

			int resultado = JOptionPane.showConfirmDialog(null, painel, "Editar", JOptionPane.OK_CANCEL_OPTION);

			if (resultado == JOptionPane.OK_OPTION) {

				String nome = tfNome.getText();
				String cpf = tfCpf.getText();
				String telefone = tfTelefone.getText();
				String email = tfEmail.getText();
				String cep = tfCep.getText();
				String logradouro = tfLogradouro.getText();
				String numCasa = tfNumCasa.getText();
				String bairro = tfBairro.getText();
				String cidade = tfCidade.getText();
				String estado = tfEstado.getText();

				cltF = new ClienteFisico(id, nome, cpf, telefone, email, cep, logradouro, numCasa, bairro, cidade,
						estado);

				daoCltF.alterarClienteFisico(cltF);
				atualizarTabelaCltF();

			}

		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma pessoa para editar");
		}
	}

	// Metodos Cliente Juridico

	public void cadastrarCltJ() {

		String razaoSocial = textRSocial.getText();
		String cnpj = textCnpJ.getText();
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

		daoCltJ.Inserir(CltJ);
	}

	public void atualizarTabelaCltJ() {
		modelo = (DefaultTableModel) tableCltJ.getModel();

		modelo.setRowCount(0);

		listaCltJ = daoCltJ.listaClienteJuridico();

		for (ClienteJuridico cltJ : listaCltJ) {

			modelo.addRow(new Object[] { cltJ.getIdClienteJuridico(), cltJ.getRazaoSocial(), cltJ.getTelefone(),
					cltJ.getEmail() });
		}

	}

	public void removerCltJ() {

		int linha = tableCltJ.getSelectedRow();

		if (linha != -1) {

			Object idObj = tableCltJ.getValueAt(linha, 0);
			int id = (Integer) idObj;

			ClienteJuridico clienteJuridico = new ClienteJuridico(id, null, null, null, null, null, null, null, null,
					null, null);

			daoCltJ.deletarClienteJuridico(clienteJuridico);

		} else {
			JOptionPane.showMessageDialog(null, "Selecione um cliente para remover");
		}

	}

	public void editarCltJ() {

		int linha = tableCltJ.getSelectedRow();

		if (linha != -1) {

			Object idObj = tableCltJ.getValueAt(linha, 0);
			int id = (Integer) idObj;

			ClienteJuridico cltJ = daoCltJ.selecionarClienteJuridico(id);

			// Criando os campos de texto
			JTextField tfRazaoSocial = new JTextField(cltJ.getRazaoSocial());
			JTextField tfCnpj = new JTextField(cltJ.getCnpj());
			JTextField tfTelefone = new JTextField(cltJ.getTelefone());
			JTextField tfEmail = new JTextField(cltJ.getEmail());
			JTextField tfCep = new JTextField(cltJ.getCep());
			JTextField tfLogradouro = new JTextField(cltJ.getLogradouro());
			JTextField tfNumCasa = new JTextField(cltJ.getNumCasa());
			JTextField tfBairro = new JTextField(cltJ.getBairro());
			JTextField tfCidade = new JTextField(cltJ.getCidade());
			JTextField tfEstado = new JTextField(cltJ.getEstado());

			// Criando os rótulos
			JLabel lblRazaoSocial = new JLabel("Razão Social");
			JLabel lblCnpj = new JLabel("Cnpj");
			JLabel lblTelefone = new JLabel("Telefone");
			JLabel lblEmail = new JLabel("Email");
			JLabel lblCep = new JLabel("Cep");
			JLabel lblLogradouro = new JLabel("Logradouro");
			JLabel lblNumCasa = new JLabel("Numero");
			JLabel lblBairro = new JLabel("Bairro");
			JLabel lblCidade = new JLabel("Cidade");
			JLabel lblEstado = new JLabel("Estado");

			// Criando o painel
			JPanel painel = new JPanel(new GridLayout(0, 1));
			painel.add(lblRazaoSocial);
			painel.add(tfRazaoSocial);
			painel.add(lblCnpj);
			painel.add(tfCnpj);
			painel.add(lblTelefone);
			painel.add(tfTelefone);
			painel.add(lblEmail);
			painel.add(tfEmail);
			painel.add(lblLogradouro);
			painel.add(tfLogradouro);
			painel.add(lblNumCasa);
			painel.add(tfNumCasa);
			painel.add(lblBairro);
			painel.add(tfBairro);
			painel.add(lblCidade);
			painel.add(tfCidade);
			painel.add(lblEstado);
			painel.add(tfEstado);

			int resultado = JOptionPane.showConfirmDialog(null, painel, "Editar", JOptionPane.OK_CANCEL_OPTION);

			if (resultado == JOptionPane.OK_OPTION) {

				String razaoSocial = tfRazaoSocial.getText();
				String cnpj = tfCnpj.getText();
				String telefone = tfTelefone.getText();
				String email = tfEmail.getText();
				String logradouro = tfLogradouro.getText();
				String numCasa = tfNumCasa.getText();
				String bairro = tfBairro.getText();
				String cidade = tfCidade.getText();
				String estado = tfEstado.getText();

				cltJ = new ClienteJuridico(id, razaoSocial, cnpj, telefone, email, email, logradouro, numCasa, bairro,
						cidade, estado);

				daoCltJ.alterarClienteJuridico(cltJ);
				atualizarTabelaCltJ();

			}

		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma pessoa para editar");
		}
	}

}
