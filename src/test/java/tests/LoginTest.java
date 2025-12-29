package tests;

import base.BaseTest;
import config.Config;
import org.junit.jupiter.api.Test;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void shouldLoginSuccessfully() {
        LoginPage loginPage = new LoginPage();
        InventoryPage inventory = new InventoryPage();

        loginPage.open();
        loginPage.login(Config.stadardUser(), Config.standardPassword());

        assertTrue(inventory.isCartDisplayed());
    }

    @Test
    void shouldShowErrorForInvalidLogin() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.login("wrong_user", "wrong_pass");

        assertTrue(loginPage.getErrorMessage()
                .contains("Username and password do not match"));
    }

}
