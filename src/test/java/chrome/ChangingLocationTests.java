package chrome;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static utils.DefaultLocationSetter.setDefaultLocation;

public class ChangingLocationTests {

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
    public void testChangingLocationToNear() throws Exception {
        setDefaultLocation(driver, DELAY);

        driver.findElement(By.xpath("//div[@class='cities_list column_size_2'][1]//a")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/weather-sankt-peterburg-pulkovo-12967/", driver.getCurrentUrl());
    }

    @Test
    public void testChangingLocationWithSearch() throws Exception {
        setDefaultLocation(driver, DELAY);

        driver.findElement(By.xpath("//input[@class='search_input'][1]")).click();
        Thread.sleep(DELAY);
        driver.findElement(By.xpath("//input[@class='search_input'][1]")).sendKeys("Москва");
        Thread.sleep(DELAY);
        driver.findElement(By.xpath("//input[@class='search_input'][1]")).sendKeys(Keys.RETURN);
        Thread.sleep(DELAY);

        driver.findElement(By.xpath("//section[@class='catalog_block'][2]//div[@class='catalog_item'][1]/a[@class='catalog_link link blue fontM'][1]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/weather-moscow-4368/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
