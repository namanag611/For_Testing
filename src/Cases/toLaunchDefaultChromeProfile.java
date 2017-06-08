package Cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class toLaunchDefaultChromeProfile {

	
	@Test
	public void tabs() throws InterruptedException {
	
	String userProfile= "C:\\Users\\namanagrawal\\AppData\\Local\\Google\\Chrome\\User Data\\";
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jar\\chromedriver_win32\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("user-data-dir="+userProfile);
	options.addArguments("--start-maximized");
	WebDriver driver = new ChromeDriver(options);
	Thread.sleep(2000);
	driver.get("http://www.google.com");
	}
}
