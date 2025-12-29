package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import tests.BaseTest;
import utils.WaitUtils;

@Slf4j
public class InventoryPage extends BaseTest {

    private final By inventoryContainer = By.id("inventory_container");
    private final By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge = By.className("shopping_cart_badge");

    public boolean isCartDisplayed() {
        return WaitUtils.waitForVisibility(inventoryContainer).isDisplayed();
    }

    public void addProductToCart(String productId) {
        By addButton = By.id("add-to-cart-" + productId);
        WaitUtils.waitForClickable(addButton).click();
        log.info("Added product to cart: {}", productId);
    }

    public int getCartCount() {
        try {
            return Integer.parseInt(
                    WaitUtils.waitForVisibility(cartBadge).getText()
            );
        } catch (Exception e) {
            return 0;
        }
    }

}
