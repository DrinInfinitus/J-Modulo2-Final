package br.com.gerenciadorBancario.dao.impl;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gerenciadorBancario.dao.GenericDAO;
import br.com.gerenciadorBancario.util.JpaUtil;

public class GenericDAOImpl implements GenericDAO{
	
	EntityManager ent = JpaUtil.getEntityManager();
	
	@SuppressWarnings("rawtypes")
	@Override
	public List ListALL(Object object) {
		Query query = ent.createQuery("FROM " + object.getClass().getSimpleName());
		return query.getResultList();
	}

	@Override
	public Object searchForID(Object object, Integer id) {
		try {
		ent.getTransaction().begin();
		Object retorno = ent.find(object.getClass(), id);
		if (Objects.nonNull(retorno)) {
			return retorno;
		}
		} catch (Exception e) {
			System.err.println(e);
			ent.getTransaction().rollback();
		} finally {
			ent.close();
		}
		return null;
	}

	@Override
	public void delete(Object object) {
		try {
		ent.getTransaction().begin();
		ent.remove(object);
		ent.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			ent.getTransaction().rollback();
		} finally {
			ent.close();
		}
	}

	@Override
	public Object save(Object object) {
		try {
			ent.getTransaction().begin();
			ent.persist(object);
			ent.getTransaction().commit();
			} catch (Exception e) {
				System.err.println(e);
				ent.getTransaction().rollback();
			} finally {
				ent.close();
			}
		return null;
	}

	@Override
	public void update(Object object) {
		try {
			ent.getTransaction().begin();
			ent.merge(object);
			ent.getTransaction().commit();
			} catch (Exception e) {
				System.err.println(e);
				ent.getTransaction().rollback();
			} finally {
				ent.close();
			}
		
	}

}
