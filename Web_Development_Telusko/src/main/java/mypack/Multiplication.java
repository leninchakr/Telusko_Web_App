package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "M", urlPatterns = { "/mu" })
public class Multiplication extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<h2 style=\"color:blue;text-align:center\">Multiplication Servlet!</h2>");

		float i = 0.0F;
		float j = 0.0F;
		
		/*	How to handle cookies - start	*/
			/*	Cookies (already created by Server and stored in Client) are send by
			 * REQUEST object	*/
		Cookie cookies[] = req.getCookies();
		
		for(Cookie c: cookies)
		{
			if(c.getName().equals("i"))
			{
				i = Float.parseFloat(c.getValue());
			}
			if(c.getName().equals("j"))
			{
				j = Float.parseFloat(c.getValue());
			}
		}
		
		/*	How to handle cookies - end		*/

		float k = i * j;

		out.println("<h2 style=\"color:green;text-align:center\">Multiplication result: " + k + " ! </h2>");
		out.close();

	}
}
