package org.amazon;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLink {

	public static void main(String[] args) throws IOException {
		
		System.getProperty("webdriver.chrome.driver",
				"C:\\Users\\MINNIE\\eclipse-workspace\\Xpath\\driver\\chromedriver.exe");
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("remote-allow-origins=*");
		ops.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		ops.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.navigate().to("https://www.facebook.com/");
		
		List<WebElement> elements = driver.findElements(By.tagName("img"));
		System.out.println(elements.size());
		
		int count=0;
		for (int i = 0; i < elements.size(); i++) {
			WebElement element = elements.get(i);
			String attribute = element.getAttribute("src");
			System.out.println(attribute);
			
			if(attribute!=null) {
				URL url = new URL(attribute);
				URLConnection openConnection = url.openConnection();
				HttpURLConnection http = (HttpURLConnection)openConnection;
				int r = http.getResponseCode();
				
				if(r!=200) {
					count++;
					System.out.println("broken images : "+attribute);
				}
			}
			
			 
		}
		System.out.println("broken images count:"+ count);
		
	}
}
