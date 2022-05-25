package com.corso.service;

import java.sql.Connection;
import java.util.List;

import com.corso.config.ConnectionDb;
import com.corso.model.User;

public class TestMain {
	
	public static void main(String args[]) {
		
	
	
	UserServiceImpl service= new UserServiceImpl();
	List < User > listUser = service.getAllUser();
	listUser.forEach(s->System.out.println(s.toString()));
	
	
		
		
	}

}
