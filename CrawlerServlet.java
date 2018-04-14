package crawler;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Servlet implementation class CrawlerServlet
 */
@WebServlet("/search")
public class CrawlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String queryorg;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public CrawlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *
	 *
	 *
	 *CREATE TABLE IF NOT EXISTS `Record` (
  `RecordID` INT(11) NOT NULL AUTO_INCREMENT,
  `URL` text NOT NULL,
  PRIMARY KEY (`RecordID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query = request.getParameter("search");
		
		request.setAttribute("query", query);
		
		//queryorg = query;
		//CrawlerServlet c = new CrawlerServlet();
		//c.setAttribute("queryorg", query);
		//System.out.println("kruti query try" + queryorg);
		//Cookie cookie = new Cookie("query", query);
		//response.addCookie(cookie);
		
		String args[]=new String[1];
		try {
			Main.main(args);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("BYEBYE");
		
		//request.setAttribute("listOfUrls", listOfUrls);
		
		System.out.println(Main.listOfUrls.size());
		request.setAttribute("urls", Main.listOfUrls);
		
		RequestDispatcher rd = request.getRequestDispatcher("Request");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
