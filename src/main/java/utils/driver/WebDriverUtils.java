package utils.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverUtils {

    public static WebDriver driver;

    public static WebDriver inThePage(String url) {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/webdriver/webdriverFilezilla/geckodriver.exe");
        driver = new FirefoxDriver();
        /*System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/webdriverChrome/chromedriver.exe");
        driver = new ChromeDriver(); */
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
       return driver;
    }

    public static WebDriver getPageTitle(){
        String title = driver.getTitle();
        return driver;
    }
}

