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

public class GettingWeatherTests {

    private final long DELAY = 500;

    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.gismeteo.ru";
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testGettingTodayWeather() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a[@class='nolink subnav_item'][1]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/weather-moscow-4368/", driver.getCurrentUrl());
    }

    @Test
    public void testGettingTomorrowWeather() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a[@class='nolink subnav_item'][2]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/weather-moscow-4368/tomorrow/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
