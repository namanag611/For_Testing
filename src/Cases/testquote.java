package Cases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class testquote {
	
	@Test
	public void testcase() throws InterruptedException {
	// TODO Auto-generated method stub
	System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Jar\\geckodriver-v0.11.1-win32\\geckodriver.exe");
	//System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jar\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver;
	        driver =new FirefoxDriver();
	        //driver= new ChromeDriver();
	        String url ="https://quoteshark.net/";
	        driver.get(url);
	       driver.findElement(By.name("first-name")).sendKeys("Vishali");
	       Thread.sleep(10000);
	       driver.quit();
	}
	
	

	}
