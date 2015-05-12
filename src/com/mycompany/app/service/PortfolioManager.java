package com.mycompany.app.service;

import java.util.Calendar;

import com.mycompany.app.model.Portfolio;
//import com.mycompany.app.model.Stock;

public class PortfolioManager {
	public Portfolio getPortfolio(){
		/*Calendar cal = Calendar.getInstance();
		cal.set(2015,11,15);*/
		
		Portfolio portfolio = new Portfolio();
		
		/*-----Ex 6 and prev
		Stock stockA = new Stock("PIH", 13.1f, 12.4f, cal.getTime());
		Stock stockB = new Stock("ALL", 5.78f, 5.5f, cal.getTime());
		Stock stockC = new Stock("CAAS", 32.2f, 31.5f, cal.getTime());
		
		Stock stockA = new Stock("PIH", 10f, 8.5f, cal.getTime());
		Stock stockB = new Stock("ALL", 30f, 25.5f, cal.getTime());
		Stock stockC = new Stock("CAAS", 20f, 15.5f, cal.getTime());
		
		portfolio.setTitle("Portfolio#1");
		portfolio.addStock(stockA);
		portfolio.addStock(stockB);
		portfolio.addStock(stockC);
		

		//-----Ex 7
		Stock stkA = new Stock("",0f,0f,cal.getTime());
		portfolio.addStock(stkA);
		*/
		return portfolio;
	}
}
