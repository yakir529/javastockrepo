package com.mycompany.stock.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.app.model.Portfolio;
import com.mycompany.app.service.PortfolioManager;

@SuppressWarnings("serial")
public class PortfolioServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PortfolioManager portfolioManager = new PortfolioManager();
		
		//----set portfolio1
		Portfolio portfolio1 = portfolioManager.getPortfolio();
		
		//----set portfolio2
		Portfolio portfolio2 = new Portfolio (portfolio1);
		portfolio2.setTitle("portfolio#2");
		
		//----Hw 6 demand (sync)
		resp.getWriter().println(portfolio1.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
		
		portfolio2.removeFirstStockOnly();

		resp.getWriter().println("-----------------------------------------------------");
		resp.getWriter().println(portfolio1.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
		
		portfolio2.getStocks()[portfolio2.getPortfolioSize()-1].setBid(55.55f);
		
		resp.getWriter().println("-----------------------------------------------------");
		resp.getWriter().println(portfolio1.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
	
	}
}
