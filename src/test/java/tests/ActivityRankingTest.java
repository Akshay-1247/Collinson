package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.ResultsPage;

public class ActivityRankingTest extends BaseTest {

    @Test
    public void verifyAutocompleteSuggestionsAppear() {

        SearchPage searchPage = new SearchPage(driver);

        // When user types city
        searchPage.enterCity("Lon");

        // Then suggestions should appear
        Assert.assertTrue(
                searchPage.getSuggestions().size() > 0,
                "Autocomplete suggestions did not appear"
        );
    }

    @Test
    public void verifySuggestionsUpdateDynamically() {

        SearchPage searchPage = new SearchPage(driver);

        searchPage.enterCity("Pa");

        int initialSuggestions = searchPage.getSuggestions().size();

        searchPage.enterCity("Par");

        int updatedSuggestions = searchPage.getSuggestions().size();

        Assert.assertNotEquals(
                initialSuggestions,
                updatedSuggestions,
                "Suggestions did not update dynamically"
        );
    }

    @Test
    public void verifySelectingCityLoadsActivityRanking() {

        SearchPage searchPage = new SearchPage(driver);
        ResultsPage resultsPage = new ResultsPage(driver);

        searchPage.enterCity("Lon");
        searchPage.selectSuggestion("London");

        int activities = resultsPage.getActivityCount();

        Assert.assertTrue(
                activities > 0,
                "Activity ranking results were not displayed"
        );
    }

    @Test
    public void verifySevenDayActivityRankingDisplayed() {

        SearchPage searchPage = new SearchPage(driver);
        ResultsPage resultsPage = new ResultsPage(driver);

        searchPage.enterCity("Lon");
        searchPage.selectSuggestion("London");

        int activityCount = resultsPage.getActivityCount();

        Assert.assertTrue(
                activityCount >= 7,
                "7 day activity ranking not displayed"
        );
    }

    @Test
    public void verifyActivityFieldsPresent() {

        SearchPage searchPage = new SearchPage(driver);
        ResultsPage resultsPage = new ResultsPage(driver);

        searchPage.enterCity("Lon");
        searchPage.selectSuggestion("London");

        String activityName = resultsPage.getActivityName();
        String activityRank = resultsPage.getActivityRank();
        String activityReason = resultsPage.getActivityReason();

        Assert.assertNotNull(activityName);
        Assert.assertNotNull(activityRank);
        Assert.assertNotNull(activityReason);
    }

    @Test
    public void verifySupportedActivitiesOnly() {

        SearchPage searchPage = new SearchPage(driver);
        ResultsPage resultsPage = new ResultsPage(driver);

        searchPage.enterCity("Lon");
        searchPage.selectSuggestion("London");

        String activityName = resultsPage.getActivityName();

        boolean supported =
                activityName.contains("Skiing") ||
                activityName.contains("Surfing") ||
                activityName.contains("Outdoor Sightseeing") ||
                activityName.contains("Indoor Sightseeing");

        Assert.assertTrue(
                supported,
                "Unsupported activity returned"
        );
    }

    @Test
    public void verifyNoSuggestionsForInvalidCity() {

        SearchPage searchPage = new SearchPage(driver);

        searchPage.enterCity("zzzzzz");

        Assert.assertEquals(
                searchPage.getSuggestions().size(),
                0,
                "Suggestions should not appear for invalid city"
        );
    }
}