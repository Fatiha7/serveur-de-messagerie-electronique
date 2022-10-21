package com.fabMail.sending;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.http.HttpSession;

import com.fabMail.dao.Emaildao;
import com.fabMail.entities.Email;
import com.fabMail.metier.IEmaildao;

import java.util.Date;
/**
 * Servlet implementation class EmailSendingServlet
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String host ="192.168.1.5";
	private String port="25";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailSendingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("usernamelogin");
		String pass=(String)session.getAttribute("passwordlogin");
		String recipient = request.getParameter("to");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		LocalDateTime createdAt= LocalDateTime.now();
	
		Date date = java.util.Date.from(createdAt.atZone(ZoneId.systemDefault())
                .toInstant());
		try {
			System.out.print("----------fatiha------------");
			System.out.print(recipient);
			EmailUtility.sendEmail(host, port, user, pass, recipient, subject,content);
			Email email = new Email(user,recipient,content,subject,date.toString());
			IEmaildao service = new Emaildao();
			service.add(email);
			PrintWriter out = response.getWriter() ;
			out.println("<script type=\"text/javascript\">");
            out.println("alert('Email envoyé avec succès !');");
            out.println("window.location.href = \"Sent\";");
            out.println("</script>");		
            } catch (Exception ex) {
			ex.printStackTrace();
			PrintWriter out = response.getWriter() ;
			out.println("<script type=\"text/javascript\">");
            out.println("alert('Email non envoyé !');");
            out.println("window.location.href = \"HomeServlet\";");
            out.println("</script>");		} 
	
	
		//doGet(request, response);
	}

}
