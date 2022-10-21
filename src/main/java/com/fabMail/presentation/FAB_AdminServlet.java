package com.fabMail.presentation;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fabMail.dao.Emaildao;
import com.fabMail.dao.Mailboxdao;
import com.fabMail.entities.Email;
import com.fabMail.entities.Mailbox;

/**
 * Servlet implementation class FAB_AdminServlet
 */
@WebServlet("/FAB_AdminServlet")
public class FAB_AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAB_AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mailboxdao E = new Mailboxdao();
        Collection<Mailbox>  mailbox = E.findallMailbox();
        request.setAttribute(" mailbox", mailbox);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Adminpage.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
