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
		
		//----Hw 6 demand (sync)
		/*----set portfolio1
		Portfolio portfolio1 = portfolioManager.getPortfolio();
		
		/----set portfolio2
		Portfolio portfolio2 = new Portfolio (portfolio1);
		portfolio2.setTitle("portfolio#2");
		
		
		resp.getWriter().println(portfolio1.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
		
		portfolio1.removeStock(portfolio1.getStocks()[0].getSymbol());

		resp.getWriter().println("-----------------------------------------------------");
		resp.getWriter().println(portfolio1.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
		
		portfolio2.getStocks()[portfolio2.getPortfolioSize()-1].setBid(55.55f);
		
		resp.getWriter().println("-----------------------------------------------------");
		resp.getWriter().println(portfolio1.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
		*/
		
		//----Hw 7 demand
		//----set portfolio
		Portfolio myPortfolio = portfolioManager.getPortfolio();
		myPortfolio.setTitle("Exercise 7 portfolio");
		myPortfolio.setBalance(10000);
		
		myPortfolio.createInstanceAndBuyNewStock("PIH", 10f, 8.5f, new int[]{2014,11,15}, 20);
		myPortfolio.createInstanceAndBuyNewStock("AAL", 30f, 25.5f, new int[]{2014,11,15}, 30);
		myPortfolio.createInstanceAndBuyNewStock("CAAS", 20f, 15.5f, new int[]{2014,11,15}, 40);
		
		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");
		
		resp.getWriter().println(myPortfolio.getHtmlString());
		
	}
}
