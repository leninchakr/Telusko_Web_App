package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "M0", urlPatterns = { "/calculation" })
public class Calculator extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		float i = Float.parseFloat(req.getParameter("n1"));
		float j = Float.parseFloat(req.getParameter("n2"));
		String act = req.getParameter("operation");

		/*	How to create Cookies - Start	*/
		/*	Cookie is sent by server through RESPONSE object. Again the
		 * 	same cookie is sent to server by client	*/
		Cookie cookie1 = new Cookie("i", i+"");	//	+"" => converts to string 'i'
		Cookie cookie2 = new Cookie("j", j+"");
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		/*	Server:	Cookies is created and attached to RESP object	*/
		/*	How to create Cookies - END		*/
		
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
