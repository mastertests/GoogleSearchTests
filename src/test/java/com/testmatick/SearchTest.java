package com.testmatick;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {
    private WebDriver driver;

    @BeforeClass
    public void turnUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    @Parameters("search")
    public void testGoogleSearch(String searchWords) {
        driver.get("http://www.google.com/");
        driver.findElement(By.id("lst-ib")).sendKeys(searchWords);
        driver.findElement(By.name("btnK")).submit();
        List<WebElement> linkTitles = driver.findElements(By.className("LC20lb"));
        for (WebElement title : linkTitles) {
            String titleText = title.getText();
            Assert.assertTrue(titleText.contains(searchWords));
        }
    }

    @AfterClass
    public void shutDown() {
        driver.quit();
    }
}
