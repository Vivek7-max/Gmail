package genericUtility;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listenerImplementation extends BaseClass implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Hi");
		WebElement error = driver.findElement(By.xpath("//span[text()='This site can’t be reached']"));
		if (error.isDisplayed()) {
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
		 
		System.out.println("implemented after failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}
}