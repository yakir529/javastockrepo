package com.mycompany.stock.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.app.model.Stock;

import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("serial")
public class StockDetailsServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 11, 15);
		
		// stock #1
		float ask1 = (float) 13.1;
		float bid1 = (float) 12.4;
		Date date1 = cal.getTime();
		Stock st1 = new Stock("PIH", ask1, bid1, date1);

		// stock #2
		float ask2 = (float) 5.78;
		float bid2 = (float) 5.5;
		Date date2 = cal.getTime();
		Stock st2 = new Stock("ALL", ask2, bid2, date2);

		// stock #3
		float ask3 = (float) 32.2;
		float bid3 = (float) 31.5;
		Date date3 = cal.getTime();
		Stock st3 = new Stock("CAAS", ask3, bid3, date3);		
		
		resp.getWriter().println(st1.getHtmlDescription());			
		resp.getWriter().println(st2.getHtmlDescription());			
		resp.getWriter().println(st3.getHtmlDescription());	
				
	}

}
