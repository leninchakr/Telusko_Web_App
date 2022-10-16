package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "M0", urlPatterns = { "/calculation" })
public class Calculator extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		float i = Float.parseFloat(req.getParameter("n1"));
		float j = Float.parseFloat(req.getParameter("n2"));
		String act = req.getParameter("operation");

		/*	Session is created by TomCat. Just have hold on it!	*/
		HttpSession session = req.getSession();
		
		session.setAttribute("i", i);
		session.setAttribute("j", j);
		
		/*	Now data is stored in session. How to get it in another Servlet	*/
		
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
		
		resp.sendRedirect(urlP);
	}
}
