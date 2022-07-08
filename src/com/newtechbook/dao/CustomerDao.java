package com.newtechbook.dao;

import com.newtechbook.model.Customer;

public interface CustomerDao {

	boolean register(Customer customer);
	Customer validCustomer(String username,String password);
}
