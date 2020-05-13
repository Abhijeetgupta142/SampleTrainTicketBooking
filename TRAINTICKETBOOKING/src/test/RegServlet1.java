package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class RegServlet1 extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String uName = req.getParameter("uname");
		String pWord = req.getParameter("pword");
		String fName = req.getParameter("fname");
		String lName = req.getParameter("lname");
		UserRegBean urb = new UserRegBean();
		urb.setUname(uName);
		urb.setPword(pWord);
		urb.setFname(fName);
		urb.setLname(lName);
		ServletContext sct = this.getServletContext();
		sct.setAttribute("regBean", urb);
		RequestDispatcher rd = req.getRequestDispatcher("Register2.html");
		rd.include(req, res);
	}
}
