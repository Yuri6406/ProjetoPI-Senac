package model;

import java.sql.Date;

public class ProcessoPenal {
	private int idProcessoPenais;
	private String numeroProcesso;
	private Date dataInicio;
	private String nomeReu;
	private String tipoCrime;
	private String faseProcesso;

	public ProcessoPenal() {
	}

	public ProcessoPenal(int idProcessoPenais) {
		this.idProcessoPenais = idProcessoPenais;
	}

	public ProcessoPenal(int idProcessoPenais, String numeroProcesso, Date dataInicio, String nomeReu, String tipoCrime,
			String faseProcesso) {
		super();
		this.idProcessoPenais = idProcessoPenais;
		this.numeroProcesso = numeroProcesso;
		this.dataInicio = dataInicio;
		this.nomeReu = nomeReu;
		this.tipoCrime = tipoCrime;
		this.faseProcesso = faseProcesso;
	}

	public int getIdProcessoPenais() {
		return idProcessoPenais;
	}

	public void setIdProcessoPenais(int idProcessoPenais) {
		this.idProcessoPenais = idProcessoPenais;
	}

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getNomeReu() {
		return nomeReu;
	}

	public void setNomeReu(String nomeReu) {
		this.nomeReu = nomeReu;
	}

	public String getTipoCrime() {
		return tipoCrime;
	}

	public void setTipoCrime(String tipoCrime) {
		this.tipoCrime = tipoCrime;
	}

	public String getFaseProcesso() {
		return faseProcesso;
	}

	public void setFaseProcesso(String faseProcesso) {
		this.faseProcesso = faseProcesso;
	}

	@Override
	public String toString() {
		return "ProcessoPenal [idProcessoPenais=" + idProcessoPenais + ", numeroProcesso=" + numeroProcesso
				+ ", dataInicio=" + dataInicio + ", nomeReu=" + nomeReu + ", tipoCrime=" + tipoCrime + ", faseProcesso="
				+ faseProcesso + "]";
	}
}
