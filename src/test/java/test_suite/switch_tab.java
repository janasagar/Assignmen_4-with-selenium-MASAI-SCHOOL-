package test_suite;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class switch_tab {
	WebDriver driver;
	
	@BeforeTest
	public void visit() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
	}
	@Test
	public void new_tab() throws InterruptedException {
		driver.findElement(By.linkText("Elemental Selenium")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parrentid = it.next();
		System.out.println(parrentid);
		
		String childtid = it.next();
		System.out.println(childtid);
		
		driver.switchTo().window(childtid);
		Thread.sleep(5000);
		
		driver.findElement(By.id("email")).sendKeys("sagarjana@gmail.com");
		Select sc = new Select(driver.findElement(By.id("options")));
		sc.selectByVisibleText("Python");
		driver.findElement(By.xpath("//input[@value='Send me test automation Pro tips']")).click();
		Thread.sleep(5000);
		String title = driver.getTitle();
		boolean t = title.contains("Thank");
		Assert.assertTrue(t);
		
		driver.switchTo().window(parrentid);
		
		
	}
	@Test(dependsOnMethods = "new_tab")
	public void login() {
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement el = driver.findElement(By.xpath("//h2[normalize-space()='Secure Area']"));
		WebDriverWait rswait =  new WebDriverWait(driver,Duration.ofSeconds(30));
		rswait.until(ExpectedConditions.visibilityOf(el));
	}
	@AfterTest
	public void close() {
		driver.quit();
	}

}
