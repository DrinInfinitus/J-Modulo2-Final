package br.com.gerenciadorBancario.dao;

import br.com.gerenciadorBancario.entities.User;

public interface UserDAO {
	
	public User infos (User user);
	
	public User searchUser (Integer User);
	
	public void create (User user);
	
	public Object getId(Object object, int id);

}
