package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "D", urlPatterns = { "/di" })
public class Division extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<h2 style=\"color:blue;text-align:center\">Division Servlet!</h2>");

		/*	Hold the session and get values	*/
		HttpSession session = req.getSession();
		
		float i = (float) session.getAttribute("i");
		float j = (float) session.getAttribute("j");
		/*	Retrived data from session	*/

		float k = i / j;

		out.println("<h2 style=\"color:green;text-align:center\">Division result: " + k + " ! </h2>");
		out.close();

	}

}
