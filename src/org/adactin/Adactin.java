package org.adactin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Adactin {
	
	WebDriver driver;
	Select s;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\AdactinHotelProject\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://adactin.com/HotelApp/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	
	@Test
	@Parameters({"Username", "Password"})
	public void loginForm(String user, String pass) {
		
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login")).click();

	}
	
	@Test
	public void searchHotel() throws InterruptedException, AWTException {
		
		WebElement loc = driver.findElement(By.id("location"));
		s = new Select(loc);
		Thread.sleep(2000);
		s.selectByValue("Melbourne");
		
		WebElement hotel = driver.findElement(By.id("hotels"));
		s = new Select(hotel);
		s.selectByValue("Hotel Hervey");
		
		WebElement roomType = driver.findElement(By.id("room_type"));
		s = new Select(roomType);
		s.selectByValue("Deluxe");
		
		WebElement noOfRooms = driver.findElement(By.id("room_nos"));
		s = new Select(noOfRooms);
		s.selectByValue("4");
		
		WebElement inDate = driver.findElement(By.id("datepick_in"));
		inDate.clear();
		inDate.sendKeys("25/02/2020");
		
		WebElement outDate = driver.findElement(By.id("datepick_out"));
		outDate.clear();
		outDate.sendKeys("30/02/2020");
		
		WebElement noOfAdults = driver.findElement(By.id("adult_room"));
		s = new Select(noOfAdults);
		s.selectByValue("2");
		
		WebElement noOfKids = driver.findElement(By.id("child_room"));
		s = new Select(noOfKids);
		s.selectByValue("1");
		
		driver.findElement(By.id("Submit")).click();

	}
	
	@Test
	public void selectHotel() throws InterruptedException {
		
		Thread.sleep(2000);	
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();

	}
	
	@Test
	public void bookHotel() {
		
		driver.findElement(By.id("first_name")).sendKeys("Karthick");
		driver.findElement(By.id("last_name")).sendKeys("JK");
		driver.findElement(By.id("address")).sendKeys("Chennai");
		driver.findElement(By.id("cc_num")).sendKeys("cc_num");
		WebElement ccType = driver.findElement(By.id("cc_type"));
		s = new Select(ccType);
		s.selectByValue("VISA");
		WebElement expMonth = driver.findElement(By.id("cc_exp_month"));
		s = new Select(expMonth);
		s.selectByValue("5");
		WebElement expYear = driver.findElement(By.id("cc_exp_year"));
		s = new Select(expYear);
		s.selectByValue("2022");
		driver.findElement(By.id("cc_cvv")).sendKeys("123");
		driver.findElement(By.id("book_now")).click();

	}
	
	@AfterClass
	public void login() throws AWTException {
		
		System.out.println("Finished Booking");

	}

}
