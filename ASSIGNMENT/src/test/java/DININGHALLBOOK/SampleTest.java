package DININGHALLBOOK;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SampleTest {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://goodtaste.fleksa.de/en");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//h2[contains(text(),'MENU')]")).click();
		WebElement dessert = driver.findElement(By.xpath("//h2[contains(text(),'Dessert')]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true);", dessert);
		WebElement add = driver.findElement(By.xpath(
				"//li[@id='683211']/descendant::div[@class='add-buttoncommontemplateOnecomponents__WrapperButton-sc-uqrp0j-0 MhqSZ']/child::button"));
		j.executeScript("arguments[0].click();", add);
		WebElement dinein = driver
				.findElement(By.xpath("//h3[@class='text-xl font-semibold' and contains(text(),'Dine-In')]"));
		WebElement checkout = driver.findElement(By.xpath("//p[contains(text(),'Checkout')]"));
		if (checkout.isDisplayed()) {
			driver.findElement(By.xpath("//p[contains(text(),'Checkout')]")).click();
		} else {
			driver.findElement(By.xpath("//h3[@class='text-xl font-semibold' and contains(text(),'Dine-In')]")).click();
			driver.findElement(By.xpath("//p[contains(text(),'Checkout')]")).click();
		}
		driver.findElement(By.xpath("//input[@class='edit-input' and @placeholder='Name']")).sendKeys("Mahesh Babu");
		driver.findElement(By.xpath("//input[@class='edit-input' and @placeholder='Email']"))
				.sendKeys("findmybugsqa@gmail.com");
		Actions ac = new Actions(driver);

		WebElement flag = driver.findElement(By.xpath("//div[@class='flag de']"));
		ac.click(flag).build().perform();

		WebElement code = driver.findElement(By.xpath(
				"//ul[@class='country-list ']/child::li[@class='country']/child::span[@class='dial-code'and contains(text(),'+91')]"));
		code.click();
		driver.findElement(By.xpath("//input[@class='form-control phone-input-style']")).sendKeys("8801356471");
		Thread.sleep(3000);
		WebElement edit = driver
				.findElement(By.xpath("//span[@class='font-semibold']/following::div[@class='edit-btn'][1]"));
		j.executeScript("arguments[0].click();", edit);
		WebElement date = driver
				.findElement(By.xpath("//p[.='Select date']/following-sibling::div/descendant::button"));
		date.click();
		driver.findElement(By.xpath("//div[@class='relative mt-1']/child::ul/child::li[3]")).click();
		WebElement time = driver
				.findElement(By.xpath("//p[.='Select time']/following-sibling::div/descendant::button"));
		time.click();
		driver.findElement(By.xpath("//div[@class='relative mt-1']/child::ul/child::li[5]")).click();
		driver.findElement(By.xpath("//button[.='CONFIRM']")).click();
		driver.findElement(By.xpath(
				"//span[@class='icon-visa-credit-card px-2 border hover:border-2 hover:shadow-3xl transition-all duration-300 rounded-lg ']"))
				.click();
		WebElement orderpay = driver
				.findElement(By.xpath("//div[@class='fixed left-0 sab right-0 p-2 bg-transparent sm:relative']"));
		j.executeScript("arguments[0].scrollIntoView(true);", orderpay);

		driver.quit();

	}

}
