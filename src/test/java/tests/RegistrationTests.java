package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logOut();
        }
    }

    @Test(groups = {"web"})
    public void registrationSuccess() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().setName("Liz").setLastName("Snows").setEmail("test" + i + "@mail.com").setPassword("Aa12345678$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Registered");


    }

    @Test(dataProvider = "dataRegistration",dataProviderClass = MyDataProvider.class,enabled = false)
    public void registrationSuccess2(User user) {
        //int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        //User user = new User().setName("Liz").setLastName("Snows").setEmail("test" + i + "@mail.com").setPassword("Aa12345678$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Registered");


    }
    @Test
    public void registrationWrongPasswordFormat(){
        User user = new User().setName("Lana").setLastName("Snow").setEmail("lana@gmail.com").setPassword("Lana");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();

        Assert.assertTrue(app.getHelperUser().isErrorPasswordFormatDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorPasswordSizeDisplayed());
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());





    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        app.getHelperUser().clickOK();
    }

}
