package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class RegServlet2 extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String Address = req.getParameter("addr");
		int PhNo = Integer.parseInt(req.getParameter("phno"));
		String MailId = req.getParameter("mid");
		ServletContext sct = req.getServletContext();
		UserRegBean urb = (UserRegBean)sct.getAttribute("regBean");
		urb.setAddr(Address);
		urb.setPhno(PhNo);
		urb.setMid(MailId);
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("User Register Details are Valid");
		pw.println("<a href = 'vdetails'>ClickHere</a>");
		pw.println("To View Details");
	}
}
