package com.abcmouse.tests;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abcmouse.pages.MainPage;
import com.abcmouse.pages.RegistrationPage;
import com.abcmouse.pages.SubscriptionPage;
import com.abcmouse.utilities.BaseClass;

public class SignUpTest extends BaseClass {
    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private SubscriptionPage subscriptionPage;

    @BeforeClass
    public void setUp() {
        initialize();
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        subscriptionPage = new SubscriptionPage(driver);
    }

    @AfterClass
    public void tearDown() {
        close();
    }

    @Test
    public void testSignUpScenario() {
        // Click "Sign Up"
        mainPage.clickSignUp();

        // Verify Registration Page
        assert registrationPage.isPageDisplayed();

        // Enter Email
        JSONObject config = loadConfig();
        String email = config.get("email").toString();
        registrationPage.enterEmail(email);

        // Click "Submit"
        registrationPage.clickSubmit();

        // Verify Subscription Page and "Become a Member!" text
        assert subscriptionPage.isPageDisplayed();
        assert subscriptionPage.getBecomeMemberText().equals("Become a Member!");
    }
}