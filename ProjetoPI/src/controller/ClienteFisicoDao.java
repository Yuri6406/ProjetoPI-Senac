package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conection.Conexao;
import model.ClienteFisico;

public class ClienteFisicoDao {

	public void Inserir(ClienteFisico clienteFisico) {
		String sql = "INSERT INTO clientefisico (nome, cpf, telefone, email, cep, logradouro, numCasa, bairro, cidade, estado) VALUES (?,?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmm = null;

		try {
			// conexao com DB
			conn = Conexao.getConnection();

			pstmm = conn.prepareStatement(sql);

			pstmm.setString(1, clienteFisico.getNome());
			pstmm.setString(2, clienteFisico.getCpf());
			pstmm.setString(3, clienteFisico.getTelefone());
			pstmm.setString(4, clienteFisico.getEmail());
			pstmm.setString(5, clienteFisico.getCep());
			pstmm.setString(6, clienteFisico.getLogradouro());
			pstmm.setString(7, clienteFisico.getNumCasa());
			pstmm.setString(8, clienteFisico.getBairro());
			pstmm.setString(9, clienteFisico.getCidade());
			pstmm.setString(10, clienteFisico.getEstado());

			pstmm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ClienteFisico> listaClientesFisico() {
		ArrayList<ClienteFisico> clienteFisico = new ArrayList<>();
		String read = "select * from clienteFisico order by nome";
		Connection conn = null;
		PreparedStatement pstmm = null;
		try {
			// Abrir a conexão
			conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			pstmm = conn.prepareStatement(read);
			ResultSet rs = pstmm.executeQuery();

			// Enquanto houver ClienteFisico será executado o laço
			while (rs.next()) {
				// Var de apoio que recebem os dados do banco
				int idClienteFisico = rs.getInt(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String telefone = rs.getString(4);
				String email = rs.getString(5);
				String cep = rs.getString(6);
				String logradouro = rs.getString(7);
				String numCasa = rs.getString(8);
				String bairro = rs.getString(9);
				String cidade = rs.getString(10);
				String estado = rs.getString(11);

				// Populando o ArrayList
				clienteFisico.add(new ClienteFisico(idClienteFisico, nome, cpf, telefone, email, cep, logradouro,
						numCasa, bairro, cidade, estado));

			}
			conn.close();
			return clienteFisico;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Seleionando o clienteFisico por ID
	public void selecionarClienteFisico(ClienteFisico clienteFisico) {
		String read = "select * from clientefisico where idClienteFisico = ?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pstm = conn.prepareStatement(read);
			pstm.setLong(1, clienteFisico.getIdClienteFisico());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {

				// Setando as variáveis de produto
				clienteFisico.setIdClienteFisico(rs.getInt(1));
				clienteFisico.setNome(rs.getString(2));
				clienteFisico.setCpf(rs.getString(3));
				clienteFisico.setTelefone(rs.getString(4));
				clienteFisico.setEmail(rs.getString(5));
				clienteFisico.setCep(rs.getString(6));
				clienteFisico.setLogradouro(rs.getString(7));
				clienteFisico.setNumCasa(rs.getString(8));
				clienteFisico.setBairro(rs.getString(9));
				clienteFisico.setCidade(rs.getString(10));
				clienteFisico.setEstado(rs.getString(11));

			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Editando o clienteFisico
	public void alterarClienteFisico(ClienteFisico clienteFisico) {
		String create = "update ClienteFisico set nome=?,cpf=?, telefone=?, email=?, cep=?, logradouro=?,numCasa=?, bairro=?, cidade=?, estado=? where idClienteFisico=?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pstmm = conn.prepareStatement(create);
			pstmm.setString(1, clienteFisico.getNome());
			pstmm.setString(2, clienteFisico.getCpf());
			pstmm.setString(3, clienteFisico.getTelefone());
			pstmm.setString(4, clienteFisico.getEmail());
			pstmm.setString(5, clienteFisico.getCep());
			pstmm.setString(6, clienteFisico.getLogradouro());
			pstmm.setString(7, clienteFisico.getNumCasa());
			pstmm.setString(8, clienteFisico.getBairro());
			pstmm.setString(9, clienteFisico.getCidade());
			pstmm.setString(10, clienteFisico.getEstado());
			pstmm.setInt(11, clienteFisico.getIdClienteFisico());

			pstmm.executeUpdate();

			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** DELETE **/
	public void deletarClienteFisico(ClienteFisico clienteFisico) {
		String delete = "delete from clienteFisico where idClienteFisico=?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pstm = conn.prepareStatement(delete);
			pstm.setInt(1, clienteFisico.getIdClienteFisico());
			pstm.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}