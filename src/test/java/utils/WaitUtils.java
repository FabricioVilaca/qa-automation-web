package utils;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private WaitUtils() {}

    public static WebElement waitForVisibility(By locator) {
        WebDriverWait wait =
                new WebDriverWait(DriverFactory.getDriver(),
                        Duration.ofSeconds(Config.TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {
        WebDriverWait wait =
                new WebDriverWait(DriverFactory.getDriver(),
                        Duration.ofSeconds(Config.TIMEOUT));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
