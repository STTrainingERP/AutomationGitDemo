Feature: As a user
          I should be able to search and get appropriate results

  Background:
    Given I'm on home page "https://www.next.co.uk"

  @searchValid @regression @smoke
  Scenario Outline: Verify search using valid product or brand name
    When I Click on search field and enter the search term "<searchTerm>"
    And I click on search icon
    Then I should see products related to "<expectedText>" in search results page

    Examples:
    |searchTerm|expectedText|
    | Jeans    | Jeans      |



