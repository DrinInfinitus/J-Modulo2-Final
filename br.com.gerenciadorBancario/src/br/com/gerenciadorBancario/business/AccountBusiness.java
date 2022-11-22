package br.com.gerenciadorBancario.business;

import br.com.gerenciadorBancario.entities.Account;

public interface AccountBusiness {

	public void transferencia(Account minhaConta, Double valor, Account contaTransferir);
}
