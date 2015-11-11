package BankBalanceLookup;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Processor
 */
@WebServlet("/Processor")
public class Processor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Processor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Customer cust = null;
		CustomerSimpleMap c = new CustomerSimpleMap();
		cust = c.findCustomer(request.getParameter("UserID"));

		String message = "";

		message = message + "<br><tr><td>" + cust.getCustID() + "</td><td>"
				+ cust.getCustName() + "</td><td>" + cust.getCustJob()
				+ "</td><td>" + cust.getCustBalance() + "</td></tr>";

		request.setAttribute("message", message);

		if (cust.getCustBalance() < 0)
			getServletContext().getRequestDispatcher("/WarningPage.jsp")
					.forward(request, response);
		else if (cust.getCustBalance() >= 0 && cust.getCustBalance() <= 99999)
			getServletContext().getRequestDispatcher("/RegularPage.jsp")
					.forward(request, response);
		else if (cust.getCustBalance() > 99999)
			getServletContext().getRequestDispatcher("/RichPage.jsp").forward(
					request, response);
		else
			getServletContext().getRequestDispatcher("/ErrorPage.jsp").forward(
					request, response);
	}

}
