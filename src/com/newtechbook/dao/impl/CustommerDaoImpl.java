package com.newtechbook.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.newtechbook.util.HibernateUtil;
import com.newtechbook.dao.CustomerDao;
import com.newtechbook.model.Customer;

public class CustommerDaoImpl implements CustomerDao{

	@Override
	public boolean register(Customer customer) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		try
		{
			Session session=sf.openSession();
			Transaction tx=session.beginTransaction();
			session.save(customer);
			session.flush();
			tx.commit();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Customer validCustomer(String username, String password) {
		try
		{
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session session=sf.openSession();
			Transaction tx=session.beginTransaction();
			List<Customer> result=session.createQuery("from Customer where customerId=:userName")
					.setParameter("userName", username).list();
			tx.commit();
			//Student student=new Student();
			int flag=0;
			Customer cust=new Customer();
			for(Customer customer:result)
			{
				if(customer.getCustomerId().equals(username) && customer.getPassword().equals(password))
				{
					flag=1;
					cust.setDob(customer.getDob());
					cust.setEmail(customer.getEmail());
					cust.setFirstName((customer.getFirstName()));
					cust.setGender(customer.getGender());
					cust.setLastName(customer.getLastName());
					cust.setPassword(customer.getPassword());
					cust.setPhone(customer.getPhone());
					cust.setAddress(customer.getAddress());
					cust.setCustomerId(customer.getCustomerId());
					break;
				}
			}
			if(flag==1)
			{
				return cust;
			}
			else
			{
				return null;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

}
