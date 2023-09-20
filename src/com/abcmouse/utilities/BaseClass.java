package com.abcmouse.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;


public class BaseClass {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public void initialize() {
        // Load config from config.json
        JSONObject config = loadConfig();

        // Initialize WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell3\\OneDrive\\Desktop\\Pravalika\\javaPrograms\\AbcMouseSample\\AbcMouseProject\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        // Navigate to the URL
        driver.get(config.get("url").toString());
    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected JSONObject loadConfig() {
        JSONParser parser = new JSONParser();
        JSONObject config = null;

        try {
            FileReader reader = new FileReader("src/config.json");
            config = (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return config;
    }
}
