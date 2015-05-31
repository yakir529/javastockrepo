package com.mycompany.app.model;

import java.util.Calendar;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;

public class Portfolio implements PortfolioInterface{
	//----/ Private Const
	private final static int MAX_PORTFOLIO_SIZE = 5;
	
	//----/ Private
	private String title;
	private Stock[] stocks;
	private int portfolioSize = 0;
	private float balance = 0;
	
	//----/ Public
	public enum ALGO_RECOMMENDATION {BUY,SELL,REMOVE,HOLD}
	//--------/ Ctors
	public Portfolio(){
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
	}
	
	public Portfolio (Portfolio port2cpy){
		setTitle(port2cpy.getTitle());
		setStocks();
		for (int i=0; i<port2cpy.getPortfolioSize(); i++){
			Stock tempStock = new Stock(port2cpy.stocks[i]);
			addStock(tempStock); 
		}
	}
	
	public Portfolio(Stock[] stockArray) {
		// TODO Auto-generated constructor stub
		this.title = new String();
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		for (int i=0; i<stockArray.length; i++){
			addStock(stockArray[i]);
		}
		this.balance = 0;
	}

	//----/ Methods
	public boolean createInstanceAndBuyNewStock(String newSymbol, float newAsk, float newBid, int[] newDate, int newQuantity){
		Calendar cal = Calendar.getInstance();
		cal.set(newDate[0],newDate[1],newDate[2]);//----Date format-> {yyyy,dd,mm}
		Stock stk = new Stock(newSymbol, newAsk, newBid, cal.getTime());
		return buyStock(stk,newQuantity);
	}
	
	public void addStock(Stock stk2Add){
		if (!ifStockExists(stk2Add.getSymbol())){
			stk2Add.setStockQuantity(0);
			stocks[getPortfolioSize()] = stk2Add;
			portfolioSize++;
		}else System.out.println("Can’t add new stock, portfolio can have only "+MAX_PORTFOLIO_SIZE+" stocks.");
	}
	
	public boolean removeStock (String smbl){
		if (ifStockExists(smbl)){
			for (int i=1; i<=getPortfolioSize(); i++){
				if (stocks[i-1].getSymbol().equals(smbl)){
					sellStock(smbl, -1);
					getStocks()[i-1] = new Stock(getStocks()[getPortfolioSize()-1]);
					portfolioSize--;
					break;
				}
			}return true;
		}else return false;
	}
	
	public void updateBalance(float amount){
		setBalance(getBalance()+amount);
		if (getBalance()< 0) setBalance(0);
	}
	
	public boolean ifStockExists(String smbl){
		if (getPortfolioSize() > 0){
			for (int i=0; i < getPortfolioSize(); i++){
				if (getStocks()[i].getSymbol().equals(smbl))return true;
			}
		}return false;
	}
	
	public boolean sellStock(String smbl, int quantity){
		for (int i=0; i < getPortfolioSize(); i++){
			if (getStocks()[i].getSymbol().equals(smbl)){//----finding the stock
				if (quantity == -1) quantity = getStocks()[i].getStockQuantity();//----if sell all quantity
				if ((getStocks()[i].getStockQuantity() >= quantity) && (quantity > 0)){//----if quantity is valid
					updateBalance(getStocks()[i].getStockQuantity()*getStocks()[i].getBid());//----update balance
					getStocks()[i].setStockQuantity(getStocks()[i].getStockQuantity() - quantity);//----update quantity
					//if (this.getStocks()[i].getStockQuantity() == 0) this.removeStock(smbl);
					return true;
				}else System.out.println("Not enough stocks to sell");
				break;
			}
		}return false;
	}
	
	public boolean buyStock(Stock stk, int quantity){
		if ((getBalance() < stk.getAsk()) || ((getBalance()/stk.getAsk() < quantity))){//---- if user don't have money
			System.out.println("Not enough balance to complete purchase.");
		}else {
			if (quantity == -1) quantity = (int)(getBalance()/stk.getAsk());
			for (int i=0; i<=getPortfolioSize(); i++){
				if (i == getPortfolioSize()) addStock(stk);//----if stocks arr is empty or stock not found
				if (getStocks()[i].getSymbol().equals(stk.getSymbol())){
					updateBalance((quantity*stk.getAsk())*(-1));
					getStocks()[i].setStockQuantity(getStocks()[i].getStockQuantity() + quantity);
					return true;
				}
			}
		}return false;
	}
	
	public StockInterface findStock(String symbol){
		for (int i=0; i<getPortfolioSize(); i++){
			if (getStocks()[i].getSymbol().equals(symbol)) return getStocks()[i];
		}return null;
	}
	

	//--------/ Getters & Setters
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
	
	public void setStocks() {//----/ Create a new arr of stocks in size of max size
		stocks = new Stock[getMaxPortfolioSize()];
	}
	
	public String getHtmlString(){
		String rply = "<h1>Title of portfolio: "+ title +"</h1>";
		for (int i=0; i<portfolioSize; i++){
			rply += stocks[i].getHtmlDescription();
		}
		//rply += "<portfolio_value><a>portfolio value: "+this.getTotalValue()+", </a><total_stocks_value><a>total stocks value: "+this.getStocksValue()+", </a><balance><a>balance: "+this.getBalance()+"</a>";
		rply += "<a>portfolio value: "+getTotalValue()+", total stocks value: "+getStocksValue()+", balance: "+getBalance()+"</a>";
		
		return rply;
	}
	
	public int getPortfolioSize(){
		return portfolioSize;
	}
	
	public float getBalance() {
		return balance;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getStocksValue(){
		float sum = 0;
		for (int i=0; i<getPortfolioSize(); i++){
			sum += (getStocks()[i].getAsk()*getStocks()[i].getStockQuantity());
		}return sum;
	}
	
	public float getTotalValue(){return getStocksValue() + getBalance();}
	
	
}


