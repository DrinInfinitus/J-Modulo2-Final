package br.com.gerenciadorBancario.dao;

import java.util.List;

public interface GenericDAO {
	
	public List ListALL(Object object);
	
	public Object save(Object object);
	
	public Object searchForID(Object object, Integer id);
	
	public void delete(Object object);
	
	public void update(Object object);

}
