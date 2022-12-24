package br.com.gerenciadorBancario.dao.impl;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gerenciadorBancario.dao.UserDAO;
import br.com.gerenciadorBancario.entities.Account;
import br.com.gerenciadorBancario.entities.User;
import br.com.gerenciadorBancario.util.JpaUtil;

public class UserDAOImpl implements UserDAO{
	
	EntityManager ent = JpaUtil.getEntityManager();

	@Override
	public User infos(User user) {
		ent.getTransaction().begin();
		Query query = ent.createQuery("SELECT u.name, u.birthday, u.cpf FROM Account WHERE id_user = :id_user ")
			.setParameter("id_user", user).setMaxResults(1);
		ent.getTransaction().commit();
		return (User) query;
	}

	@Override
	public User searchUser(Integer User) {
		ent.getTransaction().begin();
		Query query = ent.createQuery("SELECT name, birthday, cpf, Id FROM User WHERE id_user = :id_user ")
			.setParameter("id_user", User).setMaxResults(1);
		ent.getTransaction().commit();
		return (User) query;
	}

	@Override
	public void create(User user) {
		try {
			ent.getTransaction().begin();
			ent.persist(user);
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
			Query query = ent.createQuery("SELECT u.id_user FROM User WHERE id_user = :id_user ")
					.setParameter("id_user", id).setMaxResults(1);
				ent.getTransaction().commit();
		return query.getSingleResult();
	}
}
