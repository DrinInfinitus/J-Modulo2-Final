package br.com.gerenciadorBancario.dao;

import br.com.gerenciadorBancario.entities.Bank;

public interface BankDAO {
	
	public Bank infos (Bank infos);
	
	public Bank searchBanks (Integer numb);

	public void create (Bank bank);
}
