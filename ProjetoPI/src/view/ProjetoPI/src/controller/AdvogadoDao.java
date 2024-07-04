package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conection.Conexao;
import model.Advogado;

public class AdvogadoDao {

	public void Inserir(Advogado advogado) {
		String sql = "INSERT INTO Advogados(nome, numeroOAB, especializacao, telefone, email, cep, logradouro,numCasa, bairro, cidade, estado) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// conexao com DB
			conn = Conexao.getConnection();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, advogado.getNome());
			pstm.setString(2, advogado.getNumeroOAB());
			pstm.setString(3, advogado.getEspecializacao());
			pstm.setString(4, advogado.getTelefone());
			pstm.setString(5, advogado.getEmail());
			pstm.setString(6, advogado.getCep());
			pstm.setString(7, advogado.getLogradouro());
			pstm.setString(8, advogado.getNumCasa());
			pstm.setString(9, advogado.getBairro());
			pstm.setString(10, advogado.getCidade());
			pstm.setString(11, advogado.getEstado());

			pstm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Advogado> listaAdvogados() {
		ArrayList<Advogado> advogados = new ArrayList<>();
		String read = "select * from advogados order by nome";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Abrir a conexão
			conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			pstm = conn.prepareStatement(read);
			ResultSet rs = pstm.executeQuery();

			// Enquanto houver Advogados será execuçtado o laço
			while (rs.next()) {
				// Var de apoio que recebem os dados do banco
				int idAdvogado = rs.getInt(1);
				String nome = rs.getString(2);
				String numeroOAB = rs.getString(3);
				String especializacao = rs.getString(4);
				String telefone = rs.getString(5);
				String email = rs.getString(6);
				String cep = rs.getString(7);
				String logradouro = rs.getString(8);
				String numCasa = rs.getString(9);
				String bairro = rs.getString(10);
				String cidade = rs.getString(11);
				String estado = rs.getString(12);
				// Populando o ArrayList
				advogados.add(new Advogado(idAdvogado, nome, numeroOAB, especializacao, telefone, email, cep,
						logradouro,numCasa, bairro, cidade, estado));
			}
			conn.close();
			return advogados;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Seleionando o advogado por ID
	public Advogado selecionarAdv(int id) {
		Advogado adv = null;
		String read = "select * from advogados where idAdvogados = ?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(read);
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				// Setando as variáveis de produto
				id = rs.getInt(1);
				String nome = rs.getString(2);
				String numeroOAB = rs.getString(3);
				String especializacao = rs.getString(4);
				String telefone = rs.getString(5);
				String email = rs.getString(6);
				String cep = rs.getString(7);
				String ogradouro = rs.getString(8);
				String numCasa = rs.getString(9);
				String bairro = rs.getString(10);
				String cidade = rs.getString(11);
				String estado = rs.getString(12);

				adv = new Advogado(id, nome, numeroOAB, especializacao, telefone, email, cep, ogradouro, numCasa, bairro, cidade, estado);
				
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return adv;
	}

	// Editando o advogado
	public void alterarAdvogado(Advogado advogado) {
		String create = "update Advogados set nome=?, numeroOAB=?, especializacao=?, telefone=?, email=?, cep=?, logradouro=?,numCasa=?, bairro=?, cidade=?, estado=? where idAdvogados=?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, advogado.getNome());
			pst.setString(2, advogado.getNumeroOAB());
			pst.setString(3, advogado.getEspecializacao());
			pst.setString(4, advogado.getTelefone());
			pst.setString(5, advogado.getEmail());
			pst.setString(6, advogado.getCep());
			pst.setString(7, advogado.getLogradouro());
			pst.setString(8, advogado.getNumCasa());
			pst.setString(9, advogado.getBairro());
			pst.setString(10, advogado.getCidade());
			pst.setString(11, advogado.getEstado());
			pst.setInt(12, advogado.getIdAdvogado());
			pst.executeUpdate();

			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** DELETE **/
	public void deletarAdv(Advogado advogado) {
		String delete = "delete from advogados where idAdvogados=?";
		try {
			// Abrir a conexão
			Connection conn = Conexao.getConnection();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = conn.prepareStatement(delete);
			pst.setInt(1, advogado.getIdAdvogado());
			pst.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
