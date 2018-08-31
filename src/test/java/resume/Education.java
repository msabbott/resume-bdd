package resume;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Education {

    protected State state;

    public Education(State _state) {
        state = _state;
    }

    public void clickOnEducationMoreLink() {
        state.getDriver().findElement(By.id("education-more")).click();
    }

    @Given("^I have clicked on the education more link$")
    public void givenClickedOnEducationMoreLink() {
        clickOnEducationMoreLink();
    }

    @When("^I click on the education more link$")
    public void whenClickOnEducationMoreLink() {
        clickOnEducationMoreLink();
    }

    @When("^I click on the education less link$")
    public void whenClickOnEducationLessLink() {
        clickOnEducationMoreLink();
    }

    @Then("^I should see more education information$")
    public void assertEducationMoreInformationIsShown() {
        /* Count and compare the number of shrunk list items */
        List<WebElement> shrunkItems = state.getDriver().findElements(By.cssSelector(".edu-shrunk"));

        assertEquals(0, shrunkItems.size());
    }

    @Then("^I should see less education information$")
    public void assertEducationLessInformationIsShown() {
        /* Count and compare the number of shrunk list items */
        List<WebElement> shrunkItems = state.getDriver().findElements(By.cssSelector(".edu-shrunk"));

        assertTrue(0 < shrunkItems.size());
    }
}
