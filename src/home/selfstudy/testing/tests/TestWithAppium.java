package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestWithAppium {
	WebDriver driver;
	@Before
	public void setUp() throws MalformedURLException{
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    
	    capabilities.setCapability("device","android");
	    //capabilities.setCapability("version", "4.1.2");
	    capabilities.setCapability("platform","windows");
	    capabilities.setCapability("app", "chrome");
	    
	    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	@Test
	public void testCal(){
	    driver.get("https://www.google.com/");
	    
	    // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
	    System.out.println("The page title is: " + driver.getTitle());
	}
	@After
	public void teardown(){
	    //close the app
	    driver.quit();
	}


}
