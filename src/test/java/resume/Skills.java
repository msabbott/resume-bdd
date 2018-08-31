package resume;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;

public class Skills {

    protected State state;

    public Skills(resume.State _state) {
        state = _state;
    }

    public void clickOnSkillsMoreLink() {
        state.getDriver().findElement(By.id("skills-more")).click();
    }

    @Given("^I have clicked on the skills more link$")
    public void givenClickedOnSkillsMoreLink() {
        clickOnSkillsMoreLink();
    }

    @When("^I click on the skills more link$")
    public void whenClickOnSkillsMoreLink() {
        clickOnSkillsMoreLink();
    }

    @When("^I click on the skills less link$")
    public void whenClickOnSkillsLessLink() {
        clickOnSkillsMoreLink();
    }

    @Then("I should see more skills information")
    public void assertSkillsMoreInformationIsShown() {
        List<WebElement> items = state.getDriver().findElements(By.cssSelector("skill-shrunk"));
        assertEquals(0, items.size());
    }

    @Then("I should see less skills information")
    public void assertSkillsLessInformationIsShown() {
        List<WebElement> items = state.getDriver().findElements(By.cssSelector("skill-expanded"));
        assertEquals(0, items.size());
    }

}
