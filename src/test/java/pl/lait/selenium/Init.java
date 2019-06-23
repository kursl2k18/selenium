package pl.lait.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Init {

	
	static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/adam/Documents/LAIT/chromedriver");
	    
        //driver = new ChromeDriver();
		URL url = null;
		try {
			url = new URL("http://192.168.0.111:4444/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		
        driver = new RemoteWebDriver(url, capability);
        
        driver.get("http://newtours.demoaut.com");
        
        return driver;	
	}
	
	public static void sleep(int seconds) {
    	try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public static void close() {
		driver.quit();
	}
}
