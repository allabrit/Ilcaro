package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm() {
        wd.findElement(By.linkText("Log in")).click();

    }
    public void submitLogin() {

        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }
    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);

    }


    public boolean isLogged() {
        List<WebElement > list =wd.findElements(By.linkText("Logout"));
        return list.size()>0;
    }

    public void logOut() {
        click(By.linkText("Logout"));
    }

}