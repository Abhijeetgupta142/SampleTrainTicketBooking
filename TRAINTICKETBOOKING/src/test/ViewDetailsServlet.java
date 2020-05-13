package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class ViewDetailsServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ServletContext sct = this.getServletContext();
		UserRegBean urb = (UserRegBean) sct.getAttribute("regBean");
		pw.println("UserName:" +urb.getUname());
		pw.println("<br>Password:" +urb.getPword());
		pw.println("<br>FirstName:" +urb.getFname());
		pw.println("<br>LastName:" +urb.getLname());
		pw.println("<br>Address:" +urb.getAddr());
		pw.println("<br>PhoneNo:" +urb.getPhno());
		pw.println("<br>MailID:" +urb.getMid());
		pw.println("<br>");
		pw.println("<form action = 'reg' method = 'post'>");
		pw.println("<input type = 'submit' value = 'Register'>");
		pw.println("</form>");
	}

}
