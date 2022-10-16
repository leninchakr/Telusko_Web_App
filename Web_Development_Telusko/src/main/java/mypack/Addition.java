package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "A", urlPatterns = { "/ad" })
public class Addition extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<h2 style=\"color:blue;text-align:center\">Addition Servlet!</h2>");

		/*	Accept cookies from client (through REQUEST object)	*/
		Cookie cookies[] = req.getCookies();		//	Client send MULTIPLE cookies

		float i = (float) 0.0;
		float j = (float) 0.0;
		
		for(Cookie c: cookies)
		{
			if (c.getName().equals("i"))
			{
				i = Float.parseFloat(c.getValue());
			}
			if (c.getName().equals("j"))
			{
				j = Float.parseFloat(c.getValue());
			}
		}
		
		float k = i + j;

		out.println("<h2 style=\"color:green;text-align:center\">Addition result: " + k + " ! </h2>");
		out.close();

	}
}
