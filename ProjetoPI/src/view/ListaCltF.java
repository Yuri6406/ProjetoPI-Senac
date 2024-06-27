package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import controller.ClienteFisicoDao;
import controller.ClienteJuridicoDao;
import model.ClienteFisico;
import model.ClienteJuridico;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class ListaCltF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private List<ClienteFisico> lista = new ArrayList<>();
	private ClienteFisicoDao dao = new ClienteFisicoDao();
	private DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaCltF frame = new ListaCltF("Ola mundo");
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
	public ListaCltF(String texto) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 115, 550, 505);

		contentPane = new JPanel();

		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 192), new Color(0, 128, 192),
				new Color(0, 128, 192), new Color(0, 128, 192)));
		contentPane.setBackground(new Color(251, 254, 255));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 135, 421, 135);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Id ", "Nome ", "Telefone ", "Email " }));
		contentPane.add(scrollPane);

		JButton btnLista = new JButton("Lista Clientes");
		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabela();
			}
		});
		btnLista.setBounds(55, 276, 101, 21);
		contentPane.add(btnLista);

		JButton btnDeletar = new JButton("Excluir");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerCltF();
				atualizarTabela();
			}
		});
		btnDeletar.setBounds(158, 276, 85, 21);
		contentPane.add(btnDeletar);

		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.setBounds(247, 276, 85, 21);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Clientes F\u00EDsico");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 18));
		lblNewLabel.setBounds(186, 74, 135, 32);
		contentPane.add(lblNewLabel);

	}

	public void atualizarTabela() {
		modelo = (DefaultTableModel) table.getModel();

		modelo.setRowCount(0);

		lista = dao.listaClientesFisico();

		for (ClienteFisico cltF : lista) {

			modelo.addRow(
					new Object[] { cltF.getIdClienteFisico(), cltF.getNome(), cltF.getTelefone(), cltF.getEmail() });
		}

	}

	public void removerCltF() {

		int linha = table.getSelectedRow();

		if (linha != -1) {

			Object idObj = table.getValueAt(linha, 0);
			int id = (Integer) idObj;

			ClienteFisico clienteFisico = new ClienteFisico(id, null, null, null, null, null, null, null, null, null,
					null);

			dao.deletarClienteFisico(clienteFisico);

		}

	}
}
