package mypack;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "M0", urlPatterns = { "/calculation" })
public class Calculator extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		int i = Integer.parseInt(req.getParameter("n1"));
		int j = Integer.parseInt(req.getParameter("n2"));
		String act = req.getParameter("operation");
		
		String urlP = null;

		switch (act) {
		case "Add":
			urlP = "ad" + "?" + "i=" + i + "&" + "j=" + j;
			break;
		case "Subtract":
			urlP = "su" + "?" + "i=" + i + "&" + "j=" + j;
			break;
		case "Multiply":
			urlP = "mu" + "?" + "i=" + i + "&" + "j=" + j;
			break;
		case "Divide":
			urlP = "di" + "?" + "i=" + i + "&" + "j=" + j;
			break;
		default:
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			out.println("<h1>Enter the values!</h1>");
			out.close();
			break;
		}

		resp.sendRedirect(urlP);
	}
}
