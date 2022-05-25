package com.corso.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corso.exception.UserValidationException;
import com.corso.model.User;
import com.corso.service.UserServiceImpl;

@WebServlet("/newInsertPost")
public class NewInsertPost extends HttpServlet {
	UserServiceImpl service = new UserServiceImpl();

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("newInsert.jsp");

		
		
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		User user = new User();
		user.setName(name);
		user.setCountry(country);
		user.setEmail(email);
		
		try {
			
			validation2(user); 
			
			service.saveUser(user);
			
			request.getSession().setAttribute("lastUserNameInsert", user.getName());
			
			//dispatcher = request.getRequestDispatcher("home");
			response.sendRedirect("/GestionaleCorso/");
		} catch (UserValidationException e) {
			
			request.setAttribute("ex", e.getMessage());
			dispatcher.forward(request, response);
		}
		
		
		//List<String> errori=validation(user);
		//if(!errori.isEmpty()) {
			
		//request.setAttribute("errorList", errori);
		//dispatcher = request.getRequestDispatcher("newInsert.jsp");
		//}
		//else {
			
		//service.saveUser(user);
		//dispatcher = request.getRequestDispatcher("home.jsp");
		//}
		
	

	}
	
	
	protected List<String> validation(User user) {
		
		List<String> errori = new ArrayList();
		
		if(user.getName()==null || user.getName()=="") {
			errori.add("il campo nome non puo' essere null");
		}
		if(user.getCountry()==null || user.getCountry()=="") {
			errori.add("il campo country non puo' essere null");
		}
		if(user.getEmail()==null || user.getEmail()=="") {
			errori.add("il campo email non puo' essere null");
		}
		
		return errori;
	}
	
    protected void validation2(User user) throws UserValidationException {
		
	
		
		if(user.getName()==null || user.getName()==""||user.getCountry()==null || user.getCountry()==""||
				user.getEmail()==null || user.getEmail()=="") {
			throw new UserValidationException("i campi del form sono tutti obbligatori");
		}
		
	}
}
