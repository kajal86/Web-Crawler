package crawler;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
 
public class Main {
	public static ArrayList<String> listOfUrls = new ArrayList();
	public static DB db = new DB();
	public static String query;
	public static void main(String[] args) throws SQLException, IOException {
		db.runSql2("TRUNCATE Record;");
		//CrawlerServlet queryy = new CrawlerServlet();
		//String query1 = queryy.getq();
		//System.out.println("query obtained" + RequestServlet.queryy);
		
		processPage("https://en.wikipedia.org/wiki/Mark_Zuckerberg");
	}
	
	public static void processPage(String URL) throws SQLException, IOException{
		//check if the given URL is already in database
		//db.runSql2("TRUNCATE Record;");
		String sql = "select * from Record where URL = '"+URL+"'";
		ResultSet rs = db.runSql(sql);
		if(rs.next()){
 
		}else{
			//store the URL to database to avoid parsing again
			sql = "INSERT INTO  `Crawler`.`Record` " + "(`URL`) VALUES " + "(?);";
			PreparedStatement stmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, URL);
			stmt.execute();
 
			//get useful information
			
			Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Mark_Zuckerberg").get();
 
			if(doc.text().contains("facebook")){
				System.out.println(URL);
				listOfUrls.add(URL);
				
			}
 
			//get all links and recursively call the processPage method
			Elements questions = doc.select("a[href]");
			for(Element link: questions){
				if(link.attr("href").contains("wikipedia.org"))
					processPage(link.attr("abs:href"));
			}
		}
	}
}