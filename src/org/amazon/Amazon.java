package org.amazon;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	public static void main(String[] args) {

		System.getProperty("webdriver.chrome.driver",
				"C:\\Users\\MINNIE\\eclipse-workspace\\Xpath\\driver\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		// contains attribute xpath:

		WebElement search = driver.findElement(By.xpath("(//input[contains(@class,'nav-input')])[1]"));
		search.sendKeys("iphone");

		driver.findElement(By.xpath("(//input[contains(@class,'nav-input')])[2]")).click();
		
		//starts with attribute
		
		String text = driver.findElement(By.xpath("(//span[starts-with(@class,'a-size-medium')])[2]")).getText();
		System.out.println(text);
		
		String par = driver.getWindowHandle();
		
		Set<String> all = driver.getWindowHandles();
		for (String x : all) {
			if(!par.equals(x)) {
				driver.switchTo().window(par);
			}
		}
		
		//starts with text
		driver.findElement(By.xpath("//span[starts-with(text(),'Account')]")).click();
		
		

	}
}
