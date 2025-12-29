package base;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import driver.DriverFactory;

@Slf4j
public class BaseTest {

    @BeforeEach
    void setUp() {
        log.info("Starting test");
        DriverFactory.getDriver();
    }

    @AfterEach
    void tearDown() {
        log.info("Ending test");
        DriverFactory.quitDriver();
    }

}
