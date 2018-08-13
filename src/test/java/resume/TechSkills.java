package resume;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TechSkills {

    protected State state;

    public TechSkills(State _state) {
        state = _state;
    }

    public void clickOnTechSkillsMoreLink() {
        state.getDriver().findElement(By.cssSelector("#skills-more")).click();
    }

    @Given("^I have clicked on the tech skills more link$")
    public void givenClickedOnTechSkillsMoreLink() {
        clickOnTechSkillsMoreLink();
    }

    @When("^I click on the tech skills more link$")
    public void whenClickOnTechSkillsMoreLink() {
        clickOnTechSkillsMoreLink();
    }

    @When("^I click on the tech skills less link$")
    public void whenClickOnTechSkillsLessLink() {
        clickOnTechSkillsMoreLink();
    }

    @Then("I should see more tech skills")
    public void assertTechSkillsMoreInformationIsShown() {

        /* Count and compare the number of expandable and shrunk list items */
        List<WebElement> expandableItems = state.getDriver().findElements(By.cssSelector(".skilllist-tech li.expandable"));
        List<WebElement> shrunkItems = state.getDriver().findElements(By.cssSelector(".skilllist-tech li.shrunk"));

        assertTrue(shrunkItems.size() < expandableItems.size());
    }

    @Then("I should see less tech skills")
    public void assertTechSkillsLessInformationIsShown() {

        /* Count and compare the number of expandable and shrunk list items */
        List<WebElement> expandableItems = state.getDriver().findElements(By.cssSelector(".skilllist-tech li.expandable"));
        List<WebElement> shrunkItems = state.getDriver().findElements(By.cssSelector(".skilllist-tech li.shrunk"));

        assertTrue(shrunkItems.size() > expandableItems.size());
    }

}
