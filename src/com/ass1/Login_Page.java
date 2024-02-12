package com.ass1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Login_Page {
	WebDriver driver;
	String baseUrl = "https://sakshingp.github.io/assignment/login.html";

	    @BeforeClass
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();

	    }

	    
	    @Test(priority = 1)
	    public void testValidUsername() {
	        driver.get(baseUrl);
	        login("Ankita2805", "anki@2897");
	        Assert.assertFalse(driver.getCurrentUrl().contains("dashboard"));
	    }
	   

	    @Test(priority = 2)
	    public void testInvalidUsername() {
	        driver.get(baseUrl);
	        login("priya567p", "anki@2897");
	        Assert.assertFalse(driver.getCurrentUrl().contains("dashboard"));
	    }

	    @Test(priority = 3)
	    public void testInvalidPassword() {
	        driver.get(baseUrl);
	        login("Ankita2805", "am@456");
	        Assert.assertFalse(driver.getCurrentUrl().contains("dashboard"));
	    }

	    @Test(priority = 4)
	    public void testEmptyUsernameAndPassword() {
	        driver.get(baseUrl);
	        login("", "");
	        Assert.assertFalse(driver.getCurrentUrl().contains("dashboard"));
	    }

	    @Test(priority = 5)
	    public void testEmptyPassword() {
	        driver.get(baseUrl);
	        login("Ankita2805", "");
	        Assert.assertFalse(driver.getCurrentUrl().contains("dashboard"));
	    }
	    @Test(priority=6)
	    public void testEmptyUsername() {
	    	   driver.get(baseUrl);
		        login("", "anki@2897");
		        Assert.assertFalse(driver.getCurrentUrl().contains("dashboard"));
		    
	    }
	    private void login(String username, String password) {
	        WebElement usernameField = driver.findElement(By.id("username"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.id("log-in"));

	       usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	        loginButton.click();
	    }
	 
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	

}
