package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
            public void successLogin() {
        openLoginForm();
        fillLoginForm("noa@gmail.com", "Nnoa12345$");
        submitLogin();
    }

    @Test
public void loginNegativeTestsWrongEmail(){
        openLoginForm();
        fillLoginForm("noagmail.com", "Nnoa12345$");
        submitLogin();
    }

}
