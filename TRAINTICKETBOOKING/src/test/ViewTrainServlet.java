package test;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class ViewTrainServlet extends HttpServlet {
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
		if(c==null) {
			pw.println("Perform Login Process");
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");
			rd.include(req, res);
		}else {
			String fName = c[0].getValue();
			pw.println("WELCOME:" +fName+"<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Link1.html");
			rd.include(req, res);
		}
		
		try {
			PreparedStatement ps = con.prepareStatement("select  * from train17");
			ResultSet rs = ps.executeQuery();
			ArrayList<TrainBean> al = new ArrayList<TrainBean>();
			pw.println("<br>--TrainDetails--<br>");
			while(rs.next()) {
				TrainBean tb = new TrainBean(); 
				tb.settNo(rs.getString(1));
				tb.settName(rs.getString(2));
				tb.setfStation(rs.getString(3));
				tb.settStation(rs.getString(4));
				tb.setAvl(rs.getInt(5));
				al.add(tb);
				pw.println("<br>");
				pw.println("<a href = 'select?tno="+rs.getString(1)+"'>"+rs.getString(1)+"</a>");
				pw.println("&nbsp&nbsp"+rs.getString(2));
			}
			ServletContext sct = this.getServletContext();
			sct.setAttribute("JcfRef", al);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
