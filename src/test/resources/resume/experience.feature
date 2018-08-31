Feature: More experience information is available when the user clicks on the "more" link

  Scenario: Click to view more
    Given I am on the homepage
    When I click on the experience more link
    Then I should see more experience information

  Scenario: Click to view less
    Given I am on the homepage
    And I have clicked on the experience more link
    When I click on the experience less link
    Then I should see less experience information
