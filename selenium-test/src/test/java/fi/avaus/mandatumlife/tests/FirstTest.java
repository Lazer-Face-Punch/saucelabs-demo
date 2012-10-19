package fi.avaus.mandatumlife.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fi.avaus.mandatumlife.tools.SaucelabsSeleniumTest;

public class FirstTest extends SaucelabsSeleniumTest
{

	@Test
	public void openPage() {
		driver.get(this.testProperties.getDomain() + "/web/guest/another");
		assertEquals("Another - Liferay", driver.getTitle());
	}

}
