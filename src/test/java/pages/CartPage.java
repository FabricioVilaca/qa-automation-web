package pages;

import org.openqa.selenium.By;
import utils.WaitUtils;

public class CartPage {

    private final By cartLink = By.className("shopping_cart_link");
    private final By checkoutButton = By.id("checkout");

    public void open() {
        WaitUtils.waitForClickable(cartLink).click();
    }

    public void checkout() {
        WaitUtils.waitForClickable(checkoutButton).click();
    }
}
