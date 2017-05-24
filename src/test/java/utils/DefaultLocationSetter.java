package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DefaultLocationSetter {

    public static void setDefaultLocation(WebDriver driver, long DELAY) throws Exception {
        driver.navigate().to("https://www.gismeteo.ru/search/Санкт-Петербург/");
        Thread.sleep(DELAY);

        driver.findElement(By.xpath("//section[@class='catalog_block'][2]//div[@class='catalog_item'][1]/a[@class='catalog_link link blue fontM'][1]")).click();
        Thread.sleep(DELAY);
    }

}
