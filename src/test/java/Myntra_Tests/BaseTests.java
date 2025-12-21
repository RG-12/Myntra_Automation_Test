package Myntra_Tests;

import listeners.Listener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(Listener.class)
public class BaseTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closure(){
        driver.close();
        driver.quit();
    }

    @Test
    @DisplayName("Brand")
    void Case1(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.myntra.com/");

        WebElement men_option = driver.findElement(By.xpath("//header[@id='desktop-header-cnt']//a[text()='Men']"));
        Actions act = new Actions(driver);
        act.moveToElement(men_option).perform();

        driver.findElement(By.linkText("Sweaters")).click();
        driver.findElement(By.xpath("//img[@class='img-responsive']")).click();

        String window2 = new ArrayList<String>(driver.getWindowHandles()).get(1);
        driver.switchTo().window(window2);

        String productTitle =  driver.findElement(By.className("pdp-title")).getText();
        System.out.println("Brand Name: " + productTitle);

        String productSize = "";
        List<WebElement> buttons_Size = driver.findElements(By.className("size-buttons-size-button"));
        for(WebElement button: buttons_Size){
            button.click();
            productSize = button.getText();
            break; //First available size is selected
        }

        driver.findElement(By.xpath("//div[text()='ADD TO BAG']")).click();
        driver.findElement(By.xpath("//span[text()='GO TO BAG']")).click();

        String cartBrand = driver.findElement(By.className("itemContainer-base-brand")).getText();
        Assertions.assertEquals(productTitle, cartBrand,  "Test Failed");

    }

    @Test
    @DisplayName("Product Name")
    void Case2() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.myntra.com/");

        WebElement men_option = driver.findElement(By.xpath("//header[@id='desktop-header-cnt']//a[text()='Men']"));
        Actions act = new Actions(driver);
        act.moveToElement(men_option).perform();

        driver.findElement(By.linkText("Sweaters")).click();
        driver.findElement(By.xpath("//img[@class='img-responsive']")).click();

        String window2 = new ArrayList<String>(driver.getWindowHandles()).get(1);
        driver.switchTo().window(window2);

        String productName =  driver.findElement(By.className("pdp-name")).getText();
        System.out.println("Product Name: " + productName);

        String productSize = "";
        List<WebElement> buttons_Size = driver.findElements(By.className("size-buttons-size-button"));
        for(WebElement button: buttons_Size){
            button.click();
            productSize = button.getText();
            break; //First available size is selected
        }

        driver.findElement(By.xpath("//div[text()='ADD TO BAG']")).click();
        driver.findElement(By.xpath("//span[text()='GO TO BAG']")).click();

        String cartProductName = driver.findElement(By.className("itemContainer-base-itemLink")).getText();
        Assertions.assertEquals(productName, cartProductName,  "Test Failed");

    }

    @Test
    @DisplayName("Product Size")
    void Case3(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.myntra.com/");

        WebElement men_option = driver.findElement(By.xpath("//header[@id='desktop-header-cnt']//a[text()='Men']"));
        Actions act = new Actions(driver);
        act.moveToElement(men_option).perform();

        driver.findElement(By.linkText("Sweaters")).click();
        driver.findElement(By.xpath("//img[@class='img-responsive']")).click();

        String window2 = new ArrayList<String>(driver.getWindowHandles()).get(1);
        driver.switchTo().window(window2);

        String productSize = "";
        List<WebElement> buttons_Size = driver.findElements(By.className("size-buttons-size-button"));
        for(WebElement button: buttons_Size){
            button.click();
            productSize = button.getText();
            break; //First available size is selected
        }
        System.out.println("Size: " + productSize);

        driver.findElement(By.xpath("//div[text()='ADD TO BAG']")).click();
        driver.findElement(By.xpath("//span[text()='GO TO BAG']")).click();

        String cartProductSize = driver.findElement(By.className("itemComponents-base-size")).getText();
        cartProductSize = cartProductSize.replaceAll("Size: ", "");
        Assertions.assertEquals(productSize, cartProductSize,  "Test Failed");
    }

    @Test
    @DisplayName("Product Price")
    void Case4(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.myntra.com/");

        WebElement men_option = driver.findElement(By.xpath("//header[@id='desktop-header-cnt']//a[text()='Men']"));
        Actions act = new Actions(driver);
        act.moveToElement(men_option).perform();

        driver.findElement(By.linkText("Sweaters")).click();
        driver.findElement(By.xpath("//img[@class='img-responsive']")).click();

        String window2 = new ArrayList<String>(driver.getWindowHandles()).get(1);
        driver.switchTo().window(window2);

        String productPrice =  driver.findElement(By.className("pdp-price")).getText();
        productPrice = productPrice.replaceAll("[^0-9]", "");
        System.out.println("Price: " + productPrice);

        String productSize = "";
        List<WebElement> buttons_Size = driver.findElements(By.className("size-buttons-size-button"));
        for(WebElement button: buttons_Size){
            button.click();
            productSize = button.getText();
            break; //First available size is selected
        }

        driver.findElement(By.xpath("//div[text()='ADD TO BAG']")).click();
        driver.findElement(By.xpath("//span[text()='GO TO BAG']")).click();

        String cartProductPrice = driver.findElement(By.className("itemComponents-base-price")).getText();
        cartProductPrice = cartProductPrice.replaceAll("[^0-9]", "");
        Assertions.assertEquals(productPrice, cartProductPrice,  "Test Failed");

    }

    @Test
    @DisplayName("Product Quantity")
    void Case5(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.myntra.com/");

        WebElement men_option = driver.findElement(By.xpath("//header[@id='desktop-header-cnt']//a[text()='Men']"));
        Actions act = new Actions(driver);
        act.moveToElement(men_option).perform();

        driver.findElement(By.linkText("Sweaters")).click();
        driver.findElement(By.xpath("//img[@class='img-responsive']")).click();

        String window2 = new ArrayList<String>(driver.getWindowHandles()).get(1);
        driver.switchTo().window(window2);

        String productSize = "";
        List<WebElement> buttons_Size = driver.findElements(By.className("size-buttons-size-button"));
        for(WebElement button: buttons_Size){
            button.click();
            productSize = button.getText();
            break; //First available size is selected
        }

        driver.findElement(By.xpath("//div[text()='ADD TO BAG']")).click();
        driver.findElement(By.xpath("//span[text()='GO TO BAG']")).click();

        String cartProductQuantity = driver.findElement(By.className("itemComponents-base-quantity")).getText();
        cartProductQuantity = cartProductQuantity.replaceAll("Qty: ", "");
        System.out.println("Quantity: " + cartProductQuantity);
        Assertions.assertEquals("1", cartProductQuantity,  "Test Failed");

    }

}

