@Suite
Feature: Filter search results
  As user
  I want to filter the search results
  So that did not have long to find the right product

  Background:
    Given I am on start page
    When I select category

  Scenario Outline: Check filter by price
    And I set minimum and maximum prices
    Then I see results matching search parameters "<min>" and "<max>"
    Examples:
      |   min  |   max  |
      | 100000 | 150000 |

  Scenario: Check filter by manufacturer name
    And I select manufacturer
    Then the number of products equals to the number next to the manufacturer
    And product names begin with the selected products


#  Scenario: Check search by product name
#    And I sort product by price
#    And I get the name of the cheapest product
#    And enter product name into the search field and submit
#    Then Search Results Page has 1 product
#    And product name is equal to specified name