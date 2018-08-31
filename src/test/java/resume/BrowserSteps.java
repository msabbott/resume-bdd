package resume;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class BrowserSteps {

    protected State state;

    public BrowserSteps(resume.State _state) {
        state = _state;
    }

    @Before
    public void startWebDriver() {
        state.getDriver();
    }

    @After
    public void stopWebDriver(Scenario scenario) {

        WebDriver driver = state.getDriver();


        if (scenario.isFailed()) {
            if(driver instanceof TakesScreenshot) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
        }

        driver.close();
        driver.quit();
    }

    @Given("^I am on the homepage$")
    public void navigateToHomepage() {
        state.getDriver().get(state.getWebsiteURL().toString());
    }
}
