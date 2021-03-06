package apptest;


import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.experitest.appium.SeeTestClient;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class WP_InteracaoProduto extends BaseTest implements GlobalConstants { 
	protected AndroidDriver<AndroidElement> driver = null;
	protected SeeTestClient client;
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		init(deviceQuery);
		// Init application / device capabilities
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.consul.android.smartbeer.staging/com.whirlpool.ted.View.SplashActivity");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.consul.android.smartbeer.staging");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.whirlpool.ted.View.SplashActivity");
		dc.setCapability("testName", "wp_TED_GalaxyS6PlusInteracaoProduto");
		dc.setCapability("deviceQuery", "@serialnumber='1115fbd4746c2f05'");
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
	}
		
	@Test
	 public void testeinteracaoproduto() {
		  client.applicationClearData("com.consul.android.smartbeer.staging");
    	  driver.startActivity("com.consul.android.smartbeer.staging", "com.whirlpool.ted.View.SplashActivity");
		  try{Thread.sleep(esperandogif);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
    	  driver.findElement(By.xpath("//*[@id='edEmail']")).sendKeys("tedmonitoramento@gmail.com");
    	  driver.findElement(By.xpath("//*[@id='edPassword']")).sendKeys("Smart2000");
    	  driver.findElement(By.xpath("//*[@text='Entrar']")).click();
    	  try{Thread.sleep(esperandogif+4000);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@text='Controles']")).click();
    	  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@id='imgTemp']")).click();
    	  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@id='imgTemp']")).click();
    	  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@id='imgTemp']")).click();
    	  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@id='imgTemp']")).click();
    	  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@id='imgHappyHour']")).click();
    	  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@id='imgHappyHour']")).click();
    	  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@text='Travar painel']")).click();
    	  try{Thread.sleep(esperandogif);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@text='Destravar painel']")).click();
    	  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@id='imgTemp']")).click();
    	  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
    	  driver.findElement(By.xpath("//*[@id='imgTemp']")).click();
      	 }

	@AfterMethod
	public void tearDown(ITestResult tr){
		if (driver!=null)
		{
			if (tr.isSuccess()) 
			{
				client.report("Test has passed", true);
			}
			else {
				client.report("Test has failed", false);
			}
			System.out.println("report URL : " + driver.getCapabilities().getCapability("reportUrl"));
			client.releaseDevice("ce061716ba5f3cdd0d7e", true, false, true);
			driver.quit();
		}
	}
}


