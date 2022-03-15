package com.corekara.assignment.tests;

import com.corekara.assignment.DriverBase;
import com.corekara.assignment.config.ReadDataFromPropertiesFile;
import com.corekara.assignment.page_objects.HomePage;
import com.corekara.assignment.page_objects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
@Author -Ashish Singh
*/
public class LoginExampleTest extends DriverBase {
    LoginPage loginPage;
    HomePage homePage;
    ReadDataFromPropertiesFile prop=new ReadDataFromPropertiesFile();
    WebDriver driver;

    @BeforeMethod
    public void setup() throws Exception {
        // Create a new WebDriver instance
         driver = getDriver();

        // Navigate Login page
        driver.get(prop.readPropertiesFile().getProperty("AppURL"));

        //Instantiate an instance of our  page object
         loginPage = new LoginPage();
         homePage  = new HomePage();

        // Validate page title
        assertThat(loginPage.getPageTitle()).contains("HOTEL PLANISPHERE");
    }


    @Test(description = "Validate Login with invalid Email and Password")
    public void loginWithInvalidEmailAndPassword() throws Exception {


        //Enter non-existing email into 'Email address' field
        loginPage.enterEmail(prop.readPropertiesFile().getProperty("InvalidEmail"));

        //Enter invalid 'Password' into 'Password' field
        loginPage.enterPassword(prop.readPropertiesFile().getProperty("InvalidPassword"));

        //Click 'Login' button
        loginPage.clickLoginButton();

        // Validate Email error message
        assertThat(loginPage.getEmailMessage()).contains("メールアドレスまたはパスワードが違います。");


    }

    @Test(description = "Validate Login with blank Email and Password")
    public void loginWithBlankEmailAndPassword() throws Exception {

        //Enter blank 'Email' into 'Email address' field
        loginPage.enterEmail("");

        //Enter blank 'Password' into 'Password' field
        loginPage.enterPassword("");

        //Click 'Login' button
        loginPage.clickLoginButton();

        // Validate Email error message
        assertThat(loginPage.getEmailMessage()).contains("このフィールドを入力してください。");

    }

    @Test(description = "Validate Premium member login with valid Email and Password")
    public void loginWithPremiumMemberEmailAndPassword() throws Exception {

        //Enter Premium Member email into 'Email address' field
        loginPage.enterEmail(prop.readPropertiesFile().getProperty("PremiumMemberEmail"));

        //Enter Premium Member 'Password' into 'Password' field
        loginPage.enterPassword(prop.readPropertiesFile().getProperty("PremiumMemberPassword"));

        //Click 'Login' button
        loginPage.clickLoginButton();

        //Validate the member login rank
        assertThat(homePage.getLogout()).isEqualTo("ログアウト");

        // Validate 'Logout' link
        assertThat(homePage.getLogout()).isEqualTo("ログアウト");

        //Click 'Logout' link
        homePage.clickLogoutButton();

    }

    @Test (description = "Validate General member login with valid Email and Password")
    public void loginWithGeneralMemberEmailAndPassword() throws Exception {

        //Enter General Member email into 'Email address' field
        loginPage.enterEmail(prop.readPropertiesFile().getProperty("GeneralMemberEmail"));

        //Enter Premium Member 'Password' into 'Password' field
        loginPage.enterPassword(prop.readPropertiesFile().getProperty("GeneralMemberPassword"));

        //Click 'Login' button
        loginPage.clickLoginButton();

        //Validate the member login rank
        assertThat(homePage.getLogout()).isEqualTo("ログアウト");

        // Validate 'Logout' link
        assertThat(homePage.getLogout()).isEqualTo("ログアウト");

        //Click 'Logout' link
        homePage.clickLogoutButton();
    }
}
