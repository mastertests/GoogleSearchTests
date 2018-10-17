package com.testmatick;

import com.testmatick.pages.GoogleSearchPage;
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
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    @Parameters("search")
    public void testGoogleSearch(String searchWords) {
        driver.get("http://www.google.com/");

        GoogleSearchPage page = new GoogleSearchPage(driver);
        List<WebElement> linkTitles = page.searchFor(searchWords);
        for (WebElement title : linkTitles) {
            String titleText = title.getText().toLowerCase();
            Assert.assertTrue(titleText.contains(searchWords.toLowerCase()),
                    "\" " + titleText + " \" do not contains " + searchWords);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
