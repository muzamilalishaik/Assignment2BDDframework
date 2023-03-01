package page;

import Action.SeleniumAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;
    SeleniumAction seleniumAction;
public HomePage(WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver,this);
    seleniumAction=new SeleniumAction();
}
@FindBy(linkText = "Contact")
    WebElement contactlink;

/*
this method will  click on the contact link
 */
public void clickonContact(){
    seleniumAction.clickOnElement(contactlink);

}

}
