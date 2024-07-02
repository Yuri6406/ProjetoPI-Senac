package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conection.Conexao;
import model.ClienteJuridico;

public class ClienteJuridicoDao {

	public void Inserir(ClienteJuridico clienteJuridico) {
		String sql = "INSERT INTO" + " clienteJuridico(razaoSocial,cnpj, telefone,email, cep, logradouro,numCasa, bairro, cidade, estado) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmm = null;

		try {
			// conexao com DB
			conn = Conexao.getConnection();

			pstmm = conn.prepareStatement(sql);
			
			pstmm.setString(1, clienteJuridico.getRazaoSocial());
			pstmm.setString(2, clienteJuridico.getCnpj());
			pstmm.setString(3, clienteJuridico.getTelefone());
			pstmm.setString(4, clienteJuridico.getEmail());
			pstmm.setString(5, clienteJuridico.getCep());
			pstmm.setString(6, clienteJuridico.getLogradouro());
			pstmm.setString(7, clienteJuridico.getNumCasa());
			pstmm.setString(8, clienteJuridico.getBairro());
			pstmm.setString(9, clienteJuridico.getCidade());
			pstmm.setString(10, clienteJuridico.getEstado());

			pstmm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public ArrayList<ClienteJuridico> listaClienteJuridico() {
			ArrayList<ClienteJuridico> clienteJuridico = new ArrayList<>();
			String read = "select * from clienteJuridico order by razaoSocial";
			Connection conn = null;
			PreparedStatement pstmm = null;
			try {
				// Abrir a conexão
				conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				pstmm = conn.prepareStatement(read);
				ResultSet rs = pstmm.executeQuery();

				// Enquanto houver ClienteJuridico será executado o laço
				while (rs.next()) {
					// Var de apoio que recebem os dados do banco
					int idClienteJuridico = rs.getInt(1);
					String razaoSocial = rs.getString(2);
					String cnpj = rs.getString(3);
					String telefone = rs.getString(4);
					String email = rs.getString(5);
					String cep = rs.getString(6);
					String logradouro = rs.getString(7);
					String numCasa = rs.getString(8);
					String bairro = rs.getString(9);
					String cidade = rs.getString(10);
					String estado = rs.getString(11);
					
					// Populando o ArrayList
					clienteJuridico.add(new ClienteJuridico(idClienteJuridico, razaoSocial, cnpj, telefone, email, cep, logradouro, numCasa, bairro, cidade, estado));
				}
				conn.close();
				return clienteJuridico;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		// Seleionando o ClienteJuridico por ID
		public ClienteJuridico selecionarClienteJuridico(int id) {
			ClienteJuridico cltJ = null;
			String read = "select * from clienteJuridico where idClienteJuridico = ?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pstm = conn.prepareStatement(read);
				pstm.setLong(1, id);
				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {

					// Setando as variáveis de produto
					id = rs.getInt(1);
					String razaoSocial = rs.getString(2);
					String cnpj = rs.getString(3);
					String telefone = rs.getString(4);
					String email = rs.getString(5);
					String cep = rs.getString(6);
					String logradouro = rs.getString(7);
					String numCasa = rs.getString(8);
					String bairro = rs.getString(9);
					String cidade =rs.getString(10);
					String estado = rs.getString(11);
					
				
					cltJ = new ClienteJuridico(id, razaoSocial, cnpj, telefone, email, cep, logradouro, numCasa, bairro, cidade, estado);
				}
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			return cltJ;
		}
		
		// Editando o ClienteJuridico
		public void alterarClienteJuridico(ClienteJuridico clienteJuridico) {
			String create = "update clienteJuridico set razaoSocial=?,cnpj=?, telefone=?, email=?, cep=?, logradouro=?,numCasa=?, bairro=?, cidade=?, estado=? where idClienteJuridico=?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pstmm = conn.prepareStatement(create);
				pstmm.setString(1, clienteJuridico.getRazaoSocial());
				pstmm.setString(2, clienteJuridico.getCnpj());
				pstmm.setString(3, clienteJuridico.getTelefone());
				pstmm.setString(4, clienteJuridico.getEmail());
				pstmm.setString(5, clienteJuridico.getCep());
				pstmm.setString(6, clienteJuridico.getLogradouro());
				pstmm.setString(7, clienteJuridico.getNumCasa());
				pstmm.setString(8, clienteJuridico.getBairro());
				pstmm.setString(9, clienteJuridico.getCidade());
				pstmm.setString(10, clienteJuridico.getEstado());
				pstmm.setInt(11, clienteJuridico.getIdClienteJuridico());

				pstmm.executeUpdate();
				pstmm.close();
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		/** DELETE **/
		public void deletarClienteJuridico(ClienteJuridico clienteJuridico) {
			String delete = "delete from clienteJuridico where idClienteJuridico=?";
			try {
				// Abrir a conexão
				Connection conn = Conexao.getConnection();
				// Preparar a query para execução no banco de dados
				PreparedStatement pstm = conn.prepareStatement(delete);
				pstm.setInt(1, clienteJuridico.getIdClienteJuridico());
				pstm.executeUpdate();
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	
}
