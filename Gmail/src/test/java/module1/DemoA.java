package module1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoA {
	@Test
	public void editPurchaseOrder() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		// Start measuring the execution time in a separate thread
		Thread timeMonitorThread = new Thread(() -> monitorExecutionTime(driver));
		timeMonitorThread.start();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get("https://login.microsoftonline.com/acumant.com/wsfed?wa=wsignin1.0&wtrealm=spn%3a00000015-0000-0000-c000-000000000000&wctx=rm%3d0%26id%3dpassive%26ru%3d%252f%253ft%253d2024-01-18T10%25253a06%25253a47.9183448Z&wct=2024-01-18T10%3a06%3a55Z&wreply=https%3a%2f%2facu-dev00789c09ec04517618bdevaos.axcloud.dynamics.com%2f");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("mamatha.m@acumant.com"+Keys.ENTER);
		driver.findElement(By.name("passwd")).sendKeys("Mourya@123");
		Thread.sleep(2000);
		WebElement signInbtn = driver.findElement(By.id("idSIButton9"));
		wait.until(ExpectedConditions.elementToBeClickable(signInbtn));
		signInbtn.click();
		Thread.sleep(2000);
		driver.findElement(By.id("idSIButton9")).click();
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("USMF"+Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("modulesPaneOpener")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("navPaneModuleID")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Accounts payable")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("All purchase orders")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys("00001602"+Keys.ENTER);

		Thread.sleep(2000);
		Robot r=new Robot();
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Edit']")).click();
		List<WebElement> allEle = driver.findElements(By.xpath("//input[contains(@id,'PurchLine_ItemId')]"));
		Thread.sleep(2000);
		System.out.println(allEle.size());
		for (int i = 0; i <3; i++) {
			Thread.sleep(2000);
			allEle.get(i).click();
		}
		driver.findElement(By.xpath("//span[text()='Save']")).click();

		//		driver.quit();
	}
	private static void monitorExecutionTime(WebDriver driver) {
		long startTime = System.currentTimeMillis();
		try {
			while (!Thread.interrupted()) {
				// Sleep for a short interval
				Thread.sleep(1000);

				// Check if the execution time exceeds 90 seconds
				long currentTime = System.currentTimeMillis();
				long executionTime = currentTime - startTime;
				if (executionTime > 90000) {
					// Sender's email address and password
					final String username = "mamathamourya@gmail.com";
					final String password = "thvs quvi zisl hjph";

					// Recipient's email address
					String to = "mamathamourya@gmail.com";

					// SMTP server properties
					Properties props = new Properties();
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");

					// Get the Session object
					Session session = Session.getInstance(props,
							new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					});

					try {
						// Create a default MimeMessage object
						Message message = new MimeMessage(session);

						// Set From: header field of the header
						message.setFrom(new InternetAddress(username));

						// Set To: header field of the header
						message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

						// Set Subject: header field
						message.setSubject("Test Email from Selenium");

						// Set the actual message
						message.setText("This is a test email sent from Selenium.");

						// Send the message
						Transport.send(message);

						System.out.println("Email sent successfully");

					} catch (MessagingException e) {
						throw new RuntimeException(e);
					}
				}
				break;
			}

		} catch (InterruptedException e) {
			// Thread interrupted, exit gracefully
		}
	}
}