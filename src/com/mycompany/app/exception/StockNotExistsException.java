package com.mycompany.app.exception;

import org.algo.exception.PortfolioException;

public class StockNotExistsException extends PortfolioException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StockNotExistsException(String symbol){
		super("The stock "+ symbol +" dosen't exist.");
	}

}