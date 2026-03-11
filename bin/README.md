# Activity Ranking Mobile Test Assignment

## Objective
Test a mobile feature that suggests activities based on weather forecast for the next 7 days.

## Deliverables
- BDD scenarios
- Appium automated tests
- Manual test cases

## Tech Stack
Java
Appium 2.x
TestNG
Maven

## Project Structure
```
activity-ranking-mobile-tests
│
├── README.md
├── pom.xml
├── testng.xml
├── .gitignore
│
├── bdd-scenarios
│   └── activity_ranking.feature
│
├── manual-tests
│   └── activity-ranking-test-cases.md
│
└── src
    └── test
        └── java
            │
            ├── base
            │   └── BaseTest.java
            │
            ├── pages
            │   ├── BasePage.java
            │   ├── SearchPage.java
            │   └── ResultsPage.java
            │
            └── tests
                └── ActivityRankingTest.java
```
