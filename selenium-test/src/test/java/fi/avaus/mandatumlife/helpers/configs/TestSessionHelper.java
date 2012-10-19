package fi.avaus.mandatumlife.helpers.configs;

import com.saucelabs.common.SauceOnDemandAuthentication;
import fi.avaus.mandatumlife.helpers.drivers.DriverHelper;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestSessionHelper {

    public static TestSessionInformation getTestSessionInformation(TestName testName, SauceOnDemandAuthentication authentication) throws IOException {

        WebDriver driver;
        String sessionId = null;

        Properties testProperties = getTestProperties();
        if (TestPropertiesHelper.testOnSauce(testProperties)) {
            driver = DriverHelper.getRemoteWebDriver(testName, authentication, System.getProperty("browserAndOs"));
            sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
        } else {
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        TestSessionInformation testSessionInformation = new TestSessionInformation();
        testSessionInformation.setDriver(driver);
        testSessionInformation.setSessionId(sessionId);
        testSessionInformation.setTestProperties(new TestProperties(testProperties));

        return testSessionInformation;
    }

    private static Properties getTestProperties() throws IOException {
        return TestPropertiesHelper.getProperties();
    }
}
