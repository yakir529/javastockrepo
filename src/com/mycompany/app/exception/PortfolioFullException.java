package com.mycompany.app.exception;

import org.algo.exception.PortfolioException;

public class PortfolioFullException extends PortfolioException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PortfolioFullException(int size){
		super("Portfolio is full! Max stocks limitation is "+ size);
	}

}