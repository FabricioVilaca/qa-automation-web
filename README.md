# QA Automation – Selenium Java Framework

QA automation project built with Selenium WebDriver, Java, and JUnit 5, and CI-ready (Jenkins).

## Tech Stack
- Java 17
- Selenium 4
- JUnit 5
- Maven
- Page Object Model (POM)
- ThreadLocal WebDriver (parallel execution ready)
- Logback (logging)
- WebDriverManager
- Chrome Headless (CI compatible)

## Project Structure
```text
Jenkinsfile
pom.xml
src
 ├── main
 │   ├── java
 │   │   ├── config
 │   │   │   └── Config.java           # Configuration keys / constants
 │   │   │   └── ConfigLoader.java     # Loads config from properties
 │   │   ├── driver
 │   │   │   └── DriverFactory.java    # ThreadLocal WebDriver
 │   │   └── utils
 │   │       └── WaitUtils.java        # Explicit waits
 │   └── resources
 │       ├── config.properties.example
 │       └── logback.xml
 │
 └── test
     └── java
         ├── base
         │   └── BaseTest.java
         ├── pages
         │   ├── LoginPage.java
         │   └── InventoryPage.java
         └── tests
             └── InventoryTest.java
```

## Configuration
This project uses an external configuration file that is not committed to Git.
Create a `config.properties` file based on the provided template:
```bash
cp src/main/resources/config.properties.example src/main/resources/config.properties
```
Then update the following properties with your own values:
```text
base.url=https://www.saucedemo.com
username=YOUR_USERNAME
password=YOUR_PASSWORD
browser=chrome
browser.headless=true
```

## Tests
   - Login tests
   - Inventory tests (parameterized)
   - Add-to-cart scenarios
   - Page Object based interactions
   - Explicit waits for stability

Run Tests Locally
```text
mvn clean test
```
Headless mode can be enabled/disabled via config.properties
Logs are printed in the console and stored in log files

## CI / Jenkins
The project is ready to run in Jenkins:
   - Headless Chrome
   - No GUI required
   - Thread-safe WebDriver
   - Maven-based execution

## Improvements
- Add Allure reporting for better test visualization and CI reporting
- Implement retry logic for flaky tests
- Enable parallel execution with JUnit 5
- Add multi-browser support (Firefox, Edge)
- Dockerize test execution for consistent CI environments
- Externalize test data (CSV / JSON)
- Integrate API tests (REST) alongside UI tests
