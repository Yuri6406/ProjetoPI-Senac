package model;

import java.sql.Date;

public class ProcessoTrabalhista {
	private int idProcesso;
	private String numeroProcesso;
	private String reclamante;
	private String tipoAcao;
	private String valorReivindicado;
	private String faseProcesso;
	private Date dataInicio;

	public ProcessoTrabalhista() {

	}

	public ProcessoTrabalhista(int idProcesso) {
		this.idProcesso = idProcesso;
	}

	public ProcessoTrabalhista(int idProcesso, String numeroProcesso, String reclamante, String tipoAcao,
			String valorReivindicado, String faseProcesso, Date dataInicio) {
		this.idProcesso = idProcesso;
		this.numeroProcesso = numeroProcesso;
		this.reclamante = reclamante;
		this.tipoAcao = tipoAcao;
		this.valorReivindicado = valorReivindicado;
		this.faseProcesso = faseProcesso;
		this.dataInicio = dataInicio;
	}

	public int getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public String getReclamante() {
		return reclamante;
	}

	public void setReclamante(String reclamante) {
		this.reclamante = reclamante;
	}

	public String getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(String tipoAcao) {
		this.tipoAcao = tipoAcao;
	}

	public String getValorReivindicado() {
		return valorReivindicado;
	}

	public void setValorReivindicado(String valorReivindicado) {
		this.valorReivindicado = valorReivindicado;
	}

	public String getFaseProcesso() {
		return faseProcesso;
	}

	public void setFaseProcesso(String faseProcesso) {
		this.faseProcesso = faseProcesso;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Override
	public String toString() {
		return "ProcessoTrabalhista [idProcesso=" + idProcesso + ", numeroProcesso=" + numeroProcesso + ", reclamante="
				+ reclamante + ", tipoAcao=" + tipoAcao + ", valorReivindicado=" + valorReivindicado + ", faseProcesso="
				+ faseProcesso + ", dataInicio=" + dataInicio + "]";
	}
}
