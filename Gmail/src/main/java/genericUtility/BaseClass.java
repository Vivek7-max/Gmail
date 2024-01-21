package genericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver=null;
	static
	{
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
	}
	@BeforeClass
	public void openBrowser() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://login.microsoftonline.com/acumant.com/wsfed?wa=wsignin1.0&wtrealm=spn%3a00000015-0000-0000-c000-000000000000&wctx=rm%3d0%26id%3dpassive%26ru%3d%252f%253ft%253d2024-01-18T10%25253a06%25253a47.9183448Z&wct=2024-01-18T10%3a06%3a55Z&wreply=https%3a%2f%2facu-dev00789c09ec04517618bdevaos.axcloud.dynamics.com%2f");
		System.out.println("Browser Opened");
	}
	@BeforeMethod
	public void login() {
		System.out.println("Logged in");
	}
	@AfterMethod
	public void logout() {
		System.out.println("Logged out");
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		System.out.println("Browser closed");
	}
}
