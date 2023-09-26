import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Testc extends Thread{
    protected WebDriver d;
    @Override
    public void run(){d=new ChromeDriver();}
    @Test
    public void M_TC1_1(){System.out.println("M_TC1_1");}
    @Test
    public void M_TC1_2() {System.out.println("M_TC1_2");}
    @Test
    public void M_TC1_3 () {System.out.println("M_TC1_3");}

    @AfterMethod
    public void Qiut() throws InterruptedException {
        System.out.println("WE are in After method");
        d.close();}
    @BeforeMethod
    public void Sutup(){
        System.out.println("WE are in before method");
//        Testc thread =new Testc();thread.start();
//         start();
         run();
//        d=new EdgeDriver();
        d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        d.get("https://google.com");
        d.manage().window().setSize(new Dimension(300,300));
    }

}
