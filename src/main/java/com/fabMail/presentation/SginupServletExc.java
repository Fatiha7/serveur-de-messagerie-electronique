package com.fabMail.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class SginupServletExc
 */
@WebServlet("/SginupServletExc")
public class SginupServletExc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SginupServletExc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username =request.getParameter("userName");
		String password =request.getParameter("password");
		String password2 =request.getParameter("password2");
		String name = request.getParameter("Name");
		IMailboxdao service =new Mailboxdao();
			if(service.EmailValidation(username)) {
				//System.out.println(username+service.EmailValidation(username));
				   if(service.isValidPassword(password)) {
				  		if(password.equals(password2)) {
				  			//password=SHA6Encryption.getSHA6(password);
				  			Mailbox mailbox=new Mailbox(name,password,username);	
				  			service.addMailbox(mailbox);
				  			Mailbox Mailbox=service.findOneMailbox(password);
				  			HttpSession session = request.getSession();
				  			session.setAttribute("user", Mailbox);
							session.setAttribute("usernamelogin", username);
							session.setAttribute("passwordlogin", Mailbox.getPassword());
							System.out.println(username+Mailbox.getPassword());
				  			response.sendRedirect("HomeServlet");
				  		}else {
				  			this.getServletContext().getRequestDispatcher("/signup.jsp").forward(request,response);
				  			PrintWriter out = response.getWriter();
				  			out.println("<p> passwrod replay is inccrect </p>");
				  		System.out.println("<p> passwrod replay is inccrect </p>");
				  		}
		           }else {
				      this.getServletContext().getRequestDispatcher("/signup.jsp").forward(request,response);
					  PrintWriter out = response.getWriter();
					  out.println("<p> passwrod invalid </p>");
					  System.out.println("<p> passwrod non valid </p>");
			      }
			}else {
				this.getServletContext().getRequestDispatcher("/signup.jsp").forward(request,response);
				PrintWriter out = response.getWriter();
				out.println("<p> username invalid </p>");
				System.out.println("<p> Email non valid </p>");
			}
				
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
