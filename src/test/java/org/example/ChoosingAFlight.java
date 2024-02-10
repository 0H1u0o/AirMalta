package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ChoosingAFlight extends PreRequisites {
    String departingAirport = "Vienna International";
    String arrivalAirPort = "Malta International Airport";

    String findFlightUrl = "https://book.airmalta.com/flights/outbound";
    public void choosingAFlight() throws InterruptedException { // Method for choosing a flight

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initializing WebDriverWait
        WebElement departingFrom = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"flight-search-widget\"]/div/div/form/div[2]/div[1]/div[1]/div/div/div[1]"))); // Waiting for the departing from element to be clickable
        departingFrom.click(); // Clicking on departing from element

        // Finding and selecting departing airport
        WebElement departing = driver.findElement(By.cssSelector("input[class=\"form-control airport-search-input\"]"));
        departing.sendKeys(departingAirport);
        WebElement selectVienna = driver.findElement(By.xpath("//*[@id=\"flight-search-widget\"]/div/div/form/div[2]/div[1]/div[1]/div/div/div[2]/div/div[2]/div[1]"));
        selectVienna.click();
        // Verifying the selected departing airport
        String selectedDepartingAirPort = driver.findElement(By.xpath("//*[@id=\"flight-search-widget\"]/div/div/form/div[2]/div[1]/div[1]/div/div/div[1]")).getText();
        Assert.assertEquals(selectedDepartingAirPort, departingAirport);

        // Similarly selecting arrival airport
        WebElement flyingTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"flight-search-widget\"]/div/div/form/div[2]/div[1]/div[2]/div/div/div[1]")));
        flyingTo.click();
        WebElement flying = driver.findElement(By.cssSelector("input[class=\"form-control airport-search-input\"]"));
        flying.sendKeys(arrivalAirPort);
        WebElement selectMalta = driver.findElement(By.xpath("//*[@id=\"flight-search-widget\"]/div/div/form/div[2]/div[1]/div[2]/div/div/div[2]/div/div[2]/div[1]"));
        selectMalta.click();
        String selectedArrivalAirPort = driver.findElement(By.xpath("//*[@id=\"flight-search-widget\"]/div/div/form/div[2]/div[1]/div[2]/div/div/div[1]")).getText();
        Assert.assertEquals(selectedArrivalAirPort, arrivalAirPort);

        // Clicking on departure date element
        WebElement clickDeparture = driver.findElement(By.xpath("//*[@id=\"flight-search-widget\"]/div/div/form/div[2]/div[2]/div[1]/div/div/div[1]/input"));
        clickDeparture.click();

        // Finding and selecting departure date
        Thread.sleep(2000);
        WebElement calendar = driver.findElement(By.xpath("//*[@id=\"flight-search-widget\"]/div/div/form/div[2]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/div[1]/div/div[2]"));
        // Finding all the date elements within the calendar
        // Modify the XPath according to your calendar structure
        // This XPath assumes each date element has a specific class or tag name
        // Adjust it based on your HTML structure
        // For example: "//div[@class='calendar-day']"
        // Or: "//td[@class='day']"
        // Or any other suitable XPath
        Thread.sleep(1000);
        java.util.List<WebElement> dateElements = calendar.findElements(By.xpath(".//div[@role='gridcell' and @aria-disabled='false']"));

        WebElement departureDateElement = null;
        // Iterate through the date elements to find the first available date
        for (WebElement dateElement : dateElements) {
            String dateText = dateElement.getText();
            if (dateText.equals("1")) { // Assuming '1' is the departure date, update it as needed
                departureDateElement = dateElement;
                break;
            }
        }

        // If departure date found, select the next available return date
        if (departureDateElement != null) {
            // Calculate the departure date
            int departureDate = Integer.parseInt(departureDateElement.getText());

            // Iterate through the remaining date elements to find the next available return date
            for (WebElement dateElement : dateElements) {
                String dateText = dateElement.getText();
                dateElement.click(); // Clicking on the date element
                Thread.sleep(2000);
                String numericPart = dateText.replaceAll("[^0-9]+.*", "");
                int currentDate = Integer.parseInt(numericPart);
                System.out.println(currentDate + "-" + departureDate);
                break;
                // Check if the current date is after the departure date and is available
            }

            int index = 0;
            int returnDate = 0;
            java.util.List<WebElement> dateElementstwo = driver.findElements(By.xpath(".//div[@role='gridcell' and @aria-disabled='false']//div[@class='date-picker-day-cell']//div[@class='calendar-day']"));
            for (WebElement dateElementTwo : dateElementstwo) {
                System.out.println(dateElementTwo.getText());
                if (index == 1) {
                    returnDate = Integer.parseInt(dateElementTwo.getText());
                    break;
                }
                index++;
                System.out.println(returnDate);
            }
            // Selecting return date
            String selectionXPath = ".//div[@role='gridcell' and @aria-disabled='false']//div[@class='date-picker-day-cell']//div[@class='calendar-day' and text()='{return_date}']".replace("{return_date}", String.valueOf(returnDate));
            WebElement returnDateSelection = driver.findElement(By.xpath(selectionXPath));
            returnDateSelection.click();
        }

        // Clicking on find flight button
        WebElement clickFindFlight = driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-lg d-none d-md-block\"]"));
        clickFindFlight.click();

        Thread.sleep(5000);
    }
}
