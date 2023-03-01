package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import page.ContactFillformPage;
import page.HomePage;

import java.io.FileNotFoundException;

public class HomeSteps {
    HomePage homePage;
    static WebDriver driver;
    ContactFillformPage contactFillformPage;
    @Before
    public static void setup(){
        WebDriverManager.edgedriver().setup();
         driver = new EdgeDriver();
        driver.get("https://compendiumdev.co.uk/");
    }
    @Given("user on home page")
    public void user_on_home_page() {
        System.out.println("i am on home page");
        homePage=new HomePage(driver);

    }
    @When("click on contact")
    public void click_on_contact() {
        System.out.println("contact");
        homePage.clickonContact();

    }
    @Then("fill the form")
    public void fill_the_form() throws InterruptedException, FileNotFoundException {
        System.out.println("fill the form");
        contactFillformPage=new ContactFillformPage(driver);
        contactFillformPage.fillform();
        //contactFillformPage.verifymsg();
    }
    @Then("verify form submit successfully")
    public void verify_form_submit_successfully() throws InterruptedException {
        System.out.println("submit successfully");
        boolean result =contactFillformPage.verifymsg();
        Assert.assertTrue(result);
    }

}
