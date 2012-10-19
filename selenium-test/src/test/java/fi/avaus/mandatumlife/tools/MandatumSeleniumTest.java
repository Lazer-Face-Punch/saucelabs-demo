package fi.avaus.mandatumlife.tools;

import java.net.URL;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;

public class MandatumSeleniumTest implements SauceOnDemandSessionIdProvider {

	public WebDriver driver;
	public String sessionId;

	public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(
			"Mandatum", "8e19f151-cff7-498b-a08a-7759de15420a");

	public String getSessionId() {
		return this.sessionId;
	}

//	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabillities = DesiredCapabilities.firefox();
		capabillities.setCapability("version", "14.0");
		capabillities.setCapability("platform", Platform.WINDOWS);
		this.driver = new RemoteWebDriver(
				new URL(
						"http://Mandatum:8e19f151-cff7-498b-a08a-7759de15420a@ondemand.saucelabs.com:80/wd/hub"),
				capabillities);
	}

//	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Ignore
//	@Test
	public void firstTest() throws Exception {
		driver.get("http://localhost:8080/web/guest/another");
		assertEquals("Another - Liferay", driver.getTitle());
	}
}
