package com.fabMail.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fabMail.dao.Mailboxdao;
import com.fabMail.entities.Mailbox;
import com.fabMail.metier.IMailboxdao;

/**
 * Servlet implementation class UpdateServletExc
 */
@WebServlet("/UpdateServletExc")
public class UpdateServletExc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServletExc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name = request.getParameter("Name");
		String password = request.getParameter("password");
		HttpSession S = request.getSession();
		String username=(String)S.getAttribute("usernamelogin");
		Mailbox user = new Mailbox();
		user.setName(Name);
		user.setPassword(password);
		IMailboxdao service = new Mailboxdao();
		service.updateMailbox(user, username);
		response.sendRedirect("HomeServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
