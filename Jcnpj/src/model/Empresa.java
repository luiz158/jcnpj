package model;

import java.util.Date;
import java.util.List;

public class Empresa {

	private String nome;

	private String codigoNaturezaJuridica;

	private String descricaoNaturezaJuridica;

	private List<Cnae> cnaesSecundarios;

	private Cnae cnaePrimario;

	private String logradouro;
	
	private String complemento;

	private String numero;

	private String cep;

	private String bairro;

	private Date dataAbertura;

	private String municipio;

	private String cnpj;

	private String uf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoNaturezaJuridica() {
		return codigoNaturezaJuridica;
	}

	public void setCodigoNaturezaJuridica(String codigoNaturezaJuridica) {
		this.codigoNaturezaJuridica = codigoNaturezaJuridica;
	}

	public String getDescricaoNaturezaJuridica() {
		return descricaoNaturezaJuridica;
	}

	public void setDescricaoNaturezaJuridica(String descricaoNaturezaJuridica) {
		this.descricaoNaturezaJuridica = descricaoNaturezaJuridica;
	}

	public List<Cnae> getCnaesSecundarios() {
		return cnaesSecundarios;
	}

	public void setCnaesSecundarios(List<Cnae> cnaesSecundarios) {
		this.cnaesSecundarios = cnaesSecundarios;
	}

	public Cnae getCnaePrimario() {
		return cnaePrimario;
	}

	public void setCnaePrimario(Cnae cnaePrimario) {
		this.cnaePrimario = cnaePrimario;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
