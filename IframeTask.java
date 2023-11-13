package com.learning.seleniumtask21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeTask {
	
	static WebDriver driver =null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/iframe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		WebElement frame1 =driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(frame1);
        
        
        driver.findElement(By.id("tinymce")).clear();
		Thread.sleep(1000);
        
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Hello People");
        
        Thread.sleep(2000);
       
        
        driver.close();
	}

}
