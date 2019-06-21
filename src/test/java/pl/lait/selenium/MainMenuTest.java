package pl.lait.selenium;

import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.ReservationPage;
import pageObjects.ReservationPage2;

public class MainMenuTest {
	
	
	WebDriver driver;
	MainPage mp = new MainPage();
	LoginPage lp = new LoginPage();
	ReservationPage rp = new ReservationPage();
	ReservationPage2 rp2 = new ReservationPage2();
	
	@Before
	public void start() {
		System.out.println("wewnątrz metody start - @before");
		driver = Init.getDriver();
	}
	
	//@Ignore
	@Test
	public void mainMenu() {
		
		
		String title = driver.getTitle();
		System.out.println(title);
		
		mp.contactLinkClick();
		mp.registerLinkClick();
		mp.supportLinkClick();
		mp.signOnLinkClick();
		
		title = driver.getTitle();
		System.out.println(title);
		
		Init.printScr(driver, "mainMenu", "menuOnly");
		
		Init.sleep(1);
	}

	@Ignore
	@Test
	public void login() {
		String title = driver.getTitle();
		System.out.println(title);
		
		
		
		mp.signOnLinkClick();
		lp.loginAs("admdz", "qwe123");
		
		title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertTrue("Page title is wrong", title.equals("Find a Flight: Mercury Tours:"));
		
		Init.sleep(1);	
	}
	@Ignore
	@Test
	public void reservationTest() {
		mp.signOnLinkClick();
		lp.loginAs("admdz", "qwe123");
		rp.oneWay();
		rp.passengersCount("2");
		rp.from("Frankfurt", "17", "5");
		rp.to("London", "19", "6");
		rp.airline("Blue Skies Airlines");
		rp.serviceBusinesClass();
		
		rp.continueButtonClick();
		
		rp2.pass0("Adaś", "Aaaa");
		rp2.continueBtnClick();
	}
	
	@After
	public void quit() {
		Init.close();
	}
	
}
