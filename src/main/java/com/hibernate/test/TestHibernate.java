package com.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.hibernate.model.Account;
import com.hibernate.model.Address;
import com.hibernate.model.Certificate;
import com.hibernate.model.EmployeeEntity;

public class TestHibernate {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Account acc1 = new Account();
			acc1.setAccountNumber("283747238");

			Account acc2 = new Account();
			acc2.setAccountNumber("738982381");

			Account acc3 = new Account();
			acc3.setAccountNumber("509826372");

			Address add1 = new Address();
			add1.setAddress("Address detail 1");

			Address add2 = new Address();
			add2.setAddress("Address detail 2");

			Address add3 = new Address();
			add3.setAddress("Address detail 3");

			Address add4 = new Address();
			add4.setAddress("Address detail 4");

			Certificate c1 = new Certificate();
			c1.setCertificationCourse("HIBERNATE");

			Certificate c2 = new Certificate();
			c2.setCertificationCourse("JAVA");

			// Add new Employee object
			EmployeeEntity emp = new EmployeeEntity();
			emp.setEmail("demo-user@mail.com");
			emp.setFirstName("demo");
			emp.setLastName("user");
			emp.setMobileNumber("8294098765");

			EmployeeEntity secondEmployee = new EmployeeEntity();
			secondEmployee.setEmail("demo-user-second@mail.com");
			secondEmployee.setFirstName("demo-two");
			secondEmployee.setLastName("user-two");
			secondEmployee.setMobileNumber("9094098765");

			EmployeeEntity thirdEmployee = new EmployeeEntity();
			thirdEmployee.setEmail("demo-user-three@mail.com");
			thirdEmployee.setFirstName("demo-three");
			thirdEmployee.setLastName("user-three");
			thirdEmployee.setMobileNumber("7094098913");

			Set<Address> addressOfFirstEmployee = new HashSet<Address>();
			addressOfFirstEmployee.add(add1);
			addressOfFirstEmployee.add(add2);

			Set<Address> addressOfSecondEmployee = new HashSet<Address>();
			addressOfSecondEmployee.add(add3);

			Set<Address> addressOfThirdEmployee = new HashSet<Address>();
			addressOfThirdEmployee.add(add4);

			emp.setAddress(addressOfFirstEmployee);
			secondEmployee.setAddress(addressOfSecondEmployee);
			thirdEmployee.setAddress(addressOfThirdEmployee);

			emp.setAccount(acc1);
			secondEmployee.setAccount(acc2);
			thirdEmployee.setAccount(acc3);

			Set<Certificate> certificatesOfFirstEmployee = new HashSet<Certificate>();
			certificatesOfFirstEmployee.add(c1);
			certificatesOfFirstEmployee.add(c2);

			Set<Certificate> certificatesOfSecondEmployee = new HashSet<Certificate>();
			certificatesOfSecondEmployee.add(c1);

			Set<Certificate> certificatesOfThirdEmployee = new HashSet<Certificate>();
			certificatesOfThirdEmployee.add(c1);

			emp.setCertifications(certificatesOfFirstEmployee);
			secondEmployee.setCertifications(certificatesOfSecondEmployee);
			thirdEmployee.setCertifications(certificatesOfThirdEmployee);

			session.save(emp);
			session.save(secondEmployee);
			session.save(thirdEmployee);

			session.getTransaction().commit();
			// HibernateUtil.shutdown();
		} catch (Exception e) {

			if (null != session.getTransaction()) {
				System.out.println("Transaction Is Being Rolled Back");
				session.getTransaction().rollback();
			}

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
