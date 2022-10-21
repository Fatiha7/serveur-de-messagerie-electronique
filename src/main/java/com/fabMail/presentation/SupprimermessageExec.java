package com.fabMail.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fabMail.dao.Emaildao;
import com.fabMail.metier.IEmaildao;



/**
 * Servlet implementation class SupprimermessageExec
 */
@WebServlet("/supprimermessageExec")
public class SupprimermessageExec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimermessageExec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession Session = request.getSession(); 
		// System.out.println(Session.getAttribute( "id" ));
	//	int id = Integer.parseInt(request.getParameter("id"));
	   // request.setAttribute("id",id);
	   // System.out.println(id);
		int id = Integer.parseInt((String) Session.getAttribute("uid"));
		
		
		IEmaildao service = new Emaildao();
		service.delete(id); 
		response.sendRedirect("HomeServlet");
		//System.out.println("fsdpdhfsdfsdof");
		//System.out.println(id);
		//<% HttpSession Session = request.getSession(); Session.setAttribute("id",e.getId()); System.out.println(e.getId()) ;%>
		
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
