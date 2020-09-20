package SelenuimConcept;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CrmTest {

	WebDriver driver;
	
	String browser = "null";
	@BeforeTest
	public void readConfig() {
		//READER FILES
		//Input stream
		//Buffer Reader
		//FileReader
		//Scanner
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("./src/main/java/config/config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println(browser);
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
	}
	@BeforeMethod
	public void init(){
		
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","/Users/benyamhailu/Downloads/chromedriver");
		driver = new ChromeDriver();
		
	}else if(browser.equalsIgnoreCase("Firefox")) {
		System.setProperty("webdriver.gecko.driver","/Users/benyamhailu/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
	}
	
	

	driver.get("https://www.techfios.com/ibilling/?ng=dashboard/#");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
//	@Test(priority=1)
//	public void loginTest() throws InterruptedException {
//		//Elemeny Library
//	//Use WebElement and by locator
//	By USERNAME_FIELD_LOCATOR = By.id("username");
//		By PASSWORD_FIELD_LOCATOR = By.id("password");
//		By SIGNIN_BUTTON_LOCATOR = By.name("login");
//		
//		// Data
//		
//		String loginId = "demo@techfios.com";
//		String password = "abc123";
//		
//		driver.findElement(USERNAME_FIELD_LOCATOR).sendKeys(loginId);
//	driver.findElement(PASSWORD_FIELD_LOCATOR).sendKeys(password);
//		driver.findElement(SIGNIN_BUTTON_LOCATOR).click();
//	
//		Thread.sleep(2000);
	
	//@Test(priority=2)
	public void loginTest1() throws InterruptedException {
		//Elemeny Library
	//Use WebElement and by locator
	By USERNAME_FIELD_LOCATOR = By.id("username");
		By PASSWORD_FIELD_LOCATOR = By.id("password");
		By SIGNIN_BUTTON_LOCATOR = By.name("login");
		By DASHBOARD_BUTTON_LOCATOR = By.xpath("//span[contains(text(), 'Dashboard')]");
		// Data
		
		String loginId = "demo@techfios.com";
		String password = "abc123";
		
		driver.findElement(USERNAME_FIELD_LOCATOR).sendKeys(loginId);
		driver.findElement(PASSWORD_FIELD_LOCATOR).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON_LOCATOR).click();
	
		//A way to create a method within another method
		
		
		waitForElement(driver, 10, DASHBOARD_BUTTON_LOCATOR);
		
		Thread.sleep(2000);
		
		String dashboardValidationText = driver.findElement(DASHBOARD_BUTTON_LOCATOR).getText();
		Assert.assertEquals("Wrong Page!!!",dashboardValidationText, "Dashboard");
	}
	@Test
	public void addCustomerTest() {
		By USER_NAME_FIELD = By.id("username");
		By PASSWORD_FIELD = By.id("password");
		By SIGNIN_BUTTON = By.name("login");
		//By EXPAND_BUTTON = By.xpath("//*[@id=\"page-wrapper\"]/div[1]/nav/div/a");
		By DASHBOARD_BUTTON = By.xpath("//span[contains(text(), 'Dashboard')]");
		By CUSTOMERS_BUTTON = By.xpath("//span[contains(text(), 'Customers')]");
		By ADD_CUSTOMER_BUTTON = By.xpath("//a[contains(text(), 'Add Customer')]");
		By ADD_CONTACT_LOCATOR = By.xpath("//h5[contains(text(),'Add Contact')]");
		By FULL_NAME_FIELD = By.xpath("//input[@id='account']");
		By COMPANY_NAME_FIELD = By.xpath("//input[@id='company']");
		By EMAIL_FIELD = By.xpath("//input[@id='email']");
		By PHONE_FIELD = By.xpath("//input[@id='phone']");
		By ADDRESS_FIELD = By.xpath("//input[@id='address']");
		By CITY_FIELD = By.xpath("//input[@id='city']");
		By STATE_REGION_FIELD = By.xpath("//input[@id='state']");
		By ZIP_FIELD = By.xpath("//input[@id='zip']");
		By SUBMIT_BUTTON = By.xpath("//button[@class='btn btn-primary']");
		By LIST_CONTACTS_BUTTON = By.xpath("//a[contains(text(),'List Contacts')]");
		
		//Login Data
		String loginID = "demo@techfios.com";
		String password = "abc123";
				
		//Test Data
		String fullName = "Benyam Hailu";
		String companyName = "Techfios";
		String emailAddress = "fall@gmail.com";
		String phoneNumner = "5551234";
		
		//Login
		driver.findElement(USER_NAME_FIELD) .sendKeys(loginID);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON).click();
		
		//Validate Dashboard
		//driver.findElement(EXPAND_BUTTON).click();
		waitForElement(driver, 10, DASHBOARD_BUTTON);
		String dashboardValidationText = driver.findElement(DASHBOARD_BUTTON).getText();
		Assert.assertEquals("Wrong Page!!!",dashboardValidationText, "Dashboard");
		driver.findElement(CUSTOMERS_BUTTON).click();
		driver.findElement(ADD_CUSTOMER_BUTTON);
		waitForElement(driver, 3, ADD_CONTACT_LOCATOR);
		
		//Random number
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(999);
		//Fill out the form to add customer
		driver.findElement(FULL_NAME_FIELD).sendKeys(fullName + randomNumber);
		driver.findElement(EMAIL_FIELD).sendKeys(randomNumber + emailAddress);
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();
		
	}
		private void waitForElement(WebDriver driver, int timeInSeconds, By locator) {
			WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
}





}
