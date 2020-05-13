package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class ViewTrainServlet2 extends HttpServlet {
	public Connection con;
	@Override
	public void init() throws ServletException{
		con = DBConnection.getCon();
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ServletContext sct = this.getServletContext();
		String fName = (String) sct.getAttribute("fname");
		try {
			PreparedStatement ps = con.prepareStatement("select * from Train17");
			ResultSet rs = ps.executeQuery();
			pw.println("WELCOME:" +fName+ "<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Link.html");
			rd.include(req,res);
			pw.println("<br>--Train Details--");
			while(rs.next()) {
				pw.println("<br>"+rs.getString(1)+"&nbsp&nbsp"+rs.getString(2)+"&nbsp&nbsp"+rs.getString(3)+"&nbsp&nbsp"+rs.getString(4)+"&nbsp&nbsp"+rs.getInt(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
