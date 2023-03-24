package testPackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class homePage extends basePage implements pages {

    @FindBy(xpath = "//input[@class=\"form-control js-site-search-focus header-search-input jump-to-field js-jump-to-field\"]")
    private WebElement searchBar;

    public homePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public homePage typeProjectNameInSearchBar(String nameProject){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBar.sendKeys(nameProject);
        return new homePage(driver);
    }

    public homePage searchAfterFiltering() {
        searchBar.sendKeys(Keys.ENTER);
        return new homePage(driver);
    }

    @Override
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }
}
