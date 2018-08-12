package resume;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
        List<WebElement> items = state.getDriver().findElements(By.cssSelector("skilltechlist"));
        assertEquals(0, items.size());
    }

    @Then("I should see less tech skills")
    public void assertTechSkillsLessInformationIsShown() {
        List<WebElement> items = state.getDriver().findElements(By.cssSelector("skilltechlist"));
        assertEquals(0, items.size());
    }

}
