package test_suite;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class popup {
	WebDriver driver;
	
	@BeforeTest
	public void visit() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html#google_vignette");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	@Test
	public void alert_box() throws InterruptedException {
		WebElement pop1 = driver.findElement(By.id("alertBox"));
		pop1.click();
		Thread.sleep(4000);
		Alert a_box = driver.switchTo().alert();
		a_box.accept();
		Thread.sleep(4000);
		String pop_output1 = driver.findElement(By.id("output")).getText();
		boolean verify = pop_output1.contains("selected");
		Assert.assertTrue(verify);
		
		
	}
	@Test
	public void cnf_box() throws InterruptedException {
		WebElement pop2 = driver.findElement(By.id("confirmBox"));
		pop2.click();
		Thread.sleep(4000);
		Alert c_box = driver.switchTo().alert();
		c_box.accept();
		Thread.sleep(4000);
		
	}
	@Test
	public void prm_box() throws InterruptedException {
		WebElement pop3 = driver.findElement(By.id("promptBox"));
		pop3.click();
		Thread.sleep(4000);
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("Sagar");
		prompt.accept();
		Thread.sleep(4000);
	}
	@AfterTest
	public void close() {
		driver.quit();
	}

}
