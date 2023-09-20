package com.abcmouse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageDisplayed() {
        return driver.getCurrentUrl().contains("https://www.abcmouse.com/abt/register");
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void clickSubmit() {
        driver.findElement(By.id("submit")).click();
    }
}
