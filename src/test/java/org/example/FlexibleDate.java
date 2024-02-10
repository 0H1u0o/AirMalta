package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;



public class FlexibleDate extends PreRequisites{
    String flexibleDateUrl = "https://book.airmalta.com/calendar/outbound";
    public void navigateToFlexibleDate() throws InterruptedException {
        WebElement clickFlexibleDateButton = driver.findElement(By.cssSelector("a[class=\"LinkUI__Link-cgZPLA gFvwyZ\"]"));
        clickFlexibleDateButton.click();

        Thread.sleep(2000);

    }

}
