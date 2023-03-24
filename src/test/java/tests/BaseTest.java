package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    private static final String GIT_URL = "https://github.com/login";
    protected WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.firefox.driver", "src\\main\\resources\\firefoxdriver.exe");
    }

    @BeforeMethod
    public void testsSetUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(GIT_URL);
    }

}
