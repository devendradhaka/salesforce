package com.psl.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String textmsg = request.getParameter("myText");
		System.out.println(textmsg);
		String respmsg = "You wrote ::" + textmsg;
		System.out.println(respmsg);
		request.setAttribute("respmsg", respmsg);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("Requester.jsp");
		requestDispatcher.forward(request, response);
	}
}
