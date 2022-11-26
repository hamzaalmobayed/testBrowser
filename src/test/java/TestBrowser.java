import org.example.Constants;
import org.example.HomePage;
import org.example.Result;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestBrowser extends BaseTest {

    private ArrayList<String> google =new ArrayList<>();
    private ArrayList<String> bing =new ArrayList<>() ;


    @Test(priority = 1)
    public void checkGoogle() {
        driver.get(Constants.GOOGLE_BROWSER);
        home = new HomePage(driver);
        home.enterKey(Constants.GOOGLE_SEARCH, "palestine");
        Result myResultGoogle = home.clickSearch(Constants.GOOGLE_BUTTON);
        List<WebElement> listOfTitleOfGoogle = myResultGoogle.resultSearch(Constants.GOOGLE_RESULT, Constants.GOOGLE_TITLES).subList(0, 4);
        List<WebElement> listOfUrlOfGoogle = myResultGoogle.resultSearch(Constants.GOOGLE_RESULT, Constants.GOOGLE_URL).subList(0, 4);
        List<WebElement> listOfDescOfGoogle = myResultGoogle.resultSearch(Constants.GOOGLE_RESULT, Constants.GOOGLE_DESC).subList(0, 4);
        ///ما بيرضى يقارن اتنين ليست webelement فانا حولت الليست تبع url لمصفوفة string  عشان اقارن
        listOfUrlOfGoogle.forEach(e-> google.add(e.getText()));
        google.forEach(e->System.out.println("url google "+e));
        listOfTitleOfGoogle.forEach(e-> System.out.println("title google "+e.getText()));
        listOfDescOfGoogle.forEach(e-> System.out.println("description google "+e.getText()));


    }

    @Test(priority = 2)
    public void checkBing(){
        driver.get(Constants.BING_BROWSER);
        home=new HomePage(driver);
        home.enterKey(Constants.BING_SEARCH,"palestine");
        Result myResult= home.clickSearch(Constants.BING_BUTTON);
        List<WebElement> listOfTitleOfBing= myResult.resultSearch(Constants.BING_RESULT,Constants.BING_TITLES).subList(0,4);
        List<WebElement> listOfUrlOfBing= myResult.resultSearch(Constants.BING_RESULT,Constants.BING_URL).subList(0,4);
        List<WebElement> listOfDescOfBing= myResult.resultSearch(Constants.BING_RESULT,Constants.BING_DESC).subList(0,4);
        ///ما بيرضى يقارن اتنين ليست webelement فانا حولت الليست تبع url لمصفوفة string  عشان اقارن
        listOfUrlOfBing.forEach(e-> bing.add(e.getText().split("/")[0]+"//"+e.getText().split("/")[2]));
        bing.forEach(e->System.out.println("url Bing "+e.split("/")[0]+"//"+e.split("/")[2]));
        listOfTitleOfBing.forEach(e-> System.out.println("title Bing "+e.getText()));
        listOfDescOfBing.forEach(e-> System.out.println("description Bing "+e.getText()));

    }
    @Test(priority = 3)
    public void chechResult(){
        ///عملت مقارنة بين المصفوفات string  الي حولتهم
        for(int i = 0; i< bing.size(); i++){
            for(int j = 0; j< bing.size(); j++){
                if(bing.get(i).equals(google.get(j))){
                    System.out.println(i+"is true");
                }
            }
        }
    }


}
