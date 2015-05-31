package com.mycompany.app.model;
import java.util.Date;

import org.algo.model.StockInterface;

import com.mycompany.app.model.Portfolio.ALGO_RECOMMENDATION;

public class Stock implements StockInterface {
	//----Private Const
	/*----Ex 7 demand
    private final static int BUY = 0;
    private final static int SELL = 1;
    private final static int REMOVE = 2;
    private final static int HOLD = 3;
    */
	//----Private
    private String symbol;
    private float ask, bid;
    private Date date;
    
    private int stockQuantity;
    private ALGO_RECOMMENDATION recommendation;
    
    //----Public
	//--------Ctors
    public Stock(String symbol, float ask, float bid, Date date){
	    this.symbol = symbol;
	    this.ask = ask;
	    this.bid = bid;
	    this.date = date;
	    this.stockQuantity = 0;
	}
    
	public Stock (Stock stk2cpy){
		this.setSymbol(stk2cpy.getSymbol()); 
		this.setAsk(stk2cpy.getAsk()); 
		this.setBid(stk2cpy.getBid()); 
		this.setDate(stk2cpy.getDate());
		this.setRecommendation(stk2cpy.getRecommendation());
		this.setStockQuantity(stk2cpy.getStockQuantity());
	}

    public Stock() {
    	this.symbol = new String();
	    this.ask = 0;
	    this.bid = 0;
	    this.date = new Date();
	    this.stockQuantity = 0;
	    this.recommendation = ALGO_RECOMMENDATION.HOLD;
	}

	//--------Getters & Setters
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
	public String getHtmlDescription(){
	    return "<b>Symbol</b>: " + getSymbol() +
	    	   ", <b>Ask</b>: " + getAsk() +
	    	   ", <b>Bid</b>: " + getBid() +
	    	   ", <b>Quantity</b>: " + getStockQuantity() +
		       ", <b>Date</b>: " + (getDate().getMonth()+1) +  "/" + getDate().getDate() + "/"  +(1900 + getDate().getYear())+"<br>";
	}

	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	/*
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
	*/
	
}
