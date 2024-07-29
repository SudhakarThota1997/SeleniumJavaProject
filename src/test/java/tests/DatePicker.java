package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {
		String date = "24", month = "September", year = "2028";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		
		driver.switchTo().frame(0);

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		while (true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (currentMonth.equals(month) && currentYear.equals(year)) {
				List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td/a"));
				for (WebElement cDate : dates) {
					String currentDate = cDate.getText();
					if (currentDate.equals(date)) {
						cDate.click();
						break;
					}
				}
				break;
			}
			driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		}
	}
}
