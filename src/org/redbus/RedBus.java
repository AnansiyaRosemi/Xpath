package org.redbus;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class RedBus {
	public static void main(String[] args) throws InterruptedException {

		System.getProperty("webdriver.chrome.driver",
				"C:\\Users\\MINNIE\\eclipse-workspace\\Xpath\\driver\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

		// AND
		WebElement from = driver.findElement(By.xpath("//input[@id='src' and @type='text']"));
		from.sendKeys("Tirunelveli");

		// OR
		WebElement to = driver.findElement(By.xpath("(//input[@id='dest' or @type='text'])[2]"));
		to.sendKeys("Coimbatore");

		// starts with attributes
		WebElement date = driver.findElement(By.xpath("//span[starts-with(@class,'fl icon-calendar')]"));
		date.click();
		
		Thread.sleep(3000);
		
		//multiple attributes		
		WebElement search = driver.findElement(By.xpath("//button[@id='search_btn'][@class='fl button']"));
		search.click();
		
		//unknown tagName
		WebElement help = driver.findElement(By.xpath("//*[text()='Help']"));
		help.click();
		
	}
}
