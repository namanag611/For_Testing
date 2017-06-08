package Cases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class upload_file_using_robot_01 {

	FirefoxDriver fd;

	String URL = "https://encodable.com/uploaddemo/";

	@Test
	public void testUpload() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\Mars\\Nucento_X2\\Browsers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get(URL);
		WebElement element = driver.findElement(By.name("uploadname1"));
		element.click();
		uploadFile("C:\\Users\\namanagrawal\\Desktop\\Test_Videos\\v2.JPG");
		Thread.sleep(2000);
	}

	/**
	 * This method will set any parameter string to the system's clipboard.
	 */
	public static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste
		// operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void uploadFile(String fileLocation) {
		try {
			// Setting clipboard with file location
			setClipboardData(fileLocation);
			System.out.println(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
