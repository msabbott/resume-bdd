package resume;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class State {

    private WebDriver driver = null;

    public WebDriver getDriver() {

        if(null == driver) {

            URL seleniumHost = null;
            try {
                seleniumHost = new URL("http://localhost:4444/wd/hub");
            } catch (MalformedURLException e) {
                // Do nothing
            }

            driver = new RemoteWebDriver(seleniumHost, DesiredCapabilities.safari());
        }

        return driver;
    }
}
