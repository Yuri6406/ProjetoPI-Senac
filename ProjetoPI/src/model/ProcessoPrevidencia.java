package model;

import java.sql.Date;

public class ProcessoPrevidencia {

	private int idProcessoPrevidencia;
	private String numeroProcesso;
	private Date dataInicio;
	private String paretesEnvolvidas;
	private String tipoAcao;
	private String faseProcesso;

	public ProcessoPrevidencia() {

	}

	public ProcessoPrevidencia(int idProcessoPrevidencia) {
		this.idProcessoPrevidencia = idProcessoPrevidencia;
	}

	public ProcessoPrevidencia(int idProcessoPrevidencia, String numeroProcesso, Date dataInicio,
			String paretesEnvolvidas, String tipoAcao, String faseProcesso) {
		super();
		this.idProcessoPrevidencia = idProcessoPrevidencia;
		this.numeroProcesso = numeroProcesso;
		this.dataInicio = dataInicio;
		this.paretesEnvolvidas = paretesEnvolvidas;
		this.tipoAcao = tipoAcao;
		this.faseProcesso = faseProcesso;
	}

	public int getIdProcessoPrevidencia() {
		return idProcessoPrevidencia;
	}

	public void setIdProcessoPrevidencia(int idProcessoPrevidencia) {
		this.idProcessoPrevidencia = idProcessoPrevidencia;
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

	public String getParetesEnvolvidas() {
		return paretesEnvolvidas;
	}

	public void setParetesEnvolvidas(String paretesEnvolvidas) {
		this.paretesEnvolvidas = paretesEnvolvidas;
	}

	public String getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(String tipoAcao) {
		this.tipoAcao = tipoAcao;
	}

	public String getFaseProcesso() {
		return faseProcesso;
	}

	public void setFaseProcesso(String faseProcesso) {
		this.faseProcesso = faseProcesso;
	}

	@Override
	public String toString() {
		return "ProcessoPrevidencia [idProcessoPrevidencia=" + idProcessoPrevidencia + ", numeroProcesso="
				+ numeroProcesso + ", dataInicio=" + dataInicio + ", paretesEnvolvidas=" + paretesEnvolvidas
				+ ", tipoAcao=" + tipoAcao + ", faseProcesso=" + faseProcesso + "]";
	}

}
