package model.entities;

import java.util.InputMismatchException;

import model.exceptions.DomainExecption;

public class Account {
	private Integer numeroConta;
	private String nome;
	private Double saldo;
	private Double limiteSaque;
	
	public Account() {
		
	}

	public Account(Integer numeroConta, String nome, Double saldo, Double limiteSaque) {
		this.numeroConta = numeroConta;
		this.nome = nome;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;

	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	public void deposito(Double deposito) {
		if(deposito>0) {
			saldo+=deposito;
		}
	}
	
	 public void saque(Double saque) throws DomainExecption {	 
		if(saque>limiteSaque) {
			throw new DomainExecption("Limite de saque excedido.");
		}
		if(saque>saldo) {
			throw new DomainExecption("Valor do saque é maior do que o valor do saldo.");
		}
		if(saldo<=0) {
			throw new DomainExecption("Saldo igual a zero.");
		}
		if(saque<0) {
			throw new DomainExecption("Não é possível realizar esta operação. ");
		}
		
		else {
			saldo -= saque;			
		}
	}

	
	

}
