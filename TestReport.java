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

	public class TestReport {


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
		    
		    
		    //create new Report
		    WebElement reportMenu = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[1]/ul/li[7]/span/button"));
		    reportMenu.click();
		    WebElement createNew = (new WebDriverWait(driver, 30))
		    		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-navbar-menu-item='LBL_CREATE_REPORT']")));
		    createNew.click();
		    //driver.findElement(By.xpath(".//*[@id='report_type_div']/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[1]/img"));
		    

		    Actions act = new Actions(driver);
		   
		    // select report type
		    driver.switchTo().frame("bwc-frame");
		    
		    WebElement report = (new WebDriverWait(driver, 30))
		    		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='report_type_div']/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[1]/img")));
		    //module.click();
		    act.moveToElement(report).click().perform();	

		    //select module
		    //driver.switchTo().frame("bwc-frame");
		    WebElement module = (new WebDriverWait(driver, 30))
		    		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='Accounts']/tbody/tr/td[2]/a")));
		    
		    act.moveToElement(module).click().perform();	

		    driver.switchTo().frame("bwc-frame");
		    //filter
		    WebElement filter = driver.findElement(By.cssSelector("//tr[id='Accounts_name']"));
		    filter.click();
		    WebElement dropdown = driver.findElement(By.xpath("//select[@name='qualify']"));
		    Select sel = new Select(dropdown);
		    sel.selectByIndex(2);
		    
		    WebElement filterValue = driver.findElement(By.cssSelector("input[id='Accounts:name:name:2']"));
		    filterValue.sendKeys("test");
		    
		    
		    
		    
		    
			    
		//driver.quit();
		}

}


