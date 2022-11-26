package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {
    private WebDriver driver;
    private By searchField= By.className("gLFyf");
    private By searchButton= By.className("gNO89b");
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterKey(String className ,String key){
        driver.findElement(By.className(className)).sendKeys(key);
    }
    public Result clickSearch(String className){
        driver.findElement(By.cssSelector(className)).click();
       return new Result(driver);
    }


}
