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
import static utils.DefaultLocationSetter.setDefaultLocation;

public class ViewingMapsTests {

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
    public void testViewingRainMap() throws Exception {
        setDefaultLocation(driver, DELAY);

        driver.findElement(By.xpath("//div[@class='maps'][1]//div[1]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/maps/eur/prc/", driver.getCurrentUrl());
    }

    @Test
    public void testViewingTemperatureMap() throws Exception {
        setDefaultLocation(driver, DELAY);

        driver.findElement(By.xpath("//div[@class='map'][2]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/maps/eur/temp/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
