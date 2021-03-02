package TestClasses;

public class paymentStepsTest {
    public static String xpathForConfirmBaksetButton = "//a[@class='btn Basket_CheckoutButton'][1]";

    public static String xpathForCardNumberInput = "//input[@id='card-number']";
    public static String xpathForCVV = "//input[@id='card-cvv']";
    public static String xpathForTermsAndConditions = "//section[@class='termsCondition contentBox']//div[@class='checkBox']";
    public static String xpathForPayButton = "//section[@class='goPayment opacityDeactive'][1]";

    public static String creditCardNo = "123456789";
    public static String CVV = "123";

    @When("I confirm basket")
    public void iConfirmBasket(){
        driver.click(By.xpath(xpathForConfirmBaksetButton));
    }

    @And("I pay for product")
    public void iPayForProduct(){
        driver.click(By.xpath(xpathForCardNumberInput)).sendKeys(creditCardNo);
        driver.click(By.xpath(xpathForCVV)).sendKeys(CVV);
        driver.click(By.xpath(xpathForTermsAndConditions));
        driver.click(By.xpath(xpathForPayButton));
    }
}
