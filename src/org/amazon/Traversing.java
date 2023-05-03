package org.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Traversing {
public static void main(String[] args) {

	System.getProperty("webdriver.chrome.driver",
			"C:\\Users\\MINNIE\\eclipse-workspace\\Xpath\\driver\\chromedriver.exe");
	ChromeOptions ops = new ChromeOptions();
	ops.addArguments("--remote-allow-origins=*");
	WebDriver driver = new ChromeDriver(ops);
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	
//	WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
//	search.sendKeys("mobile");
	
	WebElement srch = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
	srch.sendKeys("books");
	
}

}
