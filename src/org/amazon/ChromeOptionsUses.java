package org.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsUses {

	public static void main(String[] args) {
		


		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ops.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		ops.addArguments("--start-maximized");
		ops.addArguments("--incognito");
//		ops.addArguments("--headless");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.amazon.in/");
		System.out.println(driver.getCurrentUrl());
		
//		driver.findElement(By.linkText("Privacy Notice")).click();
		
		driver.findElement(By.partialLinkText("Interest-Based")).click();
		
		
	}
}
