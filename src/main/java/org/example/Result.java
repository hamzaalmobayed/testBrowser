package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Result {
    private WebDriver driver;
    public Result(WebDriver driver) {
        this.driver = driver;
    }
    public List<WebElement> resultSearch(String className,String tag){
        WebElement mainElement= driver.findElement(By.cssSelector(className));
        return mainElement.findElements(By.cssSelector(tag));
    }
}
