package resume;

import cucumber.api.java.it.Ma;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;


public class State {

    private WebDriver driver = null;
    private URL websiteURL = null;

    public WebDriver getDriver() {

        if(null == driver) {

            String seleniumHost    = System.getenv("SELENIUM_HOST");
            String seleniumPortStr = System.getenv("SELENIUM_PORT");
            String seleniumBrowser = System.getenv("SELENIUM_BROWSER");

            Integer seleniumPort;
            URL seleniumURL;

            if (null == seleniumHost) {
                System.out.println("Selenium Host not provided");
                seleniumHost = "localhost";
            }

            if (null == seleniumPortStr) {
                System.out.println("Selenium port not specified");
                seleniumPort = 4444;
            } else {
                seleniumPort = Integer.parseInt(seleniumPortStr);
            }

            Capabilities capabilities = null;

            if(null == seleniumBrowser) {
                System.out.println("Browser not specified");
                seleniumBrowser = "chrome";
            }

            if(seleniumBrowser.equalsIgnoreCase("chrome")) {
                capabilities = new ChromeOptions();
            } else if(seleniumBrowser.equalsIgnoreCase("safari")) {
                capabilities = new SafariOptions();
            } else if(seleniumBrowser.equalsIgnoreCase("firefox")) {
                capabilities = new FirefoxOptions();
            } else if(seleniumBrowser.equalsIgnoreCase("internetexplorer")) {
                capabilities = new InternetExplorerOptions();
            } else if(seleniumBrowser.equalsIgnoreCase("edge")) {
                capabilities = new EdgeOptions();
            } else if(seleniumBrowser.equalsIgnoreCase("opera")) {
                capabilities = new OperaOptions();
            } else {
                // Assume Chrome
                capabilities = new ChromeOptions();
            }

            try {
                seleniumURL = new URL("http", seleniumHost, seleniumPort.intValue(), "/wd/hub");
            } catch (MalformedURLException e) {
                // Assign to a local selenium host
                try {
                    seleniumURL = new URL("http://localhost:4444/wd/hub");
                } catch (MalformedURLException e2) {
                    // Give up!
                    seleniumURL = null;
                }
            }

            driver = new RemoteWebDriver(seleniumURL, capabilities);
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
