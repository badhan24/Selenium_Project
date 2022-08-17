package Browser;

import com.beust.jcommander.IStringConverter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.AuthProvider;
import java.util.Properties;

import static java.lang.System.getProperty;

public class Browser {

   private static WebDriver driver;

    public static String getPropertyValue(String propertyName){
        String propertyValue="";
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/info.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            propertyValue = properties.getProperty(propertyName);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return propertyValue;

    }
    public static void setDriver() {
        String driverValue = getPropertyValue("browser");

        if(driverValue.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(driverValue.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

    public static WebDriver getDriver(){
        return driver;
    }


}


