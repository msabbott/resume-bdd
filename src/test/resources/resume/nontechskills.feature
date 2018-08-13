Feature: More non-technical skills information is available when the user clicks on the "more" link

  Scenario: Click to view more
    Given I am on the homepage
    When I click on the non-tech skills more link
    Then I should see more non-tech skills

  Scenario: Click to view less
    Given I am on the homepage
    And I have clicked on the non-tech skills more link
    When I click on the non-tech skills less link
    Then I should see less non-tech skills