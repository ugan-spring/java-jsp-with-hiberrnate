package com.newtechbook.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.newtechbook.dao.CustomerDao;
import com.newtechbook.dao.impl.CustommerDaoImpl;
import com.newtechbook.model.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username="", password="";
		try {
			username = request.getParameter("uname");
			password = request.getParameter("password");
			CustomerDao customerDao = new CustommerDaoImpl();
			Customer customer = customerDao.validCustomer(username, password);
			if (customer != null) {
				request.setAttribute("customer", customer);
				RequestDispatcher rd = request.getRequestDispatcher("customerProfile.jsp");

				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("loginerror.jsp");
				rd.forward(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
