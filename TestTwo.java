import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		
		FirefoxDriver driver = new FirefoxDriver();
		Random rnd = new Random();
		int r = rnd.nextInt(100);

	    new WebDriverWait(driver, 4);
	    driver.manage().window().maximize();
	    driver.get("http://192.168.4.54/AGFA");
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    WebElement usernamefield = driver.findElement(By.xpath("//input[@name='username']"));
	    WebElement passwordfield = driver.findElement(By.cssSelector("input[type='password']"));
	    WebElement loginbutton = driver.findElement(By.xpath("//a[@name='login_button']"));
	   
	        
	    //login
	    usernamefield.sendKeys("qauser1"); 
	    passwordfield.sendKeys("asdf");
	    loginbutton.click();
	    
	    
	    //done overlay
	    WebElement done = (new WebDriverWait(driver, 30))
	    		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@track='click:tutorial_done']")));
	    done.click();
	    
	    
	    //create new Contact form
	    WebElement Accountmenu = driver.findElement(By.xpath("//a[@href='#Contacts']"));
	    Accountmenu.click();
	    WebElement Createbutton = (new WebDriverWait(driver, 30))
	    		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@name='create_button']")));
	    Createbutton.click();
	    
	    
	    //fill out form
	    
		    //Firstname
		    WebElement firstName = driver.findElement(By.cssSelector("input[name='first_name']"));
		    firstName.sendKeys("testFirstname");
		    Actions abc = new Actions(driver);
		    abc.keyDown(Keys.SHIFT).moveToElement(firstName).sendKeys("testfirst").build().perform();
		    
		    //Lastname
		    WebElement lastName = driver.findElement(By.cssSelector("input[name='last_name']"));
		    lastName.sendKeys("testLastname");
		    
		    //inputmeail
		    WebElement email = driver.findElement(By.cssSelector("input[class='newEmail input-append']"));
		    email.sendKeys("testqa@test.com");
		    
		    
		    //input street address
		    driver.findElement(By.cssSelector("textarea[name='primary_address_street']")).sendKeys("test street");
		    
		    //input city
		    driver.findElement(By.cssSelector("input[name='primary_address_city']")).sendKeys("test city");
		    
		    //input postal code
		    driver.findElement(By.cssSelector("input[name='primary_address_postalcode']")).sendKeys("12345");
		    
		    
		    
		    //select country
		    
		    WebElement countryDropdown = (new WebDriverWait(driver, 30))
		    		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[4]/div/div[1]/div[1]/div/div/div/div[3]/div/div/div[1]/div[5]/div[1]/span/span/span[5]/div/a/span[1]")));
		    countryDropdown.click();
		    WebElement selectCountry = (new WebDriverWait(driver, 30))
		    		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='select2-results-18']/li[3]")));
		    selectCountry.click();
		   

		    //save button
		    WebElement saveButton = (new WebDriverWait(driver, 30))
		    		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[4]/div/div/div[1]/div/div/div/div[1]/h1/div/span[3]/span/a")));
		    saveButton.click();
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   //duplciate save
		    
		   WebElement duplicateSave=driver.findElement(By.xpath(".//*[@id='drawers']/div/div[1]/div[1]/div/div/div/div[1]/h1/div/span[3]/span[1]/a"));
		    //if (duplicateSave.size()!=0){
		    //	duplicateSave.get(0);
		    	
		    //duplicateSave.click();
		    abc.moveToElement(duplicateSave).click().perform();		    
		   
		    	
		    
		    
		    //open created contact
		    Accountmenu.click();
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    WebElement newAccount = (new WebDriverWait(driver, 30))
		    		.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ellipsis_inline>a")));
		    newAccount.click();
		    
		   
		    
	//driver.quit();
	}

}
