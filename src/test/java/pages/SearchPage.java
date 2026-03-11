package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {

    public SearchPage(AppiumDriver driver) {
        super(driver);
    }

    private By searchField = By.id("city_search_input");
    private By suggestions = By.id("autocomplete_item");

    public void enterCity(String city) {
        type(searchField, city);
    }

    public List<WebElement> getSuggestions() {
        return driver.findElements(suggestions);
    }

    public void selectSuggestion(String city) {
        driver.findElement(By.xpath("//*[contains(@text,'" + city + "')]")).click();
    }
}