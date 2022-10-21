package com.fabMail.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fabMail.dao.Emaildao;
import com.fabMail.dao.Mailboxdao;
import com.fabMail.metier.IEmaildao;
import com.fabMail.metier.IMailboxdao;

/**
 * Servlet implementation class BlockedAcount
 */
@WebServlet("/BlockedAcount")
public class BlockedAcount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlockedAcount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		IMailboxdao service = new Mailboxdao();
		System.out.print(username);
		int active =service.findOnee(username).getActive();
		int id = service.findOnee(username).getId();
		if(active==0) {
			service.unblockMailbox(id);
		}else {
			service.blockMailbox(id);
		} 
		response.sendRedirect("FAB_AdminServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
