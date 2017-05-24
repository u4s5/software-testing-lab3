package firefox;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static utils.DefaultLocationSetter.setDefaultLocation;

public class GettingWeatherTests {

    private final long DELAY = 500;

    private WebDriver driver;

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
    }

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get("https://www.gismeteo.ru/");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testGettingTodayWeather() throws Exception {
        setDefaultLocation(driver, DELAY);

        assertEquals("https://www.gismeteo.ru/weather-sankt-peterburg-4079/", driver.getCurrentUrl());
    }

    @Test
    public void testGettingTomorrowWeather() throws Exception {
        setDefaultLocation(driver, DELAY);

        driver.findElement(By.xpath("//a[@class='nolink subnav_item'][1]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/weather-sankt-peterburg-4079/tomorrow/", driver.getCurrentUrl());
    }

    @Test
    public void testGetting3DaysWeather() throws Exception {
        setDefaultLocation(driver, DELAY);

        driver.findElement(By.xpath("//a[@class='nolink subnav_item'][2]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/weather-sankt-peterburg-4079/3-days/", driver.getCurrentUrl());
    }

    @Test
    public void testGetting10DaysWeather() throws Exception {
        setDefaultLocation(driver, DELAY);

        driver.findElement(By.xpath("//a[@class='nolink subnav_item'][3]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/weather-sankt-peterburg-4079/10-days/", driver.getCurrentUrl());
    }

    @Test
    public void testGetting2WeeksWeather() throws Exception {
        setDefaultLocation(driver, DELAY);

        driver.findElement(By.xpath("//a[@class='nolink subnav_item'][4]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/weather-sankt-peterburg-4079/2-weeks/", driver.getCurrentUrl());
    }

    @Test
    public void testGettingMonthWeather() throws Exception {
        setDefaultLocation(driver, DELAY);

        driver.findElement(By.xpath("//a[@class='nolink subnav_item'][5]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/weather-sankt-peterburg-4079/month/", driver.getCurrentUrl());
    }

    @Test
    public void testGettingRadar() throws Exception {
        setDefaultLocation(driver, DELAY);

        driver.findElement(By.xpath("//a[@class='nolink subnav_item'][6]")).click();
        Thread.sleep(DELAY);

        assertEquals("https://www.gismeteo.ru/nowcast-sankt-peterburg-4079/", driver.getCurrentUrl());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
