package test;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class AddTrainServlet extends HttpServlet {
	public Connection con;
	@Override
	public void init() throws ServletException{
		con = DBConnection.getCon();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		String tNo = req.getParameter("tno");
		String tName = req.getParameter("tname");
		String fStation = req.getParameter("fstation");
		String tStation = req.getParameter("tstation");
		int Avl = Integer.parseInt(req.getParameter("avl"));
		TrainBean tb = new TrainBean();
		tb.settNo(tNo);
		tb.settName(tName);
		tb.setfStation(fStation);
		tb.settStation(tStation);
		tb.setAvl(Avl);
		req.setAttribute("bean", tb);
		RequestDispatcher rd = req.getRequestDispatcher("update");
		rd.include(req, res);
	}
}
