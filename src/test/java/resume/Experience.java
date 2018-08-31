package resume;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Experience {

    protected State state;

    public Experience(State _state) {
        state = _state;
    }

    public void clickOnExperienceMoreLink() {
        state.getDriver().findElement(By.id("experience-more")).click();
    }

    @Given("^I have clicked on the experience more link$")
    public void givenClickedOnExperienceMoreLink() {
        clickOnExperienceMoreLink();
    }

    @When("^I click on the experience more link$")
    public void whenClickOnExperienceMoreLink() {
        clickOnExperienceMoreLink();
    }

    @When("^I click on the experience less link$")
    public void whenClickOnExperienceLessLink() {
        clickOnExperienceMoreLink();
    }

    @Then("^I should see more experience information$")
    public void assertExperienceMoreInformationIsShown() {
        /* Count and compare the number of shrunk list items */
        List<WebElement> shrunkItems = state.getDriver().findElements(By.cssSelector(".exp-shrunk"));

        assertEquals(0, shrunkItems.size());
    }

    @Then("^I should see less experience information$")
    public void assertExperienceLessInformationIsShown() {
        /* Count and compare the number of shrunk list items */
        List<WebElement> shrunkItems = state.getDriver().findElements(By.cssSelector(".exp-shrunk"));

        assertTrue(0 < shrunkItems.size());
    }
}
