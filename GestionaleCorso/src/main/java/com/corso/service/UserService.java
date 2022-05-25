package com.corso.service;

import java.util.List;

import com.corso.model.User;

public interface UserService {
	
	public void saveUser(User user);
	public void deleteUser(int id);
	public User getUserById(int id);
	public void updateUser(User user);
	public List<User> getAllUser();

}
