package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
	public Connection con;
	@Override
	public void init() throws ServletException{
		con = DBConnection.getCon();
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		Cookie c[] = req.getCookies();
		c[0].setValue("");
		c[0].setMaxAge(0);
		res.addCookie(c[0]);
		pw.println("Logged Out Successfully");
		RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		rd.include(req, res);
	}
	@Override
	public void destroy() {
		if(con!=null) {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}