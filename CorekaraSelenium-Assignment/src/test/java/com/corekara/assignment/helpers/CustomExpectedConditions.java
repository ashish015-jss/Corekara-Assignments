package com.corekara.assignment.helpers;

import org.openqa.selenium.support.ui.ExpectedCondition;

/*
  @Author - Ashish Singh
 */
public class CustomExpectedConditions {

    static public ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
    }
}
