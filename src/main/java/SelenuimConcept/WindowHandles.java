//package SelenuimConcept;
//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class WindowHandles {
//
//	WebDriver driver;
//
//	@Test
//	public void launchBrowser() {
//		System.setProperty("webdriver.chrome.driver", "/Users/benyamhailu/Downloads/chromedriver");
//		driver = new ChromeDriver();
//
//		driver.get("https://www.yahoo.com/");
//		
//	
//		//driver.manage().window().maximize();
//		//driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//		driver.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("xpath");
//		driver.findElement(By.xpath("//input[@class='rapid-noclick-resp _yb_1em5b']")).click();
//		driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
//		
//		
//		
//		for(String i : driver.getWindowHandles()) {
//			System.out.println(i);
//			driver.switchTo().window(i);
//		}
//		
//		driver.findElement(By.linkText("CSS")).click();
//		
//	}
//	
//


