package hybridapps;

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

public class TestHybridUsingSelendroid {
	RemoteWebDriver remoteWebDriver;
	//setup the web driver and launch the webview app.
	@Before
	public void setUp() throws MalformedURLException{
	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	  desiredCapabilities.setCapability("device", "selendroid");
	  
	  //next command not needed when AUT started with node server using: node . --app path/to/HybStopwatch.apk
	  desiredCapabilities.setCapability("app", "/Users/mm.BDCDOM/Downloads/free_Apps/HybStopwatch.apk");
	  //com.hybrid.stopwatch:2.0.4.1 or "/Users/mm.BDCDOM/Downloads/free_Apps/HybStopwatch.apk"
	  desiredCapabilities.setCapability("app-package", "com.hybrid.stopwatch");
	  desiredCapabilities.setCapability("app-activity", "com.hybrid.stopwatch.HybridStopwatch");
	  URL url = new URL("http://127.0.0.1:4723/wd/hub");
	  remoteWebDriver = new RemoteWebDriver(url, desiredCapabilities);
	}
	
	  @Test
	  public void testSomething() throws InterruptedException{
		  //switch to the web view
		  remoteWebDriver.switchTo().window("WEBVIEW");
		  /*
		  remoteWebDriver.get("http://saucelabs.com/test/guinea-pig");
		  
		  //Interact with the elements using id.
		  WebElement div = remoteWebDriver.findElement(By.id("i_am_an_id"));
		  Assert.assertEquals("I am a div", div.getText()); //check the text retrieved matches expected value
		  remoteWebDriver.findElement(By.id("comments")).sendKeys("My comment"); //populate the comments field by id.
		 */
		  Thread.sleep(10000);
		  //leave the webview to go back to native app.
		  remoteWebDriver.switchTo().window("NATIVE_APP");
		  }

	  //close the app.
	  @After
	  public void teardown(){
		    //close the app
		    remoteWebDriver.quit();
		}
}
