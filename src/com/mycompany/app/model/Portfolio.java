package com.mycompany.app.model;

import com.myorg.javacourse.yakirproject.Stock;

public class Portfolio {
	//----Private
	private String title;
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private int portfolioSize = 0;
	
	//----Public
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public static int getMaxPortfolioSize() {
		return MAX_PORTFOLIO_SIZE;
	}
	
	public Stock[] getStocks() {
		return stocks;
	}
	
	//----Create a new arr of stocks in size of max size
	public void setStocks() {
		this.stocks = new Stock[getMaxPortfolioSize()];
	}
	
	public Portfolio(){
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
	}
	
	//----Add a new stock with the same ptr to instance in memory of stk2Add
	public void addStock(Stock stk2Add){
		stocks[portfolioSize] = stk2Add;
		portfolioSize++;
	}
	
	public String getHtmlString(){
		String rply = "<h1>"+ title +"</h1>";
		for (int i=0; i<portfolioSize; i++){
			rply = rply + stocks[i].getHtmlDescription();
		}
		return rply;
	}
	
	public int getPortfolioSize(){
		return portfolioSize;
	}
	
	//----Copy ctor for portfolio obj
	public Portfolio (Portfolio port2cpy){
		this.setTitle(port2cpy.getTitle());
		this.setStocks();
		for (int i=0; i<port2cpy.getPortfolioSize(); i++){
			Stock tempStock = new Stock(port2cpy.stocks[i]);
			this.addStock(tempStock); 
		}
	}
	
	//----Removes the first value in the stocks arr
	public void removeFirstStockOnly (){
		if (this.portfolioSize > 0){
			for (int i=1 ; i<=this.portfolioSize ; i++){
				this.stocks[i-1] = this.stocks[i];
			}
			this.portfolioSize--;
		}
	}
	

}


