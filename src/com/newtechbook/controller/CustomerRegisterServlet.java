package com.newtechbook.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class CustomerRegisterServlet
 */
@WebServlet("/register")
public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegisterServlet() {
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
		String customerid;
		String firstname;
		String lastname;
		String gender;
		String dob;
		String address;
		String phone;
		String email;
		String password;
		try {
			customerid = request.getParameter("userid");
			firstname = request.getParameter("fname");
			lastname = request.getParameter("lname");
			gender = request.getParameter("gender");
			dob = request.getParameter("dob");
			Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
			address = request.getParameter("address");
			phone = request.getParameter("phone");
			email = request.getParameter("email");
			password = request.getParameter("password");
			CustomerDao custDao=new CustommerDaoImpl();
			Customer customer=new Customer();
			customer.setAddress(address);
			customer.setCustomerId(customerid);
			customer.setDob(dateOfBirth);
			customer.setEmail(email);
			customer.setFirstName(firstname);
			customer.setGender(gender);
			customer.setLastName(lastname);
			customer.setPassword(password);
			customer.setPhone(phone);
			if (custDao.register(customer)) {
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				request.setAttribute("customer", customer);
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
