package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Myntra_Test {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.myntra.com/");
        driver.manage().window().maximize();

        WebElement men_option = driver.findElement(By.xpath("//header[@id='desktop-header-cnt']//a[text()='Men']"));
        Actions act = new Actions(driver);
        act.moveToElement(men_option).perform();

        driver.findElement(By.linkText("Sweaters")).click();
        driver.findElement(By.xpath("//img[@class='img-responsive']")).click();

        String window2 = new ArrayList<String>(driver.getWindowHandles()).get(1);
        driver.switchTo().window(window2);

        String productTitle =  driver.findElement(By.className("pdp-title")).getText();
        String productName =  driver.findElement(By.className("pdp-name")).getText();
        String productPrice =  driver.findElement(By.className("pdp-price")).getText();
        productPrice = productPrice.replaceAll("[^0-9]", "");

        String productSize = "";
        List<WebElement> buttons_Size = driver.findElements(By.className("size-buttons-size-button"));
        for(WebElement button: buttons_Size){
            button.click();
            productSize = button.getText();
            break; //First available size is selected
        }

        System.out.println(productTitle);
        System.out.println(productName);
        System.out.println(productPrice);
        System.out.println(productSize);

        driver.findElement(By.xpath("//div[text()='ADD TO BAG']")).click();
        driver.findElement(By.xpath("//span[text()='GO TO BAG']")).click();

        //Card Validations

        String cartBrand = driver.findElement(By.className("itemContainer-base-brand")).getText();
        System.out.println(cartBrand);

        String cartProductName = driver.findElement(By.className("itemContainer-base-itemLink")).getText();
        System.out.println(cartProductName);

        String cartProductPrice = driver.findElement(By.className("itemComponents-base-price")).getText();
        cartProductPrice = cartProductPrice.replaceAll("[^0-9]", "");
        System.out.println(cartProductPrice);

        String cartProductSize = driver.findElement(By.className("itemComponents-base-size")).getText();
        cartProductSize = cartProductSize.replaceAll("Size: ", "");
        System.out.println(cartProductSize);

        String cartProductQuantity = driver.findElement(By.className("itemComponents-base-quantity")).getText();
        cartProductQuantity = cartProductQuantity.replaceAll("Qty: ", "");
        System.out.println(cartProductQuantity);


        if(cartProductPrice.contentEquals(productPrice)){
            System.out.println("Passed");
        }

        driver.quit();






    }
}
