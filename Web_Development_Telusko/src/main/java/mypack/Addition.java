package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet(name = "A", urlPatterns = { "/ad" })
public class Addition extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<h2 style=\"color:blue;text-align:center\">Addition Servlet!</h2>");

		/*	All servlet must have hold on the session	*/
		HttpSession session = req.getSession();
		
		float i = (float) session.getAttribute("i");
		float j = (float) session.getAttribute("j");
		
		/*	Now data is retrived in another servlet using the same session	*/
		
		float k = i + j;

		out.println("<h2 style=\"color:green;text-align:center\">Addition result: " + k + " ! </h2>");
		out.close();

	}
}
