package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MyFirstTestFW extends BaseTest {

    @Test
    public static void LoginTest()
    {
        System.out.println("Clicked Successfully");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("sarathkannan1-ukmn@force.com"); //locatoer -- properties
        driver.findElement(By.id("password")).sendKeys("Noelzion@2706");
        driver.findElement(By.id("Login")).click();
    }


}
