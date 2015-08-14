import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestOne {

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
	    
	    
	    //create new account form
	    WebElement Accountmenu = driver.findElement(By.xpath("//a[@href='#Accounts']"));
	    Accountmenu.click();
	    WebElement Createbutton = (new WebDriverWait(driver, 30))
	    		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@name='create_button']")));
	    Createbutton.click();
	    
	    
	    //fill out form
	    
		    //title
		    WebElement accountTitle = driver.findElement(By.cssSelector("input[name='name']"));
		    accountTitle.sendKeys("testTitle"+r);
		  
		    //input street address
		    driver.findElement(By.cssSelector("textarea[name='billing_address_street']")).sendKeys("test street");
		    
		    //input postal code
		    driver.findElement(By.cssSelector("input[name='billing_address_po_box_c']")).sendKeys("6");
		 
		    //input city
		    driver.findElement(By.cssSelector("input[name='billing_address_city']")).sendKeys("test city");
		    
		    //input postal code
		    driver.findElement(By.cssSelector("input[name='billing_address_postalcode']")).sendKeys("12345");
		    
		    
		    
		    //select country
		    
		    WebElement countryDropdown = (new WebDriverWait(driver, 30))
		    		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[4]/div/div/div[1]/div/div/div/div[3]/div/div/div[1]/div[6]/div[1]/span/span/span[6]/div/a/span[1]")));
		    countryDropdown.click();
		    WebElement selectCountry = (new WebDriverWait(driver, 30))
		    		.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li[class='select2-results-dept-0 select2-result select2-result-selectable']")));
		    selectCountry.click();
		   
		    //select account owner
		    WebElement accountOwnerDropdown = (new WebDriverWait(driver, 30))
		    		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[4]/div/div/div[1]/div/div/div/div[3]/div/div/div[1]/div[4]/div[2]/span/span/div/a/span[1]")));
		    accountOwnerDropdown.click();
		    WebElement selectAccountOwner = (new WebDriverWait(driver, 30))
		    		.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li[class='select2-results-dept-0 select2-result select2-result-selectable']")));
		    selectAccountOwner.click();
		    
		    //select account subtype - regional
		    WebElement accSubTypeDropdown = (new WebDriverWait(driver, 30))
		    		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[4]/div/div/div[1]/div/div/div/div[3]/div/div/div[1]/div[6]/div[2]/span/span/div/a/span[1]")));
		    accSubTypeDropdown.click();
		    WebElement AccountSubtype = (new WebDriverWait(driver, 30))
		    		.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li[class='select2-results-dept-0 select2-result select2-result-selectable']")));
		    AccountSubtype.click();
		    
		  
		    
		    //select account subtype - local
		    
		   WebElement accSubTypeDropdown2 = (new WebDriverWait(driver, 30))
		 		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div/div[4]/div/div/div[1]/div/div/div/div[3]/div/div/div[1]/div[5]/div[2]/span/span/div/a/span[1]")));
		    accSubTypeDropdown2.click();
		    
		    WebElement AccountSubtype2 = (new WebDriverWait(driver, 30))
		  		//.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[id='select2-results-315']li li li")));
		    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='select2-results-315']/li[2]")));

		    
		    List<WebElement> dropdown = driver.findElements(By.cssSelector("ul[id='select2-results-315'] li"));
		    System.out.println(dropdown.size());
		    dropdown.get(3).click();
		    
		    //AccountSubtype2.click();
		    
		    
		    
		    //save button
		    WebElement saveButton = (new WebDriverWait(driver, 30))
		    		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[4]/div/div/div[1]/div/div/div/div[1]/h1/div/span[3]/span/a")));
		    saveButton.click();
		    
		    
		    //open created account
		    Accountmenu.click();
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    WebElement newAccount = (new WebDriverWait(driver, 30))
		    		.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ellipsis_inline>a")));
		    newAccount.click();
		    
		    
		    
	//driver.quit();
	}

}
