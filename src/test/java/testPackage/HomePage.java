package testPackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage extends BasePage implements Pages {

    @FindBy(xpath = "//input[@class=\"form-control js-site-search-focus header-search-input jump-to-field js-jump-to-field\"]")
    private WebElement searchBar;

    @FindBy(xpath = "//div[@class=\"f4 text-normal\"]")
    private WebElement searchResult;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public HomePage typeProjectNameInSearchBar(String nameProject){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchBar.sendKeys(nameProject);
        return new HomePage(driver);
    }

    public HomePage searchAfterFiltering() {
        searchBar.sendKeys(Keys.ENTER);
        return new HomePage(driver);
    }

    public ProjectPage clickOnSearchResultProject() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        searchResult.click();
        return new ProjectPage(driver);
    }

    @Override
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }
}
