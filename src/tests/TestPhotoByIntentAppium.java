package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestPhotoByIntentAppium {
	RemoteWebDriver remoteWebDriver;
	//setup the webdriver and launch the app.
	@Before
	public void setUp() throws MalformedURLException{
	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	  desiredCapabilities.setCapability("device", "android");
	  
	  //next command not needed when AUT started with node server using: node . --app path/to/App/app.apk
	  desiredCapabilities.setCapability("app", "D:/AUTAPK/photobyintent.apk");
	  desiredCapabilities.setCapability("app-package", "com.example.android.photobyintent");
	  desiredCapabilities.setCapability("app-activity", "com.example.android.photobyintent.PhotoIntentActivity");
	  URL url = new URL("http://127.0.0.1:4723/wd/hub");
	  remoteWebDriver = new RemoteWebDriver(url, desiredCapabilities);
	}
	
	@Test
	public void testTakeBigPicCancelSave (){
					
		WebElement smallPicButton = remoteWebDriver.findElement(By.name("Take (big) Picture"));
		smallPicButton.click();
		
		//Alternativ: By.id("com.android.camera:id/shutter_button")
		//By.name("Shutter button")
		WebElement shutter = remoteWebDriver.findElement(By.id("com.android.camera:id/shutter_button"));
		shutter.click();
		
		WebElement cancelBtn = remoteWebDriver.findElement(By.id("com.android.camera:id/btn_cancel"));
		cancelBtn.click();
	}
	
	@Test
	public void testTakeSmallPic (){
		for (int i = 1 ; i < 3 ; i++){
			
			WebElement smallPicButton = remoteWebDriver.findElement(By.name("Take (small) Picture"));
			smallPicButton.click();
			
			//Alternativ: By.id("com.android.camera:id/shutter_button")
			//By.name("Shutter button")
			WebElement shutter = remoteWebDriver.findElement(By.id("com.android.camera:id/shutter_button"));
			shutter.click();
			
			WebElement okDone = remoteWebDriver.findElement(By.id("com.android.camera:id/btn_done"));
			okDone.click();
	
			Assert.assertTrue(remoteWebDriver.findElement(By.id("com.example.android.photobyintent:id/imageView1")).isDisplayed());

		}	
	}
	
	 @After
	  public void teardown(){
		    //close the app
		    remoteWebDriver.quit();
		}
}
