package com.servlet;

import java.io.IOException;

import com.dao.User1;
import com.dao.UserDao;
import com.dao.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private static UserDao userDao = new UserDaoImpl();   
   /**
     * @see HttpServlet#HttpServlet()     
     */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		    String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String email = request.getParameter("email");

	        User1 user = new User1();
	        user.setUsername(username);
	        user.setEmail(email);
	        user.setPassword(password);

	        
			//UserDao userDao = new UserDaoImpl();
	        if (userDao.addUser(user)) 
	        {
	            response.sendRedirect("login.jsp?registration=success");
	        } 
	        else 
	        {
	            response.sendRedirect("register.jsp?error=1");
	        }
	    }
}


