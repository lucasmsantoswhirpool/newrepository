package apptest;


import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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


public class WP_RecuperarSenha extends BaseTest implements GlobalConstants {
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
		dc.setCapability("testName", "wp_TED_GalaxyS6EdgePlusRecuperarSenha");
		dc.setCapability("deviceQuery", "@serialnumber='1115fbd4746c2f05'");
		driver = new AndroidDriver<>(new URL(getProperty("url",cloudProperties) +"/wd/hub"), dc);
		client = new SeeTestClient(driver);
		
	}
	
	private String getDateTime() {
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	    Date date = new Date();
	    return dateFormat.format(date);
	}
		
	@Test 
	public void testTeste_recuperar_senha_e_logar() {
		String strSenha = getDateTime();
		 client.applicationClearData("com.consul.android.smartbeer.staging");
		  driver.startActivity("com.consul.android.smartbeer.staging", "com.whirlpool.ted.View.SplashActivity");
		  try{Thread.sleep(esperandogif);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
		  driver.findElement(By.xpath("//*[@text='Esqueci minha senha']")).click();
		  driver.findElement(By.xpath("//*[@id='email']")).sendKeys("tedusp06@mailinator.com");
		  driver.swipe(821, 868, 768, 478, 448);
		  driver.findElement(By.xpath("//*[@text='Recuperar senha']")).click();
		  try{Thread.sleep(esperandogif);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Acessar sua conta']")).click();
		  driver.pressKeyCode(AndroidKeyCode.HOME);
		  driver.startActivity("com.android.chrome", "com.google.android.apps.chrome.Main");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.executeScript("client:client.swipeWhileNotFound(\"Right\", 0, 2000, \"NATIVE\", \"xpath=//*[@id='url_bar']\", 0, 6000, 2, true)");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@id='url_bar']")).sendKeys("mailinator.com/v2/inbox.jsp?zone=public&query=tedusp06");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.getKeyboard().sendKeys("{ENTER}");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Reset password instructions']")).click();
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.executeScript("client:client.swipeWhileNotFound(\"Right\", 0, 2000, \"NATIVE\", \"xpath=//*[@text='Mudar minha senha']\", 0, 8000, 2, true)");
		  try{Thread.sleep(esperandogif);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@id='new_password']")).sendKeys("S"+strSenha+"s");
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.swipe(56, 1028, 53, 962, 255);
		  driver.findElement(By.xpath("//*[@id='password_confirmation']")).sendKeys("S"+strSenha+"s");
		  driver.executeScript("client:client.swipeWhileNotFound(\"Up\", 0, 2000, \"NATIVE\", \"xpath=//*[@id='commit']\", 0, 6000, 2, true)");
		  try{Thread.sleep(esperandogif);} catch(Exception ignore){}
		  driver.pressKeyCode(AndroidKeyCode.HOME);
		  try{Thread.sleep(threadSleep);} catch(Exception ignore){}
		  driver.startActivity("com.consul.android.smartbeer.staging", "com.whirlpool.ted.View.SplashActivity");
		  try{Thread.sleep(esperandogif);} catch(Exception ignore){}
		  driver.findElement(By.xpath("//*[@text='Acesse sua conta']")).click();
		  driver.findElement(By.xpath("//*[@id='edEmail']")).sendKeys("tedusp06@mailinator.com");
		  driver.findElement(By.xpath("//*[@id='edPassword']")).sendKeys("S"+strSenha+"s");
		  driver.findElement(By.xpath("//*[@text='Entrar']")).click();
		  try{Thread.sleep(esperandogif);} catch(Exception ignore){}
		  driver.pressKeyCode(AndroidKeyCode.HOME);
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
			driver.quit();
		}
	}
	
}
