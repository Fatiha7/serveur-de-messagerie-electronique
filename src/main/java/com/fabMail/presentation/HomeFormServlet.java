package com.fabMail.presentation;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fabMail.dao.Emaildao;
import com.fabMail.entities.Email;
import com.fabMail.entities.Mailbox;
import com.fabMail.receiving.ReceivingMail;

/**
 * Servlet implementation class HomeFormServlet
 */
@WebServlet("/HomeServlet")
public class HomeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession();
       //Mailbox user = (Mailbox) session.getAttribute("user");
      // String userr=(String)session.getAttribute("usernamelogin");
		//String pass=(String)session.getAttribute("passwordlogin");
		//user.setUsername(userr);
		//user.setPassword(pass);
      // System.out.print(user.getUsername());
      // System.out.print(user.getPassword());
      //  ReceivingMail r = new ReceivingMail();
        //List<Email> emails = r.receiving(user);
        //request.setAttribute("emails",emails);
        HttpSession httpSession = request.getSession();
       Mailbox user = (Mailbox) httpSession.getAttribute("user");
       //-------------------------------------------
        Emaildao E = new Emaildao();
        Collection<Email> emails = E.findAllGET(user.getUsername());
        request.setAttribute("emails",emails);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        dispatcher.forward(request, response);
		//RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		//rd.forward(request, response);
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
