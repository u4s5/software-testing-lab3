package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DefaultLocationSetter {

    public static void setDefaultLocation(WebDriver driver, long DELAY) throws Exception {
        driver.findElement(By.xpath("//a[@class='link blue no_border'][1]")).click();
        Thread.sleep(DELAY);

        List<WebElement> elements = driver.findElements(By.name("currentgeo"));
        elements.get(2).click();
        Thread.sleep(DELAY);
        driver.findElement(By.xpath("//input[@class='search_input'][1]")).sendKeys("Санкт-Петербург");
        Thread.sleep(DELAY);

        driver.findElement(By.xpath("//input[@class='search_input'][1]")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(DELAY);
        driver.findElement(By.xpath("//input[@class='search_input'][1]")).sendKeys(Keys.RETURN);
        Thread.sleep(DELAY);
    }

}
