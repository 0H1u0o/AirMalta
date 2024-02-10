"# AirMalta" 
# AirMalta Flight Price Retrieval

## Objective
The objective of this project is to retrieve the price of the first available flight from Vienna International Airport (VIE) to Malta International Airport (MLA) using the AirMalta airline website.

## Website Link
[AirMalta Airline Site](https://airmalta.com/)

## Method Explanation
The price can be derived from the calendar interface illustrated on the AirMalta website.

## Approach
To achieve this task, we will use Selenium WebDriver in conjunction with TestNG for automated testing. We will write test scripts in Java using IntelliJ IDEA as the development environment.

## Instructions
1. **Prerequisites**:
   - Install Java Development Kit (JDK) on your system.
   - Install IntelliJ IDEA IDE.
   - Set up Selenium WebDriver and TestNG dependencies in your IntelliJ project.

2. **Clone the Repository**:
git clone https://github.com/0H1u0o/AirMalta

3. **Open Project in IntelliJ**:
- Open IntelliJ IDEA.
- Click on `File` > `Open` and navigate to the cloned repository.
- Select the `pom.xml` file to open the project.

4. **Run TestNG.xml File with Allure**:
- Open the `TestNG.xml` file in your IntelliJ project.
- Right-click on the `TestNG.xml` file.
- Select `Run 'TestNG.xml' with Allure` to execute the test suite and generate Allure reports.

5. **View Allure Reports**:
- After running the tests, you can view the generated Allure reports by opening the terminal/command prompt.
- Navigate to the project directory.
- Run the following command:
  ```
  allure serve target/allure-results
  ```
- This will open a browser window displaying the Allure report with detailed test results and bug reports.

## Usage
After running the test suite and reviewing the Allure reports, you will have detailed insights into the test execution and any encountered bugs.


## Contact Information
For any questions or feedback regarding this project, feel free to contact me at Muhamedelghanam@gmail.com.


