import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Constructors {

	public static WebElement usernamefield;
	public static WebElement passwordfield;
	
	public void getelements(){
FirefoxDriver driver = new FirefoxDriver();


 driver.get("http://192.168.4.54/AGFA");


WebElement usernamefield = driver.findElement(By.xpath("//input[@name='username']"));
WebElement passwordfield = driver.findElement(By.cssSelector("input[type='password']"));
		
	
	}
}