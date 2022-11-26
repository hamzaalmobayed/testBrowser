import org.example.GoogleHomePage;
import org.example.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestBrowser extends StackTest{

    private List<WebElement> Google;
    private List<WebElement> Bing;

    public void setGoogle(List<WebElement> google) {
        Google = google;
    }

    public void setBing(List<WebElement> bing) {
        Bing = bing;
    }

    @Test(priority = 1)
    public void checkGoogle() {
        driver.get("https://www.google.com/");
        home = new GoogleHomePage(driver);
        home.enterKey("gLFyf", "switzerland");
        Result myResultGoogle = home.clickSearch("input[aria-label=\"بحث Google\u200F\"]");
        List<WebElement> listOfTitleOfGoogle = myResultGoogle.resultSearch("div.v7W49e ", "div[data-header-feature] div a h3 span").subList(0, 4);
        List<WebElement> listOfUrlOfGoogle = myResultGoogle.resultSearch("div.v7W49e ", "div[data-header-feature] div a div cite>span:nth-child(1)").subList(0, 4);
        List<WebElement> listOfDescOfGoogle = myResultGoogle.resultSearch("div.v7W49e ", "div[data-content-feature=\"1\"] div span[dir]").subList(0, 4);

        for(int i=0;i<listOfUrlOfGoogle.size();i++){
////            System.out.println("Title\n");
////            System.out.println(listOfTitleOfGoogle.get(i).getText());
        System.out.println("url\n");
            System.out.println(listOfUrlOfGoogle.get(i).getText() );
////            System.out.println("description\n");
////            System.out.println(listOfDescOfGoogle.get(i).getText());
    }

    }

    @Test(priority = 2)
    public void checkBing(){
        driver.get("https://www.bing.com/");
        home=new GoogleHomePage(driver);
        home.enterKey("sb_form_q","switzerland");
        Result myResult= home.clickSearch("label[role=\"button\"]");
        List<WebElement> listOfTitleOfBing= myResult.resultSearch("ol#b_results","div h2 a span").subList(0,4);
        List<WebElement> listOfUrlOfBing= myResult.resultSearch("ol#b_results","div[tabindex] cite").subList(0,4);
        List<WebElement> listOfDescOfBing= myResult.resultSearch("ol#b_results","div div p").subList(0,4);
        setBing(listOfUrlOfBing);
//
        for(int i=0;i<listOfUrlOfBing.size();i++){
////            System.out.println("Title\n");
////            System.out.println(listOfTitleOfBing.get(i).getText());
            System.out.println("url\n");
            System.out.println(listOfUrlOfBing.get(i).getText());
////            System.out.println("description\n");
////            System.out.println(listOfDescOfBing.get(i).getText());
        }

    }
    @Test(priority = 3)
    public void chechResult(){
//        for(int i=0;i<Bing.size();i++){
//            System.out.println("url of google"+Google.get(i).getText());
//            System.out.println("url of bing"+Bing.get(i).getText());
////            if(listOfUrlOfBing.get(i).getText()==listOfUrlOfGoogle.get(i).getText()){
////                System.out.println(i+"is true");
////            }else{
////                System.out.println(i+"is not true");
////            }
////            Assert.assertEquals(listOfUrlOfBing.get(i).getText(),listOfUrlOfGoogle.get(i).getText());
//        }
    }


}
