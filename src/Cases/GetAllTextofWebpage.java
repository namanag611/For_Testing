package Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetAllTextofWebpage {
	WebDriver wd;

	@BeforeMethod
	public void start()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\AutomationTesting\\Drivers\\chromedriver_win32\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://www.pre-employ.com/");
	}
	
	@Test
	public void getalltext()
	{
		String text=wd.findElement(By.tagName("body")).getText();
		System.out.println("Text: "+text);
	}
	
	@AfterMethod
	public void end()
	{
		wd.close();
	}

}
