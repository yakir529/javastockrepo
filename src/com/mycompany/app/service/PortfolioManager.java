package com.mycompany.app.service;

import java.util.Calendar;

import com.mycompany.app.model.Portfolio;
import com.myorg.javacourse.yakirproject.Stock;

public class PortfolioManager {
	public Portfolio getPortfolio(){
		Calendar cal = Calendar.getInstance();
		cal.set(2015,11,15);
		
		Portfolio portfolio = new Portfolio();
		
		Stock stockA = new Stock("PIH", 13.1f, 12.4f, cal.getTime());
		Stock stockB = new Stock("ALL", 5.78f, 5.5f, cal.getTime());
		Stock stockC = new Stock("CAAS", 32.2f, 31.5f, cal.getTime());
		
		portfolio.setTitle("Portfolio#1");
		portfolio.addStock(stockA);
		portfolio.addStock(stockB);
		portfolio.addStock(stockC);
		
		return portfolio;
	}
}
