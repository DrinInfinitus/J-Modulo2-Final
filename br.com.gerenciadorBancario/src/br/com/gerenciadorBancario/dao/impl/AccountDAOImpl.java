package br.com.gerenciadorBancario.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gerenciadorBancario.dao.AccountDAO;
import br.com.gerenciadorBancario.entities.Account;
import br.com.gerenciadorBancario.util.JpaUtil;

public class AccountDAOImpl implements AccountDAO {
	
	EntityManager ent = JpaUtil.getEntityManager();

	@Override
	public void transfer(Account minhaConta, Account contaTransferir) {
		try {
			ent.getTransaction().begin();
			ent.merge(minhaConta);
			ent.merge(contaTransferir);
			ent.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			ent.getTransaction().rollback();
		} finally {
			ent.close();
		}
	}

	@Override
	public Account searchAccount(Integer numConta) {
		ent.getTransaction().begin();
		Query query = ent.createQuery("SELECT a FROM Account a WHERE a.numAccount = :numAccount")
				.setParameter("numAccount", numConta).setMaxResults(1);
		ent.getTransaction().commit();
		Account account = (Account) query.getSingleResult();
		ent.close();
		return  account;
	}

	@Override
	public void deposit(Account contaDepositar, Double valorDepositar) {
		contaDepositar.setBalance(contaDepositar.getBalance() + valorDepositar);
		try {
			ent.getTransaction().begin();
			ent.merge(contaDepositar);
			ent.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			ent.getTransaction().rollback();
		} finally {
			ent.close();
		}
	}

	public Account infos(Account account) {
		ent.getTransaction().begin();
		Query query = ent.createQuery("SELECT a.numAccount, a.balance a FROM Account");
		ent.getTransaction().commit();
		return (Account) query;
	}

	@Override
	public void create(Account account) {
		try {
			ent.getTransaction().begin();
			ent.persist(account);
			ent.getTransaction().commit();
			} catch (Exception e) {
				System.err.println(e);
				ent.getTransaction().rollback();
			} finally {
				ent.close();
			}
	}
}

