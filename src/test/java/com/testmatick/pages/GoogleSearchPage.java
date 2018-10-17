package com.testmatick.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchPage {
    private final By searchField = By.id("lst-ib");
    private final By searchButton = By.name("btnK");
    private final By linkTitle = By.className("LC20lb");
    private WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<WebElement> searchFor(String searchWords) {
        driver.findElement(searchField).sendKeys(searchWords);
        driver.findElement(searchButton).submit();
        return driver.findElements(linkTitle);
    }
}
