Feature: More skill information is shown when the user clicks on the "more" link

  Scenario: Click to view more
    Given I am on the homepage
    When I click on the skills more link
    Then I should see more skills information

  Scenario: : Click to view less
    Given I am on the homepage
    And I have clicked on the skills more link
    When I click on the skills less link
    Then I should see less skills information