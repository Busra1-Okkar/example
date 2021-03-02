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

public class loginTest {

    public static String xpathForNavigationMenu = "//div[@id='account-navigation-container']";
    public static String xpathForLogin = xpathForNavigationMenu + "//div[@class='account-nav-item user-login-container']";

    public static String xpathForEmail = "//input[@data-testid='email-input']";
    public static String xpathForPassword = "//input[@type='password']";
    public static String xpathForLoginButton = "//button[@type='submit']";

    public static WebDriver driver;
    public static String homepage;
    public static String email = "busraokkar@gmail.com";
    public static String userPassword = "1234";


    @Given("I am on the homepage")
    public void iAmOnTheHomepage (){
        System.setProperty("webdriver.chrome.driver", "/Users/Busra/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(200, SECONDS);
        driver.manage().window().maximize();
        homepage = "http://www.trendyol.com/";
        driver.get(homepage);
    }

    @When("I click for login")
    public void iClickForLogin(){
        driver.click(By.xpath(xpathForLogin));
    }

    @And("I fill login form")
    public void iFillLoginForm(){
        driver.click(By.xpath(xpathForEmail)).sendKeys(email);
        driver.click(By.xpath(xpathForPassword)).sendKeys(userPassword);
    }

    @And("I click the login button")
    public void iClickTheLoginButton(){
        driver.click(By.xpath(xpathForLoginButton));
    }

    @Then("I see the homepage")
    public void iSeeTheHomepage() {
        Assert.assertEquals(driver.geturl(),homepage);
    }
}
