Feature: Google Homepage Search

  Scenario: User can search with “Google Search”
   Given I am on the homepage
   When I type The name of the wind into the search field
   And I click the Google Search button
   Then I go to the search results page
   And the first result is "The Name of the Wind - Patrick Rothfuss"
   When I click on the first result link
   Then I go to the “Patrick Rothfuss - The Books” page

  Scenario: User can search by using the suggestions
    Given I am on the homepage
    When I type The name of the w into the search field
    And the suggestions list is displayed
    And I click on the first suggestion in the list
    Then I go to the search results page
    And the first result is “The Name of the Wind - Patrick Rothfuss”
    When I click on the first result link
    Then I go to the “Patrick Rothfuss - The Books” page