package alltest;

import Browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.spi.BreakIteratorProvider;
import java.time.Duration;

public class HomePageTest {
    WebDriver driver;

   @BeforeMethod

    public void setDriver()  {
       Browser.setDriver();
       driver = Browser.getDriver();
       driver.navigate().to(Browser.getPropertyValue("URL"));
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   }
    @Test
    public void test(){
       System.out.println("This is a Test");
    }
}
