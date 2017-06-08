package Cases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelExecution_CB {
	WebDriver fd;
	
	
	@BeforeMethod
	@Parameters("browser")
	public void start(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			fd=new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("chrome")){
			//Open Chrome
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jar\\chromedriver_win32\\chromedriver.exe");
			fd = new ChromeDriver();
		}
		fd.manage().window().maximize();
		
	}
	
@Test
	
	public void TC_002()
	{
		fd.get("http://monsterville.arcsqc.com/");
		//fd.get("file:///C:/Users/namanagrawal/Desktop/test.html");
		try
		{
			List<WebElement> no = fd.findElements(By.tagName("img"));
			int nooflinks = no.size();
			System.out.println("Total Images: " + nooflinks);
			for (WebElement pagelink : no)
			{
				String linktext = pagelink.getAttribute("alt");
				String link = pagelink.getAttribute("src");
				URL u = new URL(link);
				HttpURLConnection h = (HttpURLConnection) u.openConnection();
				h.setRequestMethod("GET");
				h.connect();
				int responsecode = h.getResponseCode();
				System.out.println(linktext+"\t" + link + "\t" + "Response Code: " + responsecode);
			}
		}
		catch (Exception e)
		{
			
		}
	}
	
	
	@AfterMethod
	public void end()
	{
		fd.quit();
	}
	

}
