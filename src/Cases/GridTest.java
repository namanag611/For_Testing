package Cases;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GridTest {

	String baseurl, nodeurl;
	WebDriver fd;
	
	//To Start Hub
	//java -jar selenium-server-standalone-2.53.1.jar -role hub
	
	//To Start Node
	//java -jar selenium-server-standalone-2.53.1.jar -role webdriver -hub http://192.168.0.12:4444/grid/register -port 5566
	
	
	@BeforeMethod
	public void start() throws MalformedURLException
	{
		//fd=new FirefoxDriver();
		baseurl= "http://monsterville.arcsqc.com/";
		//nodeurl="http://192.168.0.57:5566/wd/hub"; VM
		nodeurl="http://192.168.0.159:5566/wd/hub"; //IP of node
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\AutomationTesting\\Drivers\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(Platform.WINDOWS);
		fd= new RemoteWebDriver(new URL(nodeurl), capabilities);
	}
	
	//Code to find the broken images on web page.y
	
	@Test
	
	public void TC_002()
	{
		fd.get(baseurl);
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
	public void quit()
	{
		fd.quit();
	}
	
	
}
