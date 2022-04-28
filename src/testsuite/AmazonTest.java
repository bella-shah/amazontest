package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class AmazonTest extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyFunctionalityOfAmazonWeb() throws InterruptedException {
        //2. Type "Dell Laptop" in the search box and press enter or click on search button
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        mouseHoverClick(By.xpath("//input[@id='sp-cc-accept']"));
        System.out.println("Accept Cookies");
        // 3. Click on the checkbox brand dell on the left side.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));
        //4. Verify that the  30(May be different) products are displayed on the page.
        int expectedQuantity = 22;
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        int actualQuantity = elementList.size();
        Thread.sleep(2000);
        Assert.assertEquals("Quality not match", expectedQuantity, actualQuantity);
        //5. Print all product names in the console.
        List<WebElement> product = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement e : product) {
            System.out.println(e.getText());

        }
    }

    //6. Close the Browser.
    @After
    public void tearDown() {
        closeBrowser();
    }
}
