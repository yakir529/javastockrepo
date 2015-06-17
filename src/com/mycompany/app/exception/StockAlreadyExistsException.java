package com.mycompany.app.exception;

import org.algo.exception.PortfolioException;

public class StockAlreadyExistsException extends PortfolioException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StockAlreadyExistsException(String symbol){
		
		super("Adding stock  "+ symbol +" is not allowed! This stock is already exists!");
	}

}