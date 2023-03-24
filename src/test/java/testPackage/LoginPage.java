package testPackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage implements Pages {

    @FindBy(xpath = "//input[@id='login_field']")
    private WebElement login;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public LoginPage typeLogin(String loginText) {
        login.sendKeys(loginText);
        return new LoginPage(driver);
    }

    public LoginPage typePassword(String passwordText) {
        password.sendKeys(passwordText);
        return new LoginPage(driver);
    }

    public HomePage clickSignInButton() {
        signInButton.sendKeys(Keys.ENTER);
        return new HomePage(driver);
    }
}
