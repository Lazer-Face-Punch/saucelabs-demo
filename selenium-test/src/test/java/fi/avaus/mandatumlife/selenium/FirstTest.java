package fi.avaus.mandatumlife.selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest 
{

	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setupTests() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080";
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void openPage() {
		driver.get(baseUrl + "/web/guest/another");
		assertEquals("Another - Liferay", driver.getTitle());
	}

}
