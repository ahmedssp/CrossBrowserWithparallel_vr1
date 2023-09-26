import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test_cases  extends Sutup_parallel{
    @Test
    public void M_TC1_1(){System.out.println("M_TC1_1: Tread ID:"+ Thread.currentThread().getId());}
    @Test
    public void M_TC1_2(){System.out.println("M_TC1_2: Tread ID:"+ Thread.currentThread().getId());}
    @Test
    public void M_TC1_3(){System.out.println("M_TC1_3: Tread ID:"+ Thread.currentThread().getId());}
    @Test
    public void M_TC1_4(){System.out.println("M_TC1_4: Tread ID:"+ Thread.currentThread().getId());}
    @Test
    public void M_TC1_5(){System.out.println("M_TC1_5: Tread ID:"+ Thread.currentThread().getId());}
    @Test
    public void M_TC1_6 (){System.out.println("M_TC1_6: Tread ID:"+ Thread.currentThread().getId());}
}
