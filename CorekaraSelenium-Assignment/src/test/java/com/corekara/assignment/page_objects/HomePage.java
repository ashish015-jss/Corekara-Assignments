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
public class HomePage {

    private final Query logoutLink = new Query().defaultLocator(By.xpath("//*[text()='ログアウト']"));
    private final Query member = new Query().defaultLocator(By.cssSelector("p#rank>font>font"));

    private final WebDriverWait wait;
    private final RemoteWebDriver driver;

    public HomePage() throws Exception {
        driver = DriverBase.getDriver();
        initQueryObjects(this, DriverBase.getDriver());
        wait = new WebDriverWait(DriverBase.getDriver(), Duration.ofSeconds(15), Duration.ofMillis(100));
    }

    public String getLogout() {
        return  logoutLink.findWebElement().getText();
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(logoutLink.by()));
        logoutLink.findWebElement().click();
    }

    public String getMemberRank() {
        return  member.findWebElement().getText();
    }
}
