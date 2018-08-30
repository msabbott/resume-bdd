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
    private URL websiteURL = null;

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

    public URL getWebsiteURL() {

        if(null == websiteURL) {

            String website = System.getenv("WEBSITE_URL");

            try {
                websiteURL = new URL(website);
            } catch (MalformedURLException e) {
                // Force to a local URL
                try {
                    websiteURL = new URL("http://localhost:8080");
                } catch (MalformedURLException e2) {
                    // Give up!
                    websiteURL = null;
                }

            }
        }

        return websiteURL;
    }
}
