package model;

import java.sql.Date;

public class ProcessoCivil {

	private int idProcessoCivil;
	private String numeroProcesso;
	private Date dataInicio;
	private String partesEnvolvidas;
	private String tipoAcao;
	private String valorCausa;
	private String faseProcesso;

	public ProcessoCivil() {
	}

	public ProcessoCivil(int idProcessoCivil) {
		this.idProcessoCivil = idProcessoCivil;
	}

	

	public ProcessoCivil(int idProcessoCivil, String numeroProcesso, Date dataInicio, String partesEnvolvidas,
			String tipoAcao, String valorCausa, String faseProcesso) {
		this.idProcessoCivil = idProcessoCivil;
		this.numeroProcesso = numeroProcesso;
		this.dataInicio = dataInicio;
		this.partesEnvolvidas = partesEnvolvidas;
		this.tipoAcao = tipoAcao;
		this.valorCausa = valorCausa;
		this.faseProcesso = faseProcesso;
	}

	public int getIdProcessoCivil() {
		return idProcessoCivil;
	}

	public void setIdProcessoCivil(int idProcessoCivil) {
		this.idProcessoCivil = idProcessoCivil;
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

	public String getPartesEnvolvidas() {
		return partesEnvolvidas;
	}

	public void setPartesEnvolvidas(String partesEnvolvidas) {
		this.partesEnvolvidas = partesEnvolvidas;
	}
	
	public String getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(String tipoAcao) {
		this.tipoAcao = tipoAcao;
	}

	public String getValorCausa() {
		return valorCausa;
	}

	public void setValorCausa(String valorCausa) {
		this.valorCausa = valorCausa;
	}

	public String getFaseProcesso() {
		return faseProcesso;
	}

	public void setFaseProcesso(String faseProcesso) {
		this.faseProcesso = faseProcesso;
	}

	@Override
	public String toString() {
		return "ProcessoCivil [idProcessoCivil=" + idProcessoCivil + ", numeroProcesso=" + numeroProcesso
				+ ", dataInicio=" + dataInicio + ", partesEnvolvidas=" + partesEnvolvidas + ", valorCausa=" + valorCausa
				+ ", faseProcesso=" + faseProcesso + "]";
	}
	
}
