package com.abcmouse.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignUp() {
        //driver.findElement(By.linkText("Sign Up")).click();
    	try {
            // Wait for "Sign Up" link to be clickable
//            WebDriverWait wait = new WebDriverWait(driver, 10);
//            WebElement signUpElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Up")));
    		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
             WebElement signUpElement = wait.withTimeout(Duration.ofSeconds(10))
                     .until(ExpectedConditions.elementToBeClickable(By.xpath("//signup-button[@class='header-button abcmouse-sans enteractive tab-outline-blue' and @aria-label='Sign Up for ABCmouse.com']")));
          // Click "Sign Up" link
             signUpElement.click();

         } catch (Exception e) {
             System.err.println("Failed to locate or click the Sign Up link.");
             e.printStackTrace();
         }
    	}
    }
