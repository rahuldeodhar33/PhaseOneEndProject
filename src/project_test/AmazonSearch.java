package project_test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		WebElement searchTxt = driver.findElement(By.xpath("//input[@name='field-keywords']"));
		searchTxt.sendKeys("iPhone 12");
		WebElement search = driver.findElement(By.xpath("//input[@type='submit']"));
		search.click();
		//To search the phones
		List<WebElement> product = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		//System.out.println("Number of results found : " + product.size());
		//To search the prices
		List<WebElement> prx = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<prx.size();i++) {
			//System.out.println(product.get(i).getText());
			
			if (product.get(i).getText().contains("iPhone 12")) {
				//System.out.println("============"); not required
				map.put(product.get(i).getText(), prx.get(i).getText());
				
			}
		}
		int count = 1;
		for(Map.Entry<String, String> entry1:map.entrySet()) {
			System.out.println("=========================================");
			System.out.print("No.");
			System.out.print("("+count+")");
			count = count + 1;
			System.out.println(entry1.getKey() + " = " + entry1.getValue());
			//counter++;
		}
		//count = count - 1;
		System.out.println("Total " + count + " iPhone 12 found in seach reasuts.");
		System.out.println("Keep Shopping iPhone.");
		driver.close();
	}
	
}
