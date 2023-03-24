package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testPackage.LoginPage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GitTest extends BaseTest {

    public static final String PATH_TO_CSV = "src/test/resources/testData.csv";


    @Test
    public void testVersionTestNgFromPom() {
        String[] credentials = getCredentialsFromCsv(PATH_TO_CSV);
        String loginText = credentials[0];
        String passwordText = credentials[1];
        String projectName = "Alexey8991/HT_2";

        String expectedResult = "7.4.0";

        String actualResult = new LoginPage(driver)
                .typeLogin(loginText)
                .typePassword(passwordText)
                .clickSignInButton()
                .typeProjectNameInSearchBar(projectName)
                .searchAfterFiltering()
                .clickOnSearchResultProject()
                .clickOnPomXml()
                .getValueForTestNg();
        Assert.assertEquals(actualResult, expectedResult, "Actual result and expected result are different");
    }

    public String[] getCredentialsFromCsv(String pathToCsv) {
        String line;
        String splitBy = ", ";
        String[] cred = new String[2];

        try {
            BufferedReader br = new BufferedReader(new FileReader(pathToCsv));
            while ((line = br.readLine()) != null) {
                cred = line.split(splitBy);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return cred;
    }
}
