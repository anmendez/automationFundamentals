import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Main {
    public static void main(String[] args) {
        /*String pathToDriver = Main.class.getResource("/chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", pathToDriver);

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/index.php?route=account/login"); //this is not a good practice

        WebElement emailElement = driver.findElement(By.name("email"));     //this is storing in a variable the element found in the page
        emailElement.sendKeys("andrea.emailnator.com");       //this is performing an action with the element found and stored

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("12345");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type = 'submit']"));
        loginButton.click();
        //another option to do this is chaining: driver.findElement(By.xpath("//input[@type = 'submit'])).click();
        //you can decide which one to use, if you have to use the same element more than once, chaining is not a good idea

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertTrue(alertMessage.isDisplayed());
        driver.close();             //these two are to close the chrome
        driver.quit();              //window after the test is executed
    }*/
        String pathToDriver = Main.class.getResource("/chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", pathToDriver);            //this is calling the driver

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/"); //how can I set this link into a variable?
        //This searches for a Macbook
        WebElement searchElement = driver.findElement(By.cssSelector(".form-control"));
        searchElement.sendKeys("Macbook");
        searchElement.sendKeys(Keys.RETURN);

        //This selects the first Macbook

        driver.findElement(By.cssSelector(".caption a")).click();
        //This adds to cart
        WebElement addToCart = driver.findElement(By.cssSelector(".form-group #button-cart"));
        addToCart.click();

        //This asserts the product has been added to cart
        WebElement alertMessage = driver.findElement(By.cssSelector(".alert-success"));
        Assert.assertTrue(alertMessage.isDisplayed());
        driver.close();             //these two are to close the chrome
        driver.quit();              //window after the test is executed*/
    }
}
