package entidadesfix;

import excecoes.DomainException;

public class Conta {
	private Integer numero;
	private String nome;
	private Double saldo;
	private Double limiteSaque;

	public Conta() {

	}

	public Conta(Integer numero, String nome, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public void deposito(double quantia) {
		saldo += quantia;
	}

	public void saque(double quantia) {
		verificacao(quantia);
		saldo -= quantia;
	}

	public void verificacao(Double quantia) {
		if (quantia > limiteSaque) {
			throw new DomainException("A quantia excede o valor limite de saque!");
		}
		if (quantia > getSaldo()) {
			throw new DomainException("Saldo insuficiente!");
		}
	}
}
