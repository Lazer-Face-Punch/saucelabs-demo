package fi.avaus.mandatumlife.tools;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.junit.SauceOnDemandTestWatcher;

import fi.avaus.mandatumlife.helpers.configs.TestProperties;
import fi.avaus.mandatumlife.helpers.configs.TestSessionHelper;
import fi.avaus.mandatumlife.helpers.configs.TestSessionInformation;

public class SaucelabsSeleniumTest implements SauceOnDemandSessionIdProvider {

    public TestProperties testProperties;
    
    public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(
			"Mandatum", "8e19f151-cff7-498b-a08a-7759de15420a");

    @Rule
    public SauceOnDemandTestWatcher resultReportingTestWatcher = new SauceOnDemandTestWatcher(this, authentication);

    @Rule
    public TestName testName = new TestName();

    public WebDriver driver;
    public String sessionId;	
	
    public String getSessionId() {
        return this.sessionId;
    }
    
    @Before
    public void setupTest() throws Exception {
        TestSessionInformation testSessionInformation = TestSessionHelper.getTestSessionInformation(testName, authentication);
        sessionId = testSessionInformation.getSessionId();
        driver = testSessionInformation.getDriver();
        testProperties = testSessionInformation.getTestProperties();
    }
	
    @After
    public void tearDown() throws Exception {
    	driver.quit();
    }
}
