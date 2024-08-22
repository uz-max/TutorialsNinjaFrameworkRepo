package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tuturialsninja.qa.utils.Utilities;

public class Base {
		WebDriver driver;
		public Properties prop;
		
		public void loadPropertiesFile() {
			
			prop = new Properties();
			File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\Config.properties");
			try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			}catch(Throwable e) {
				e.printStackTrace();
			}
			
		}
	
		public WebDriver InitialiseBrowserAndOpenApplication(String browserName)
		{
			//Choose browser
			if(browserName.equals("chrome")){
				
				driver = new ChromeDriver();
				
			}else if (browserName.equals("edge")) {
				
				driver = new EdgeDriver();
				
			}else if (browserName.equals("safari")) {
				
				driver = new SafariDriver();
			}
	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
			driver.get(prop.getProperty("url"));
			
			return driver;
		}

}
