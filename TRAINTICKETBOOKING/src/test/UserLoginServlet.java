package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class UserLoginServlet extends HttpServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con = DBConnection.getCon();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String uName = req.getParameter("uname");
		String pWord = req.getParameter("pword");
		try {
			PreparedStatement ps = con.prepareStatement("select * from UserTab17 where uname = ? and pword = ?");
			ps.setString(1, uName);
			ps.setString(2, pWord);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Cookie ck = new Cookie("fname", rs.getString(3));
				res.addCookie(ck);
				pw.println("WELCOME:"+rs.getString(3));
				RequestDispatcher rd = req.getRequestDispatcher("Link.html");
				rd.include(req, res);
			}
			else {
				pw.println("Invalid UserName or Password<br>");
				RequestDispatcher rd = req.getRequestDispatcher("UserLogin.html");
				rd.include(req, res);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
