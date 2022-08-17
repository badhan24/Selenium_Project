package pages;

import Browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(id = "txtUsername") private WebElement username;
    @FindBy(id = "txtPassword") private WebElement passward;
    @FindBy(id = "btnLogin") private WebElement loginButton;

    public void login() {
        username.sendKeys(Browser.getPropertyValue("username"));
        passward.sendKeys(Browser.getPropertyValue("passward"));
        loginButton.click();

    }

}
