package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Hw1 {

	WebDriver driver;
	
	
	By USER_NAME_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGN_IN_BUTTON_FIELD = By.xpath("//button[@name='login']");
	By DASHBOARD_HEADER_FIELD = By.xpath("//h2[text()=' Dashboard ']");
    By BANK_CASH_FIELD= By.xpath("//span[text()= 'Bank & Cash']");
    By NEW_ACCOUNT_FIELD= By.xpath("//a[text()= 'New Account']");
    By ADD_NEW_ACCOUNT_FIELD= By.xpath("//h5[contains(text(), 'Add New Account')]");
    By ACCOUNT_TITLE_FIELD= By.xpath("//input[@id='account']");
    By DESCRIPTION_FIELD= By.xpath("//input[@id='description']");
    By INITIAL_BALANCE= By.xpath("//input[@id='balance']");
    By ACCOUNT_NUMBER_FIELD= By.xpath("//input[@id='account_number']");
    By CONTACT_PERSON_FIELD= By.xpath("//input[@id='contact_person']");
    By PHONE_FIELD= By.xpath("//input[@id='contact_phone']");
    By SUBMIT_FIELD=By.xpath("//button[@class= 'btn btn-primary']");
    
    String userName = "demo@techfios.com";
    String password = "abc123"; 
    String account = "SiruSavings";
    String description = "My life savings";
    String initialBalance = "125000";
    String accountNumber = "4387847387";
    String contactPerson = "Sirjana Pokharel";
    String phoneNumber = "7206298600";
    
    
    
    
    
	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "/Users/sirupokharel/selenium/homework1/driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testLocators() {
		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);     ;
		driver.findElement(By.name("login")).click();
	    driver.findElement(BANK_CASH_FIELD).click();
	    driver.findElement(NEW_ACCOUNT_FIELD).click();
	    
	   	Assert.assertEquals("Add new account page not found!!",driver.findElement(ADD_NEW_ACCOUNT_FIELD).getText(), "Add New Account" );
	    
	    driver.findElement(ACCOUNT_TITLE_FIELD).sendKeys(account);
	    driver.findElement(DESCRIPTION_FIELD).sendKeys(description);
	    driver.findElement(INITIAL_BALANCE).sendKeys(initialBalance);
	    driver.findElement(ACCOUNT_NUMBER_FIELD).sendKeys(accountNumber);
	    driver.findElement(CONTACT_PERSON_FIELD).sendKeys(contactPerson);
	    driver.findElement(PHONE_FIELD).sendKeys(phoneNumber);
	    driver.findElement(SUBMIT_FIELD).click();
	    
	    
	    }

	//@After
	public void tearDown() {
		driver.close();
	}

	
	
	
}
