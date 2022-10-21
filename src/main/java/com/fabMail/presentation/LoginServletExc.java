package com.fabMail.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fabMail.metier.IMailboxdao;
import com.fabMail.dao.*;
import com.fabMail.entities.Mailbox;
import com.fabMail.sha6.SHA6Encryption;


/**
 * Servlet implementation class LoginServletExc
 */
@WebServlet("/LoginServletExc")
public class LoginServletExc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletExc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username =request.getParameter("userName");
		System.out.print(username);
		String password =request.getParameter("password");
		Mailbox mailbox =new Mailbox();
		IMailboxdao service =new Mailboxdao();
		mailbox = service.findOne(username);
		//String Password = mailbox.getPassword();
		String email = service.Vpassword(username, password);
		int active=service.Vaccount(username);
		System.out.print(username);
		System.out.println("__________________________________________________\n");
		 String uu=(String)mailbox.getUsername();
		  System.out.print(active);
		  System.out.print(mailbox.getUsername());
		// String password1=SHA6Encryption.getSHA6(password);
		 // String password1 = 
		if(uu.equals(username)) {
		if (email.equals(username)&active==1) {
			System.out.print("(((((((((((((((((((((((((((((((");
			if(mailbox.getUsername().equals("fatihaaitaadibousserhan@fabmail.local")) {
				HttpSession Session = request.getSession();
				Session.setAttribute("usernamelogin", username);
				Session.setAttribute("passwordlogin", mailbox.getPassword());
				Session.setAttribute("user", mailbox);
				System.out.print("(((((((((((((((((((((((((((((((");
				response.sendRedirect("FAB_AdminServlet");
				
			}else {
			HttpSession Session = request.getSession();
			Session.setAttribute("usernamelogin", username);
			Session.setAttribute("passwordlogin", mailbox.getPassword());
			Session.setAttribute("user", mailbox);
			response.sendRedirect("HomeServlet");
			
			//this.getServletContext().getRequestDispatcher("/account.jsp").forward(request,response);
			
			}}else {
			
			response.sendRedirect("index.jsp");
		}}else {
			response.sendRedirect("index.jsp");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
