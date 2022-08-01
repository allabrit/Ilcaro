package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    public void click(By locator){
        wd.findElement(locator).click();
    }
    public void submit() {
        new WebDriverWait(wd, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable( wd.findElement(By.xpath("//button[@type='submit']"))));

        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void submitWithoutWait() {
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public boolean isElementPresent(By locator){

        return wd.findElements(locator).size()>0;
    }
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public String getMessage() {
        pause(2000);
        new WebDriverWait(wd, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.dialog-container"))));
        String message = wd.findElement(By.cssSelector(("div.dialog-container h1"))).getText();
        return message;
    }

    public void takeScreenShots(String pathToFile){
       File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screen = new File(pathToFile);
        try {
            Files.copy(tmp,screen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isYallaButtonNotActive() {

        boolean disabled = isElementPresent(By.cssSelector("button[disabled]"));
        boolean enabled = wd.findElement(By.cssSelector("[type='submit']")).isEnabled();
        return disabled&&!enabled;

    }

}
