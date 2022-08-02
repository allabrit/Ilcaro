package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

@Test
    public void searchCurrentMonth(){

    app.search().searchCurrentMonth("Tel-Aviv","7/28/2022","7/27/2022");
    app.search().submit();
    Assert.assertTrue(app.search().isListOfCarsAppeared());
    app.search().takeScreenShots("C:/Users/Alla/Desktop/projects QA/Ilcaro/src/test/screenshorts/screen.1png");
}
@Test
public void searchNextMonth(){
    app.search().searchNextMonth("Tel-Aviv-Jaffa","8/28/2022","8/27/2022");
    app.search().submit();
    Assert.assertTrue(app.search().isListOfCarsAppeared());
    app.search().takeScreenShots("C:/Users/Alla/Desktop/projects QA/Ilcaro/src/test/screenshorts/screen.2png");
}

@Test
public void searchPeriodPast() {
app.search().searchPeriodPast("Rehovot","2/10/2022","3/15/2022");
    app.search().submitWithoutWait();
Assert.assertTrue(app.search().isYallaButtonNotActive());
Assert.assertTrue(app.search().isPeriodInPast());
}

@Test
    public void searchCurrentYear(){
    app.search().searchCurrentYear("Jerusalem","8/10/2022","10/20/2022");
    app.search().submit();
    Assert.assertTrue(app.search().isListOfCarsAppeared());
    Assert.assertTrue(app.search().isPageResultAppeared());
    app.search().takeScreenShots("C:/Users/Alla/Desktop/projects QA/Ilcaro/src/test/screenshorts/screen.4png");

}

@Test
public void searchCurrentYearLocalDate(){
    app.search().searchCurrentYearLocalDate("Haifa","8/10/2022","10/20/2022");
    app.search().submit();
    Assert.assertTrue(app.search().isListOfCarsAppeared());
    app.search().takeScreenShots("C:/Users/Alla/Desktop/projects QA/Ilcaro/src/test/screenshorts/screen.5png");

}
    @Test(groups = {"web"})
    public void searchAnyPeriod() {
        app.search().searchAnyPeriod("Haifa", "1/10/2023", "5/25/2023");
        app.search().submit();
        Assert.assertTrue(app.search().isListOfCarsAppeared());
        app.search().takeScreenShots("C:/Users/Alla/Desktop/projects QA/Ilcaro/src/test/screenshorts/screen.6png");
    }


@BeforeMethod(alwaysRun = true)
    public void returnToHome(){

    app.search().returnToHome();
}



}
