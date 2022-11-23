package br.com.gerenciadorBancario.business.impl;

import br.com.gerenciadorBancario.business.AccountBusiness;
import br.com.gerenciadorBancario.dao.AccountDAO;
import br.com.gerenciadorBancario.dao.impl.AccountDAOImpl;
import br.com.gerenciadorBancario.entities.Account;

public class AccountBusinessImpl implements AccountBusiness{
	
	AccountDAO accountDAO = new AccountDAOImpl();
	
	@Override
	public void transferencia(Account minhaConta, Double valor, Account contaTransferir) {
		if (minhaConta.getBalance() >= valor) {
			minhaConta.setBalance(minhaConta.getBalance() - valor);
			contaTransferir.setBalance(contaTransferir.getBalance() + valor);
			accountDAO.transfer(minhaConta, contaTransferir);
		} else {
			System.out.println("Taiz liso boy");
		}
	}
}
