package com.corso.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corso.model.User;
import com.corso.service.UserServiceImpl;


@WebServlet("/list")
public class UserList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private UserServiceImpl userServiceImpl;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        userServiceImpl = new UserServiceImpl();
    	List < User > listUser = userServiceImpl.getAllUser();
        request.setAttribute("listUser", listUser);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }
    
}
