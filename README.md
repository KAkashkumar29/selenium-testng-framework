# E-Commerce Test Automation Framework

An end-to-end UI automation testing framework built using Java, Selenium WebDriver, and TestNG, implementing the Page Object Model (POM) architectural design pattern.

## Tech Stack & Tools
* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build & Dependency Management:** Maven
* **Design Pattern:** Page Object Model (POM)
* **Data-Driven:** JSON data parsing (Jackson Databind)
* **Reporting:** TestNG Reports & ExtentReports

## Key Architectural Features
* **Page Object Model:** Decoupled page elements and actions from test logic for maintainability.
* **Component Reusability:** Inherited wait utilities and header navigations via `AbstractComponent`.
* **Data-Driven Execution:** Externalized test datasets via `PurchaseOrder.json`.
* **Isolated XML Test Runners:** Configured dedicated test suites for error validation and smoke purchasing workflows.

## How to Run Tests

### Run via TestNG XML Suite:
Right-click `testSuites/testng.xml` -> **Run As** -> **TestNG Suite**

### Run via Maven CLI:
```bash
mvn clean test
