package crawler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/Request")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String queryy;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String query = (String)request.getAttribute("query");
		
		ArrayList<String> listOfUrls = (ArrayList<String>)request.getAttribute("urls");
		queryy = query;

		PrintWriter out = response.getWriter();
		//out.println("test" + queryy);
		out.println("Results of search:" + query);
		for(String url : listOfUrls) {
			out.println(url);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/*public String getqueryformain() {
		//System.out.println("test657439" + queryy);
		return queryy;
	}*/
	
	 /*String setgivenquery(String query1) {
		query1 = queryy;
		System.out.println("test45" + query1);
		return query1;

	}*/

}
