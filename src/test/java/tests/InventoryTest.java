package tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class InventoryTest extends BaseTest {

    static Stream<String> productProvider() {
        return Stream.of(
                "sauce-labs-backpack",
                "sauce-labs-bike-light",
                "sauce-labs-bolt-t-shirt"
        );
    }

    @ParameterizedTest
    @MethodSource("productProvider")
    void shouldAddProductToCart(String productId) {
        log.info("Testing add to cart for product: {}", productId);

        LoginPage login = new LoginPage();
        InventoryPage inventory = new InventoryPage();

        try {
            login.open();
            login.loginAsStandardUser();
            log.info("Login successful");

            inventory.addProductToCart(productId);
            log.info("Product added to cart: {}", productId);

            int count = inventory.getCartCount();
            log.info("Cart count after adding: {}", count);

            if (count != 1) {
                throw new AssertionError(
                        "Expected cart count 1, but got " + count +
                                " for product: " + productId
                );
            }

        } catch (Exception e) {
            log.error("Test failed for product: {}", productId);
            log.error(e.getMessage());
            throw e;
        }

        log.info("=== Test finished for product: {} ===", productId);
    }

}
