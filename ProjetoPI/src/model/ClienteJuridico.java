package model;

public class ClienteJuridico extends Cliente {
	private int idClienteJuridico;
	private String cnpj;
	private String razaoSocial;



	public ClienteJuridico(int idClienteJuridico, String razaoSocial,String cnpj, String telefone, String email, String cep, String logradouro,
			String numCasa, String bairro, String cidade, String estado) {
		super(idClienteJuridico, razaoSocial, telefone, email, cep, logradouro, numCasa, bairro, cidade, estado);
		this.idClienteJuridico = idClienteJuridico;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public int getIdClienteJuridico() {
		return idClienteJuridico;
	}

	public void setIdClienteJuridico(int idClienteJuridico) {
		this.idClienteJuridico = idClienteJuridico;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Override
	public String toString() {
		return "ClienteJuridico [idClienteJuridico=" + idClienteJuridico + ", cnpj=" + cnpj + ", razaoSocial="
				+ razaoSocial + "]";
	}

}
