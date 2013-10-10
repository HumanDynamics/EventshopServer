package com.eventshop.backend;

public class StreamHandlerSingleton {

	private static StreamHandler instance = null;	
	protected StreamHandlerSingleton() {
	}

	public static StreamHandler getInstance() {
		if (instance == null) {
			instance = new StreamHandler();
		}
		return instance;
	}
}
