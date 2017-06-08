package Cases;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Loop {

	int AnyError = 0; // Using for form in web page if any error occurred
	ResourceBundle rb = ResourceBundle.getBundle("Elements"); // Get elements of
	// web page from
	// property file
	WebDriver driver;
	String Getphone = "";
	String Getaddress = "";
	String Getwebsite = "";
	String Getname = "";
	String Getstreet = "";
	String Getfax = "";
	int i, cl1, cl2;
	List<WebElement> numberofstate;
	int lastrow = 1;
	int changevalue = 0;

	@BeforeMethod
	public void start() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Jar\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void TC_002() throws InterruptedException {

		String baseUrl = "http://www.abfprs.org/";
		driver.get(baseUrl);
		driver.findElement(By.linkText("PHYSICIAN FINDER")).click();
		driver.findElement(By.linkText("click here")).click();
		driver.findElement(By.id("action")).click();
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(5000);
		Select sel = new Select(driver.findElement(By.id("state")));
		numberofstate = sel.getOptions();
		System.out.println(numberofstate.size());

		Iterator<WebElement> itr = numberofstate.iterator();

		for (i = changevalue; i < numberofstate.size(); i++) {
			if (numberofstate.get(i).getText().contains("Physician in the state, territory or province")
					|| numberofstate.get(i).getText().contains("United States & Territories")) {
				i = i + 1;
				continue;
			} else {
				System.out.println(numberofstate.get(i).getText());
				sel.selectByIndex(i);
				driver.findElement(By.id("certified-search")).click();
				Thread.sleep(5000);
				int dataresult = driver.findElements(By.xpath(".//*[@class='results-item']")).size();

				for (int j = 1; j <= dataresult; j++) {
					String xpath_getname = "//*[@class='results-item'][" + j + "]//div[1]//a[1]";
					Getname = driver.findElement(By.xpath(xpath_getname)).getText();
					System.out.println(Getname);
					driver.findElement(By.xpath("//*[@class='results-item'][" + j + "]//div[1]//a[1]")).click();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					if (isElementPresent(By.xpath("//*[@id='member-address1']")) == true) {
						Getstreet = driver.findElement(By.xpath("//*[@id='member-address1']")).getText();
					} else {
						cl1 = 1;
					}
					if (isElementPresent(By.xpath("//*[@id='member-fax1']")) == true) {
						Getfax = driver.findElement(By.xpath("//*[@id='member-fax1']")).getText();
					} else {
						cl2 = 2;
					}
					if (cl1 == 1 && cl2 == 2) {
						driver.findElement(By.xpath("//*[@id='results-non-active-member']/div/div/div[1]/button"))
								.click();

					} else {
						driver.findElement(By.xpath("//*[@id='printthis']/div[1]/button[1]")).click();
					}
					String xpath_getwebsite = "//*[@class='results-item'][" + j + "]//div[3]//a[1]";
					Boolean iselementpresent_website = driver.findElements(By.xpath(xpath_getwebsite)).size() != 0;
					if (iselementpresent_website == true) {
						Getwebsite = driver.findElement(By.xpath(xpath_getwebsite)).getAttribute("href");
						System.out.println(Getwebsite);
					} else {
						// Do Nothing.
					}
					String xpath_adress = "//*[@class='results-item'][" + j + "]//div[4]";
					Boolean iselementpresent_address = driver.findElements(By.xpath(xpath_adress)).size() != 0;
					if (iselementpresent_address == true) {
						Getaddress = driver.findElement(By.xpath(xpath_adress)).getText();
						System.out.println(Getaddress);
					} else {

						// Do Nothing.
					}
					String xpath_phone = "//*[@class='results-item'][" + j + "]//div[5]";
					Boolean iselementpresent_phone = driver.findElements(By.xpath(xpath_phone)).size() != 0;
					if (iselementpresent_phone == true) {
						Getphone = driver.findElement(By.xpath(xpath_phone)).getText();
						System.out.println(Getphone);
					} else {
						// continue;
					}
					// Write in XLS file
					GenerateResult(Getname, Getwebsite, Getstreet, Getaddress, Getphone, Getfax, lastrow);
					lastrow = lastrow + 1;
					reset();
				}
				System.out.println("Result Found:" + dataresult);
				// break;

			}
			driver.manage().deleteAllCookies();
			changevalue = changevalue + 1;
			TC_002();
			System.out.println("Value of i is: " + i);
		}

	}

	@AfterMethod
	public void quit() {
		// driver.quit();
	}

	public void GenerateResult(String name, String Website, String Street, String Address, String Phone, String Fax,
			int k) {
		try {
			Workbook workbook = Workbook.getWorkbook(new File(rb.getString("file_path")));
			// create a new excel and copy from existing
			WritableWorkbook copy = Workbook.createWorkbook(new File(rb.getString("file_path")), workbook);
			WritableSheet sheet = copy.getSheet(0);
			Label lname = new Label(1, k, name);
			sheet.addCell(lname);
			Label lwebsite = new Label(2, k, Website);
			sheet.addCell(lwebsite);
			Label lstreet = new Label(3, k, Street);
			sheet.addCell(lstreet);
			Label laddress = new Label(4, k, Address);
			sheet.addCell(laddress);
			Label lphone = new Label(4, k, Phone);
			sheet.addCell(lphone);
			Label lfax = new Label(5, k, Fax);
			sheet.addCell(lfax);
			System.out.println(name);
			System.out.println(Website);
			System.out.println(Street);
			System.out.println(Address);
			System.out.println(Phone);
			System.out.println(Fax);

			copy.write();
			copy.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// log.debug("Exception Occured while generating the result:
			// "+e.getMessage());
			Assert.fail();
		}
	}

	public void reset() {
		Getphone = "";
		Getaddress = "";
		Getwebsite = "";
		Getname = "";
		Getstreet = "";
		Getfax = "";
		// driver.manage().deleteAllCookies();
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElements(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
