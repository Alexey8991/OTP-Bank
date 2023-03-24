package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ProjectPage extends BasePage implements Pages {

    @FindBy(xpath = "//a[@href=\"/Alexey8991/HT_2/blob/main/pom.xml\"]")
    WebElement pomXml;

    @FindBy(xpath = "//td[@id=\"LC28\"]")
    WebElement testNgVersion;

    @FindBy(xpath = "//td[@id=\"LC33\"]")
    WebElement seleniumVersion;

    @FindBy(xpath = "//td[@id=\"LC38\"]")
    WebElement slf4jVersion;

    @FindBy(xpath = "//td[@id=\"LC43\"]")
    WebElement openCsvVersion;

    @FindBy(xpath = "//td[@id=\"LC48\"]")
    WebElement junitVersion;

    public ProjectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ProjectPage clickOnPomXml() {
        pomXml.click();
        return new ProjectPage(driver);
    }

    public String getValueForTestNg() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String versionOfSelenium = seleniumVersion.getText().substring(21,26);
        String versionOfTestNg = testNgVersion.getText().substring(21,26);
        String versionOfSlf5j = slf4jVersion.getText().substring(21,26);
        String versionOfOpenCsv = openCsvVersion.getText().substring(21,24);
        String versionOfJunit = junitVersion.getText().substring(21, 26);

        Logger LOGGER_Versions = Logger.getLogger(ProjectPage.class.getName());
        LOGGER_Versions.setLevel(Level.INFO);
        LOGGER_Versions.info("\nSelenium version is " + versionOfSelenium + "\nTestNg version is " + versionOfTestNg + "\nslf4j version is " + versionOfSlf5j + "\nOpenCsv version is " + versionOfOpenCsv + "\nJunit version is " + versionOfJunit);

        return testNgVersion.getText().substring(21, 26);
    }

    @Override
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }
}
