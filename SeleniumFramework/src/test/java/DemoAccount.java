import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DemoAccount {
//This will save us of having a chrome driver.exe
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
    }
    @Ignore
    @Test
    public void test_capabilities(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1700,800");  //this makes the browser window to be in a certain size
        options.addArguments("--headless");     //This run the test but it never opens up the browser
        options.setHeadless(true);      //This does the same thing than the one above ^^^
        options.setAcceptInsecureCerts(true);    //This allows to go to pages that notify the connetion is not private


        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.seleniumeasy.com/test/");

        driver.manage().window().maximize();    //maximizes the browser windows

        driver.close();
        driver.quit();
    }

    @Test
    public void test_waits(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
        driver.findElement(By.id("downloadButton")).click();

        boolean result = false;
        //exeption handlers
        try{
            result = wait.until(ExpectedConditions.textToBe(By.className("progress-label"), "Complete!"));
        }
        catch (WebDriverException exeption){
            System.out.println("It didn't work");
        }
        driver.close();
        driver.quit();
    }

    @Test
    public void drag_and_drop(){        //drag and drop practice
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");

        Actions actions = new Actions(driver);

        WebElement box1 = driver.findElement(By.xpath("//span[text()='Draggable 1']"));
        WebElement drop = driver.findElement(By.id("mydropzone"));
        Assert.assertTrue(drop.isDisplayed());

        Point punto = drop.getLocation();

        actions.dragAndDrop(box1, drop).release().build().perform();
        actions.dragAndDropBy(box1, punto.getX(), punto.getY()).release().build().perform();

        actions.perform();
        WebElement dropped = driver.findElement(By.xpath("//div[@id='droppedlist']/span[text() = 'Draggable 1']"));
        Assert.assertTrue(dropped.isDisplayed());

    }
}
