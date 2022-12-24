package br.com.gerenciadorBancario;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.gerenciadorBancario.dao.AccountDAO;
import br.com.gerenciadorBancario.dao.BankDAO;
import br.com.gerenciadorBancario.dao.GenericDAO;
import br.com.gerenciadorBancario.dao.UserDAO;
import br.com.gerenciadorBancario.dao.impl.AccountDAOImpl;
import br.com.gerenciadorBancario.dao.impl.BankDAOImpl;
import br.com.gerenciadorBancario.dao.impl.GenericDAOImpl;
import br.com.gerenciadorBancario.dao.impl.UserDAOImpl;
import br.com.gerenciadorBancario.entities.Account;
import br.com.gerenciadorBancario.entities.Bank;
import br.com.gerenciadorBancario.entities.User;
import br.com.gerenciadorBancario.util.JpaUtil;

public class GerenciadorBancario {

	public static void main(String[] args) {
		
		AccountDAO AccDAO = new AccountDAOImpl();
		UserDAO UserDAO = new UserDAOImpl();
		BankDAO BankDAO = new BankDAOImpl();
		GenericDAO genericDAO = new GenericDAOImpl();
		Account Acc = new Account();
		Bank bank = new Bank();
		User user = new User();
	
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(1990, 2, 22);
//		user.setName("Uel, o bruxo dos prints");
//		user.setCpf("23854920321");
//		user.setBirthday(calendar);
//		UserDAO.create(user);
//		bank.setName("Printesco");
//		bank.setCnpj("2356735443");
//		bank.setManager("Uel");
//		BankDAO.create(bank);
		Acc.setUser(UserDAO.getId(user, 1));
		Acc.setBank(BankDAO.getId(bank, 1));
		Acc.setPassword("123456789");
		Acc.setBalance(3000.00);
		Acc.setNumConta(3275934);
		AccDAO.create(Acc);

	}
}
