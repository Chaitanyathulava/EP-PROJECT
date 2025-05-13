package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.CustomerLoginEntity;
import com.model.CustomerLoginRemote;


/**
 * Servlet implementation class CustomerLoginServlet
 */
@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(lookup = "java:global/EP-PROJECT/CustomerLoginManager!com.model.CustomerLoginRemote")
    CustomerLoginRemote clr;
    public CustomerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		String customername= request.getParameter("customername");
		 int accno=Integer.parseInt(request.getParameter("accno"));
		 String pass= request.getParameter("pass");
		
		 
		 
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				CustomerLoginEntity e = new CustomerLoginEntity();
				 e.setCustomername(customername);
				 e.setAccno(accno);
				 e.setPass(pass);
				 clr.insert(e);
				em.persist(e);
				em.getTransaction().commit();
				
				em.close();
				emf.close();
				
					
			RequestDispatcher rd = request.getRequestDispatcher("/custlogin.jsp");
			rd.include(request, response);
					
					
	

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
}}