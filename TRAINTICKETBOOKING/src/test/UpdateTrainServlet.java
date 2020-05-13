package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class UpdateTrainServlet extends HttpServlet{
	public Connection con;
	@Override
	public void init() throws ServletException{
		con = DBConnection.getCon();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		TrainBean tb = (TrainBean) req.getAttribute("bean");
		ServletContext sct = this.getServletContext();
		String fname = (String) sct.getAttribute("fname");
		try {
			PreparedStatement ps = con.prepareStatement("insert into train17  values(?,?,?,?,?)");
			ps.setString(1, tb.gettNo());
			ps.setString(2, tb.gettName());
			ps.setString(3, tb.getfStation());
			ps.setString(4, tb.gettStation());
			ps.setInt(5, tb.getAvl());
			int k = ps.executeUpdate();
			if(k>0) {
			pw.println("WELCOME:" +fname+ "<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Link1.html");
			rd.include(req, res);
			pw.println("<br> Train Details Updated Successfully...");
			}
		}catch(Exception e) {}
	}
	
}
