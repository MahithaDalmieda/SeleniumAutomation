package utils;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifier) {
        switch (identifierType) {
            case "XPATH" -> {
                return BaseTest.driver.findElement(By.xpath(identifier));
            }
            case "CSS" -> {
                return BaseTest.driver.findElement(By.cssSelector(identifier));
            }
            case "ID" -> {
                return BaseTest.driver.findElement(By.id(identifier));
            }
            case "NAME" -> {
                return BaseTest.driver.findElement(By.name(identifier));
            }
            case "TAGNAME" -> {
                return BaseTest.driver.findElement(By.tagName(identifier));
            }
            default -> {
                return null;
            }
        }
    }

    public List<WebElement> getWebElements(String identifierType, String identifier) {
        switch (identifierType) {
            case "XPATH" -> {
                return BaseTest.driver.findElements(By.xpath(identifier));
            }
            case "CSS" -> {
                return BaseTest.driver.findElements(By.cssSelector(identifier));
            }
            case "ID" -> {
                return BaseTest.driver.findElements(By.id(identifier));
            }
            case "NAME" -> {
                return BaseTest.driver.findElements(By.name(identifier));
            }
            case "TAGNAME" -> {
                return BaseTest.driver.findElements(By.tagName(identifier));
            }
            default -> {
                return null;
            }
        }
    }

    public WebElement getWebElement(By identifier) {
       return BaseTest.driver.findElement(identifier);
    }

    public List<WebElement> getWebElements(By identifier) {
        return BaseTest.driver.findElements(identifier);
    }
}
