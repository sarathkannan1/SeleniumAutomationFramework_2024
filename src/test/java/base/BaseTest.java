package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public  static WebDriver driver;
    public  static Properties prop = new Properties();
    public static FileReader fr;

    @BeforeTest
    public void setup() throws IOException {
        if(driver==null){
            FileReader fr = new FileReader("/Users/sarathdayala/SeleniumAutomationFramework_2024/src/test/resources/configfiles/config.properties");
            prop.load(fr);
        }

        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();  //base
            driver = new ChromeDriver();   //base
            driver.get(prop.getProperty("testurl"));  //Properties
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();  //base
            driver = new FirefoxDriver();   //base
            driver.get(prop.getProperty("testurl"));
        }
    }
    @AfterTest
    public void  tearDown() {

         driver.close();
         System.out.println("Teardown successful");
    }
}
