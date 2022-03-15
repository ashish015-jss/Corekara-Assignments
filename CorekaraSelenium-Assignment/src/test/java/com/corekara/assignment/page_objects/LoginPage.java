package com.corekara.assignment.page_objects;

import com.corekara.assignment.DriverBase;
import com.corekara.assignment.helpers.CustomExpectedConditions;
import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static com.lazerycode.selenium.util.AssignDriver.initQueryObjects;

/*
@Author -Ashish Singh
 */
public class LoginPage {

    private final Query emailTxtField = new Query().defaultLocator(By.name("email"));
    private final Query passwordTxtField = new Query().defaultLocator(By.name("password"));
    private final Query loginButton = new Query().defaultLocator(By.id("login-button"));
    private final Query emailMessage = new Query().defaultLocator(By.id("email-message"));


    private final WebDriverWait wait;
    private final RemoteWebDriver driver;

    public LoginPage() throws Exception {
        driver = DriverBase.getDriver();
        initQueryObjects(this, DriverBase.getDriver());
        wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(15), Duration.ofMillis(100));
    }

    public LoginPage enterEmail(String email) {
        wait.until(ExpectedConditions.presenceOfElementLocated(emailTxtField.by()));
        emailTxtField.findWebElement().clear();
        emailTxtField.findWebElement().sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordTxtField.by()));
        passwordTxtField.findWebElement().clear();
        passwordTxtField.findWebElement().sendKeys(password);
        return this;
    }


    public void clickLoginButton() {
        loginButton.findWebElement().click();
    }

    public void waitForPageTitleToStartWith(String someText) {
        wait.until(CustomExpectedConditions.pageTitleStartsWith(someText));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getEmailMessage() {
        return  emailMessage.findWebElement().getText();
    }


}
