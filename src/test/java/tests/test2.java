package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testPackage.loginPage;

public class test2 extends baseTest {

    @Test
    public void dasdasd() {
        String loginText = "alesha.kozlov@gmail.com";
        String passwordText = "Pro100alesha123";
        String projectName = "Alexey8991/HT_2";

        String expectedResult = "test";
        String actualResult = new loginPage(driver)
                .typeLogin(loginText)
                .typePassword(passwordText)
                .clickSignInButton()
                .typeProjectNameInSearchBar(projectName)
                .searchAfterFiltering()
                .getCurrentUrl();
        Assert.assertEquals(actualResult,expectedResult, "AR != ER");
    }
}
