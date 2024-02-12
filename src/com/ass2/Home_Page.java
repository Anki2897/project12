package com.ass2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Home_Page {
	WebDriver driver ;
	//String baseUrl = "https://sakshingp.github.io/assignment/login.html";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
   @Test
	    public void testTransactionTableSorting() {
	        driver.get("https://sakshingp.github.io/assignment/login.html");

	        WebElement usernameInput = driver.findElement(By.id("username"));
	        WebElement passwordInput = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.id("log-in"));

	        usernameInput.sendKeys("Ankita2805");
	        passwordInput.sendKeys("anki@2897");
	        loginButton.click();

	      
	        WebElement amountHeader = driver.findElement(By.xpath("//*[@id=\"amount\"]"));
	        amountHeader.click();

	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class, 'table table-padded')]")));	        List<WebElement> sortedAmountValues = driver.findElements(By.xpath("//table[contains(@class, 'table table-padded')]/tbody/tr[1]/td[5]"));
	        boolean isSorted = true;
	        double previousAmount = Double.MIN_VALUE;
	        for (WebElement amount : sortedAmountValues) {
	            double currentAmount = Double.parseDouble(amount.getText().replaceAll("[^0-9.]", ""));
	            if (currentAmount < previousAmount) {
	                isSorted = false;
	                break;
	            }
	            previousAmount = currentAmount;
	        }

	        Assert.assertTrue(isSorted, "Transaction amounts are not sorted correctly.");
	    }

	

}
