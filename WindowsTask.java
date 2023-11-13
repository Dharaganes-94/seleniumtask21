package com.learning.seleniumtask21;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsTask {
	
	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> allWindows=driver.getWindowHandles();
        
        for(String eachWindow:allWindows)
        {
			Thread.sleep(2000);
			driver.switchTo().window(eachWindow);
        }
        
        String childwindow = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
		System.out.println("Child window text-->"+childwindow);
		driver.close();
		Thread.sleep(2000);
		
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		
		String parentWindowText=driver.findElement(By.xpath("//h3")).getText();
		System.out.println("Parent window text-->"+parentWindowText);
		Thread.sleep(2000);
		

	}

}
