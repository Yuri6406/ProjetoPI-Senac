package model;

public class ClienteFisico extends Cliente {
	private int idClienteFisico;
	private String cpf;

	public ClienteFisico(int idClienteFisico, String nome, String cpf, String telefone, String email, String cep,
			String logradouro, String numCasa, String bairro, String cidade, String estado) {
		super(idClienteFisico, nome, telefone, email, cep, logradouro, numCasa, bairro, cidade, estado);
		this.idClienteFisico = idClienteFisico;
		this.cpf = cpf;
	}

	public int getIdClienteFisico() {
		return idClienteFisico;
	}

	public void setIdClienteFisico(int idClienteFisico) {
		this.idClienteFisico = idClienteFisico;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "ClienteFisico [idClienteFisico=" + idClienteFisico + ", cpf=" + cpf + "]";
	}

}
