package resume;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class NonTechSkills {

    protected State state;

    public NonTechSkills(State _state) {
        state = _state;
    }

    public void clickOnNonTechSkillsMoreLink() {
        state.getDriver().findElement(By.id("nontechskills-more")).click();
    }

    @Given("^I have clicked on the non-tech skills more link$")
    public void givenClickedOnNonTechSkillsMoreLink() {
        clickOnNonTechSkillsMoreLink();
    }

    @When("^I click on the non-tech skills more link$")
    public void whenClickOnNonTechSkillsMoreLink() {
        clickOnNonTechSkillsMoreLink();
    }

    @When("^I click on the non-tech skills less link$")
    public void whenClickOnNonTechSkillsLessLink() {
        clickOnNonTechSkillsMoreLink();
    }

    @Then("I should see more non-tech skills")
    public void assertNonTechSkillsMoreInformationIsShown() {

        /* Count and compare the number of expandable and shrunk list items */
        List<WebElement> expandableItems = state.getDriver().findElements(By.cssSelector(".skilllist-nontech li.expandable"));
        List<WebElement> shrunkItems = state.getDriver().findElements(By.cssSelector(".skilllist-nontech li.shrunk"));

        assertTrue(shrunkItems.size() < expandableItems.size());
    }

    @Then("I should see less non-tech skills")
    public void assertNonTechSkillsLessInformationIsShown() {

        /* Count and compare the number of expandable and shrunk list items */
        List<WebElement> expandableItems = state.getDriver().findElements(By.cssSelector(".skilllist-nontech li.expandable"));
        List<WebElement> shrunkItems = state.getDriver().findElements(By.cssSelector(".skilllist-nontech li.shrunk"));

        assertTrue(shrunkItems.size() > expandableItems.size());
    }

}
