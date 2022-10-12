package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "M0", urlPatterns = { "/calculation" })
public class Calculator extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		float i = Float.parseFloat(req.getParameter("n1"));
		float j = Float.parseFloat(req.getParameter("n2"));
		String act = req.getParameter("operation");

		// Sending user data to another servlet using request object
		req.setAttribute("ii", i); // key-value pair
		req.setAttribute("jj", j); // key-value pair

		String urlP = null;

		switch (act) {
		case "Add":
			urlP = "ad";
			break;
		case "Subtract":
			urlP = "su";
			break;
		case "Multiply":
			urlP = "mu";
			break;
		case "Divide":
			urlP = "di";
			break;
		default:
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<h1>Server Error!</h1>");
			out.close();
			break;
		}

		RequestDispatcher rd = req.getRequestDispatcher(urlP); // urlP : url-pattern of the second servlet
		rd.forward(req, resp);

	}
}
