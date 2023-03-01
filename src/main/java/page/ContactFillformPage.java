package page;

import Action.SeleniumAction;
import json.ReadFromJson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class ContactFillformPage {
    public WebDriver driver;
    SeleniumAction seleniumAction;
    ReadFromJson readFromJson;
    public ContactFillformPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        seleniumAction=new SeleniumAction();
        readFromJson=new ReadFromJson();
    }
    @FindBy(xpath = "//input[@name ='name']")
    WebElement nametextfield;

    @FindBy(xpath = "//input[@name ='email']")
    WebElement emailtextfield;

    @FindBy(xpath = "//textarea[@name ='message']")
    WebElement msgtextfield;

    @FindBy(xpath = "//div[@ class='SuccessMessage']")
    WebElement successfulmessage;

    @FindBy(xpath = "//div[@id='contactFooter']/div/div[@id='sendmainButton']")
    WebElement mainbutton;

    /*
    this method will fill the form by using jsonreader
     */
    public  void fillform() throws InterruptedException, FileNotFoundException {
        WebElement frameElement= driver.findElement(By.xpath("//div[@class='thumbCellSplit']/following-sibling::div/descendant::iframe"));
        driver.switchTo().frame(frameElement);
        seleniumAction.enterValueOnTextfield(nametextfield,readFromJson.readFile("Name"));

        seleniumAction.enterValueOnTextfield(emailtextfield,readFromJson.readFile("Email"));
        seleniumAction.enterValueOnTextfield(msgtextfield,readFromJson.readFile("Message"));
        Thread.sleep(3000);
        seleniumAction.clickOnElement(mainbutton);


    }
    /*
    this method will verify the msg after filling the form and submit
     */
    public boolean verifymsg() throws InterruptedException {
        Thread.sleep(5000);
        boolean result = successfulmessage.isDisplayed();
        return result;

    }
}
