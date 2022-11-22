package br.com.gerenciadorBancario.dao;

import br.com.gerenciadorBancario.entities.Account;

public interface AccountDAO {
	
	public void transfer(Account minhaConta, Account contaTransferir);
	
	public Account searchAccount(Integer numConta);
	
	public void deposit(Account contaDepositar, Double valorDepositar);
	
	public void create (Account account);
}
