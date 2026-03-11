package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage extends BasePage {

    public ResultsPage(AppiumDriver driver) {
        super(driver);
    }

    private By activityCards = By.id("activity_card");
    private By activityName = By.id("activity_name");
    private By activityRank = By.id("activity_rank");
    private By activityReason = By.id("activity_reason");

    public int getActivityCount() {
        List<WebElement> cards = driver.findElements(activityCards);
        return cards.size();
    }

    public String getActivityName() {
        return getText(activityName);
    }

    public String getActivityRank() {
        return getText(activityRank);
    }

    public String getActivityReason() {
        return getText(activityReason);
    }
}