package chrome;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class OtherTests {

    private final long DELAY = 500;

    private WebDriver driver;

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.get("https://www.gismeteo.ru/");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testViewingNews() throws Exception {
        driver.findElement(By.xpath("//span[@class='title nolink'][1]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/news/", driver.getCurrentUrl());
    }

    @Test
    public void testViewingAbout() throws Exception {
        driver.findElement(By.xpath("//div[@class='footer_item'][1]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/page/contacts/", driver.getCurrentUrl());
    }

    @Test
    public void testViewingCommercial() throws Exception {
        driver.findElement(By.xpath("//div[@class='footer_item'][3]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/page/adv/", driver.getCurrentUrl());
    }

    @Test
    public void testViewingAgreement() throws Exception {
        driver.findElement(By.xpath("//div[@class='footer_item'][4]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/page/agreement/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
