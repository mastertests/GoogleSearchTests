package com.testmatick.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPage {
    private final By searchField = By.id("lst-ib");
    private final By searchButton = By.name("btnK");
    private final By linkTitle = By.className("LC20lb");
    private final WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> searchFor(String searchWords) {
        driver.findElement(searchField).sendKeys(searchWords);
        driver.findElement(searchButton).submit();
        return driver.findElements(linkTitle);
    }
}
