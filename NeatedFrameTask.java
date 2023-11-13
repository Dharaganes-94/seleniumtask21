package com.learning.seleniumtask21;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NeatedFrameTask {
	
	static WebDriver driver =null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		  
	 WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
	    driver.switchTo().frame(topFrame);

	    List<WebElement> frames = driver.findElements(By.tagName("frame"));
	    int noOfFrames = frames.size();
	    System.out.println("Number of frames in the top frame: " + noOfFrames);
	        

	 WebElement leftFrame = driver.findElement(By.name("frame-left"));
	    driver.switchTo().frame(leftFrame);
	        
	    String leftFrameMsg = driver.findElement(By.xpath("//body[contains(.,'LEFT')]")).getText();
	    System.out.println("The Left frame has text "+leftFrameMsg);

	    driver.switchTo().parentFrame();
	        

	 WebElement middleFrame = driver.findElement(By.name("frame-middle"));
	    driver.switchTo().frame(middleFrame);
	        
	     String middleFrameMsg = driver.findElement(By.id("content")).getText();
	     System.out.println("The Middle frame has text "+middleFrameMsg);
	        

	    driver.switchTo().parentFrame();
	        

	 WebElement rightFrame = driver.findElement(By.name("frame-right"));
	    driver.switchTo().frame(rightFrame);

	     String rightFrameMsg = driver.findElement(By.xpath("//body[contains(.,'RIGHT')]")).getText();
	     System.out.println("The Right frame has text "+rightFrameMsg);

	   

	     driver.switchTo().parentFrame();

	     driver.switchTo().parentFrame();

	     WebElement bottomFrame = driver.findElement(By.name("frame-bottom"));
	     driver.switchTo().frame(bottomFrame);
	        

	    String bottomFrameMsg = driver.findElement(By.xpath("//body[contains(.,'BOTTOM')]")).getText();
	    System.out.println("The Bottom frame has text "+bottomFrameMsg);

	    
	     driver.switchTo().parentFrame();
	        

	    driver.switchTo().frame(topFrame);
	        
	    String TopFrameTitle= driver.findElement(By.xpath("//frameset[@name='frameset-middle']")).getText();
	     if(TopFrameTitle.contains("Frames"))
	       {
	       	System.out.println("The top frame title is Frames");
	       }
	        
	     else
	        	
	       {
	        System.out.println("The top frame title is not Frames");
           
	       }

	}
	
}


