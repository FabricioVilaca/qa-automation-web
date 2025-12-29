package pages;

import config.Config;
import config.ConfigLoader;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;
import utils.DriverFactory;
import utils.WaitUtils;

@Slf4j
public class LoginPage extends BaseTest {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public void open() {
        log.info("Opening login page");
        DriverFactory.getDriver().get(Config.BASE_URL);
    }

    public void login(String user, String pass) {
        log.info("Logging in with user: {}", user);
        WaitUtils.waitForVisibility(username).sendKeys(user);
        WaitUtils.waitForVisibility(password).sendKeys(pass);
        WaitUtils.waitForClickable(loginButton).click();
    }

    public void loginAsStandardUser() {
        login(
                ConfigLoader.get("user.standard"),
                ConfigLoader.get("user.password")
        );
    }

    public String getErrorMessage() {
        return WaitUtils.waitForVisibility(errorMessage).getText();
    }

}
