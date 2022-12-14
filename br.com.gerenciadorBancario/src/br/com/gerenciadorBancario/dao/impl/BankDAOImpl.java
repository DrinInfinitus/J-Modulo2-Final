package br.com.gerenciadorBancario.dao.impl;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gerenciadorBancario.dao.BankDAO;
import br.com.gerenciadorBancario.entities.Account;
import br.com.gerenciadorBancario.entities.Bank;
import br.com.gerenciadorBancario.entities.User;
import br.com.gerenciadorBancario.util.JpaUtil;

public class BankDAOImpl implements BankDAO{
	
	EntityManager ent = JpaUtil.getEntityManager();

	@Override
	public Bank infos(Bank infos) {
		ent.getTransaction().begin();
		Query query = ent.createQuery("SELECT b.CNPJ, b.Manager FROM Account WHERE id_bank = :id_bank ")
			.setParameter("id_bank", infos).setMaxResults(1);
		ent.getTransaction().commit();
		return (Bank) query;
	}

	@Override
	public Bank searchBanks(Integer numb) {
		ent.getTransaction().begin();
		Query query = ent.createQuery("SELECT * FROM Bank");
		ent.getTransaction().commit();
		return (Bank) query;
	}

	@Override
	public void create(Bank bank) {
		try {
			ent.getTransaction().begin();
			ent.persist(bank);
			ent.getTransaction().commit();
			} catch (Exception e) {
				System.err.println(e);
				ent.getTransaction().rollback();
			} finally {
				ent.close();
			}
	}
	
	@Override
	public Object getId(Object object, int id) {
			ent.getTransaction().begin();
			Query query = ent.createQuery("SELECT b.id_bank FROM Bank WHERE id_bank = :id_bank ")
					.setParameter("id_bank", id).setMaxResults(1);
				ent.getTransaction().commit();
		return query.getSingleResult();
	}
	

}
