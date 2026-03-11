# Note:
# These BDD scenarios describe expected behavior of the mobile application.
# Automation tests are implemented separately using Appium with Java.


Feature: Activity Ranking based on weather forecast

  As a mobile user
  I want to search for a city using autocomplete
  So that I can view ranked activities based on weather forecast

Scenario: Autocomplete suggestions appear while typing a city
  Given the user opens the mobile application
  And the user is on the city search screen
  When the user types "Mum" in the search field
  Then autocomplete suggestions should appear
  And the suggestions should include "Mumbai"

Scenario: Autocomplete suggestions update dynamically
  Given the user is on the city search screen
  When the user types "Pa"
  Then suggestions related to "Pa" should appear
  When the user continues typing "Par"
  Then the suggestions should update dynamically

Scenario: Selecting a city suggestion loads activity rankings
  Given autocomplete suggestions are displayed
  When the user selects "London"
  Then the application should request weather data for London
  And the activity ranking results screen should be displayed
  
Scenario: Activity ranking for the next 7 days is displayed
  Given the user selects a valid city
  When the ranking results are loaded
  Then the app should display activity rankings for the next 7 days
  
Scenario: Each ranking result contains required fields
  Given the activity ranking results are displayed
  Then each result should include
    | Date |
    | Activity Name |
    | Rank |
    | Reasoning |

Scenario: Only supported activities are displayed
  Given the activity ranking results are displayed
  Then activities should only include
    | Skiing |
    | Surfing |
    | Outdoor Sightseeing |
    | Indoor Sightseeing |
    
Scenario: No suggestions for invalid city input
  Given the user is on the search screen
  When the user types "zzzzzzz"
  Then no autocomplete suggestions should be displayed
  And the user should see "No results found"
  
Scenario: Display error when weather API fails
  Given the user selects a valid city
  When the weather service fails to return data
  Then the application should display an error message
  And the user should have an option to retry
  
Scenario: Loading indicator appears while fetching results
  Given the user selects a city
  When the application is fetching weather data
  Then a loading indicator should be displayed
  And results should appear once the data is received
  
Scenario: No suggestions when search field is empty
  Given the user is on the search screen
  When the search field is empty
  Then no autocomplete suggestions should be displayed 
  
