Feature: More education information is available when the user clicks on the "more" link

  Scenario: Click to view more
    Given I am on the homepage
    When I click on the education more link
    Then I should see more education information

  Scenario: Click to view less
    Given I am on the homepage
    And I have clicked on the education more link
    When I click on the education less link
    Then I should see less education information
