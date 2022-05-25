package com.corso.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.corso.config.ConnectionDb;
import com.corso.model.User;

public class UserServiceImpl implements UserService{
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
	        " (?, ?, ?);";

	    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
	    private static final String SELECT_ALL_USERS = "select * from users";
	    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
	
	


	@Override
	public void saveUser(User user) {
		ConnectionDb connectionDb=new ConnectionDb();
	      try (Connection connection = connectionDb.getConnection(); 
	    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getCountry());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            System.out.print(e.getMessage());
	        }
	    }
		
	

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUser() {
		ConnectionDb connectionDb=new ConnectionDb();
        List < User > users = new ArrayList < > ();
        try {
        	Connection connection = connectionDb.getConnection();
        	PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS); 
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                user.setCountry(country);
                users.add(user);
            }
        } catch (SQLException e) {
        	System.out.print(e.getMessage());
        }
        return users;
	}

}
