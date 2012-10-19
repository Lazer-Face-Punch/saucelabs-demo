package fi.avaus.mandatumlife.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fi.avaus.mandatumlife.tools.SaucelabsSeleniumTest;

public class FirstTest extends SaucelabsSeleniumTest
{

	@Test
	public void openPage() {
		driver.get(this.testProperties.getDomain() + "/");
		assertEquals("Welcome - Liferay", driver.getTitle());
	}

	@Test
	public void pageOpenFails() {
		driver.get(this.testProperties.getDomain() + "/");
		assertEquals("Welcome - Liferay2", driver.getTitle());
	}

}
