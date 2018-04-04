import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by kimprzybylski on 4/04/18.
 */
public class ProductTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/kimprzybylski/GitHub/Selenium/chromedriver");

        driver = new ChromeDriver();
    }

    @Test
    public void shoudShowListCreateEditDeleteProduct() {
        driver.get("http://localhost:8080/productList");

        assertTrue(driver.findElement(By.id("titel")).getText().contains("Product List"));

        driver.findElement(By.id("create")).click();

        assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/createProduct"));

        driver.findElement(By.name("code")).sendKeys("123");
        driver.findElement(By.name("name")).sendKeys("test product");
        driver.findElement(By.name("price")).sendKeys("12");
        driver.findElement(By.id("submit")).click();

        assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/productList"));

        assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[1]")).getText().equals("123"));
        assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]")).getText().equals("test product"));
        assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]")).getText().equals("12.0"));

        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[4]")).click();

        assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/editProduct?code=123"));

        driver.findElement(By.name("name")).sendKeys("test2");
        driver.findElement(By.name("price")).sendKeys("22.0");
        driver.findElement(By.id("submit")).click();

        assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/productList"));

        assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[1]")).getText().equals("123"));
        assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]")).getText().equals("test2"));
        assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]")).getText().equals("22.0"));

        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[5]")).click();

        assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[1]")).getText().equals("P001"));
        assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]")).getText().equals("Java Core"));
        assertTrue(driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]")).getText().equals("100.0"));
    }

    @After
    public void after() {
        driver.close();
    }
}
