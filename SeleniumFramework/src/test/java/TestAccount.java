import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TestAccount {
    //@Description("Validate test login was successful")
    @Test //for this, the credentials are registered, so the test will pass
    public void Test_Login_Successful(){
        String username = "andrea@mailnator.com";
        String password = "qwrt1234";

        String pathToDriver = Test.class.getResource("/chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", pathToDriver);
                                                    //These 3 lines are setting the driver
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");  //This is telling the driver where to go

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //This goes to login page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.linkText("Login")).click();

        //This fills the form
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();

        //This asserts the account is logged in
        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());

        //This takes a screenshot
        //TakeScreenshot(driver);

        //This closes the browsers and ends the execution
        driver.close();
        driver.quit();
    }

    //@Description("Validate that the login is working with non valid credentials")
    @Test //for this, the password is not correct, so the test will fail
    public void Test_Login_Unsuccessful(){
        String username = "andrea@mailnator.com";
        String password = "t1234";
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password";

        String pathToDriver = Test.class.getResource("/chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        //These 3 lines are setting the driver
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");  //This is telling the driver where to go

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //This goes to login page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.linkText("Login")).click();

        //This fills the form
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();

        //This asserts the account is logged in
        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
       Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());
       //what trim does is taking the spaces from the beginning and the end of the string

        //This takes a screenshot
        //TakeScreenshot(driver);

        //This closes the browsers and ends the execution
        driver.close();
        driver.quit();


        /*@Attachment(value = "screenshot", type = "image/png")
        public byte[] TakeScreenshot(WebDriver driver){
            return ((TakeScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
         */
    }
}
//Note: remember to always download the chrome driver and add it to the resources folder. if this step is not made, it will not run