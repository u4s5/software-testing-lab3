package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DefaultLocationSetter {

    public static void setDefaultLocation(WebDriver driver, long DELAY) throws Exception {
        driver.findElement(By.xpath("//a[@class='link blue no_border'][1]")).click();
        Thread.sleep(DELAY);

        driver.findElement(By.xpath("//div[@class='currentgeo_description'][1]")).click();
        Thread.sleep(DELAY);

        driver.findElement(By.xpath("//input[@class='search_input'][1]")).sendKeys("Санкт-Петербург");
        Thread.sleep(DELAY);

        driver.navigate().to("https://www.gismeteo.ru/search/Санкт-Петербург/");
        Thread.sleep(DELAY);

        driver.findElement(By.xpath("//section[@class='catalog_block'][2]//div[@class='catalog_item'][1]/a[@class='catalog_link link blue fontM'][1]")).click();
        Thread.sleep(DELAY);
    }

}
