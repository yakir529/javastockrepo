package com.myorg.javacourse.yakirproject;
import java.util.Date;
import java.util.Calendar;

public class Stock 
{	
    private String symbol;
    private float ask, bid;
    private Date date;
    
    private int recommendation;
    private int stockQuantity;
    private final static int BUY = 0;
    private final static int SELL = 1;
    private final static int REMOVE = 2;
    private final static int HOLD = 3;
    

	public Stock(String symbol, float ask, float bid, Date date)
	{
	    this.symbol = symbol;
	    this.ask = ask;
	    this.bid = bid;
	    this.date = date;
	}

	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}	
	public void setBid(float bid) {
		this.bid = bid;
	}
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
		
	@SuppressWarnings("deprecation")
	public String getHtmlDescription()
	{
	    return "<b>Symbol</b>: " + getSymbol() +
	    	   ", <b>Ask</b>: " + getAsk() +
	    	   ", <b>Bid</b>: " + getBid() +
		       ", <b>Date</b>: " + getDate().getMonth() +  "/" + getDate().getDate() + "/"  +(1900 + getDate().getYear())+"<br>";
	}

	public int getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public static int getBuy() {
		return BUY;
	}

	public static int getSell() {
		return SELL;
	}

	public static int getRemove() {
		return REMOVE;
	}

	public static int getHold() {
		return HOLD;
	}

}
