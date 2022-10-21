package com.fabMail.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fabMail.dao.Emaildao;
import com.fabMail.entities.Email;
import com.fabMail.metier.IEmaildao;

/**
 * Servlet implementation class ShowmessageForm
 */
@WebServlet("/ShowmessageForm")
public class ShowmessageForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowmessageForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Email email = new Email();
		IEmaildao service = new Emaildao();
		email = service.findonebyID(id);
		System.out.print(email.toString());
		request.setAttribute("email",email);
		RequestDispatcher rd = request.getRequestDispatcher("showMailInf.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
