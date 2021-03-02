package TestClasses;

import static java.util.concurrent.TimeUnit.SECONDS;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class listingTest {
    public static String xpathForSlider = "//div[@class='slick-slider slick-initialized']";
    public static String xpathForSliderList = xpathForSlider + "//div[@class='slick-list']";
    public static String xpathForSliderData = xpathForSliderList + "/div[@data-index='3']//a";

    public static String xpathForProducts = "//div[@class='prdct-cntnr-wrppr']";
    public static String xpathForFirstProduct = xpathForProducts + "//div[@class='p-card-wrppr'][1]";

    public static String xpathForAddToBasketButton = "//div[@class='add-to-bs-wrp']//div[@class='add-to-bs-tx']";

    public static WebDriver driver;
    public static String basketPage;
    private int invalidImageCount;

    @When("I click on slider")
    public void iClickOnSlider(){
        driver.click(By.xpath(xpathForSliderData));
    }

    @Then("I see the products")
    public void iSeeProducts() {
        driver.findElement(By.xpath(xpathForProducts));
    }

    @And("I find broken images")
        public void findBrokenImages() {
                try {
                    invalidImageCount = 0;
                    List<WebElement> imagesList = driver.findElements(By.tagName("img"));
                    System.out.println("Total no. of images are " + imagesList.size());
                    for (WebElement imgElement : imagesList) {
                        if (imgElement != null) {
                            verifyimageActive(imgElement);
                        }
                    }
                    System.out.println("Total no. of invalid images are "	+ invalidImageCount);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }

    @When("I click first product")
    public void iClickFirstProduct(){
        driver.click(By.xpath(xpathForFirstProduct));
    }

    @And("I add product to basket")
    public void iAddProductToBasket(){
        driver.click(By.xpath(xpathForAddToBasketButton));
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        driver.click(By.xpath("//div[@class='account-nav-item basket-preview']"));
    }

    @Then("I see basket page")
    public void iSeeBasketPage() {
        Assert.assertEquals(driver.geturl(),basketPage);
    }
}
