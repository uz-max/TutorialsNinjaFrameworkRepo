package com.tuturialsninja.qa.utils;

import java.util.Date;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_WAIT_TIME=5;
	
	//Method for random TimeStamp used in Credentials
		public static String generateTimeStamp() {
			
			Date date = new Date();
			return date.toString().replace(" ","_").replace(":","_");
			}

}
