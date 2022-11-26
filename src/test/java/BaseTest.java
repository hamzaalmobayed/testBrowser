// Generated by Selenium IDE

import org.example.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected static ChromeDriver driver;
    protected static HomePage home;



    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();



    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
 }
