package test;
import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class SelectedTrainServlet extends HttpServlet{
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
			String fname = c[0].getValue();
			pw.println("WELCOME:" +fname+ "<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Link.html");
			rd.include(req, res);
			ServletContext sct = this.getServletContext();
			@SuppressWarnings("unchecked")
			ArrayList<TrainBean> al = (ArrayList<TrainBean>) sct.getAttribute("JefRef");
			pw.println("<br>--TrainDetails--<br>");
			String tNo = req.getParameter("tno");
			Predicate<TrainBean> p1 = (z)->z.gettName().equals(tNo);
			al.forEach((k)->
			{
					TrainBean tb = (TrainBean)k;
					if(p1.test(tb)) {
				pw.println(tb.gettNo()+"&nbsp&nbsp"+tb.gettName()+"&nbsp&nbsp"+tb.getfStation()+"&nbsp&nbsp"+tb.gettStation()+"&nbsp&nbsp"+tb.getAvl());
					}
			});
		}
	}
}
