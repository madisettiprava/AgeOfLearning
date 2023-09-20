package com.abcmouse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubscriptionPage {
    private WebDriver driver;

    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageDisplayed() {
        return driver.getCurrentUrl().contains("https://www.abcmouse.com/abt/subscription");
    }

    public String getBecomeMemberText() {
        return driver.findElement(By.cssSelector(".become-member")).getText();
    }
}
