package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHRMsteps {

    private static final By LOGIN_USERNAME = By.name("username");
    private static final By LOGIN_BRANDING = By.cssSelector(".orangehrm-login-branding img[alt='company-branding']");

    WebDriver driver;
    WebDriverWait wait;

    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @When("I open orange hrm home page")
    public void i_open_orange_hrm_home_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_USERNAME));
    }

    @Then("I verify the logo is present on the home page")
    public void i_verify_the_logo_is_present_on_the_home_page() {
        WebElement branding = wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BRANDING));
        Assert.assertTrue("Expected the OrangeHRM branding image to be visible on the login page.", branding.isDisplayed());
    }

    @And("close the browser")
    public void close_the_browser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
