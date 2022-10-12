package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "A", urlPatterns = { "/ad" })
public class Addition extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<h2 style=\"color:blue;text-align:center\">Addition Servlet!</h2>");

		float i = (float) req.getAttribute("ii");
		float j = (float) req.getAttribute("jj");

		float k = i + j;

		out.println("<h2 style=\"color:green;text-align:center\">Addition result: " + k + " ! </h2>");
		out.close();

	}
}
