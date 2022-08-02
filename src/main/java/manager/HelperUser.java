package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm() {
        wd.findElement(By.linkText("Log in")).click();

    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);

        takeScreenShots("C:/Users/Alla/Desktop/projects QA/Ilcaro/src/test/screenshorts/screen-1.png");

        type(By.xpath("//input[@id='password']"), password);



    }
    public void fillLoginForm(User user) {
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());

    }


    public boolean isLogged() {

        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void logOut() {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"),user.getName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }

    public void checkPolicy() {
        click(By.cssSelector("label[for='terms-of-use']"));
    }
    public void checkPolicyXY() {
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rect = label.getRect();
       int xOffSet = rect.getWidth()/2;
       int yOffSet = rect.getHeight()/2;


        Actions actions = new Actions(wd);
        actions.moveToElement(label,-xOffSet,0).click().release().perform();
        //actions.moveToElement(label).release().perform();
        //actions.moveByOffset(-xOffSet,-yOffSet).click().release().perform();
    }

    public void clickOK() {

        if(isElementPresent(By.xpath("//button[text()='Ok']"))){
            click(By.xpath("//button[text()='Ok']"));
        }
    }


    public boolean isErrorPasswordFormatDisplayed() {
        boolean lastChild = new WebDriverWait(wd,Duration.ofSeconds(5)).until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector("div.error div:last-child")),"Password must contain 1 uppercase letter, 1 lowercase letter and one number"));

        return lastChild;
    }

    public boolean isErrorPasswordSizeDisplayed() {
        return new WebDriverWait(wd,Duration.ofSeconds(5)).until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.cssSelector("div.error div:first-child")),"Password must contain minimum 8 symbols"));
    }



    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submit();
        clickOK();
    }
}