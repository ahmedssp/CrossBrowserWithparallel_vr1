import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;
public class Sutup_parallel {
    protected WebDriver driver;
    protected  static ThreadLocal<EdgeDriver> d1=new  ThreadLocal<>();
    protected  static ThreadLocal<FirefoxDriver > d2=new  ThreadLocal<>();
    protected  static ThreadLocal<ChromeDriver > d3=new  ThreadLocal<>();
    @Parameters("browserType")
    public WebDriver GetDriv(String Driver){
        WebDriver x = null;
        if (Driver.equalsIgnoreCase("EdgeDriver")) {x= d1.get();}
        else if (Driver.equalsIgnoreCase("Firefox")){x= d2.get();}
        else if (Driver.equalsIgnoreCase("Chrome")) {x= d3.get();}
       return x;
    }
    @Parameters("browserType")
    @BeforeMethod
     public void starting( String browserType){
        if (browserType.equalsIgnoreCase("EdgeDriver")) {
            WebDriverManager.edgedriver().setup();
            d1.set(new EdgeDriver());
        }
        else if (browserType.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            d2.set(new FirefoxDriver());
        }
        else if (browserType.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            d3.set(new ChromeDriver());

        }

//        System.setProperty("webdriver.http.factory", "jdk-http-client");
        GetDriv(browserType).manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        GetDriv(browserType).get("https://google.com");
        GetDriv(browserType).manage().window().setSize(new Dimension(300,300));
          }
    @Parameters("browserType")
    @AfterMethod
    public void tear(String browserType){GetDriv(browserType).quit();}
    private ChromeOptions getChromeOptions_m() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }
}

