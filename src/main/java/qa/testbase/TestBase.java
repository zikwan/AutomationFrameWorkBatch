package qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\admin\\eclipse2-workspace\\AutomationFrameWorkBatch\\src\\main\\java\\qa\\config\\config.properties");
		prop = new Properties();
		prop.load(file);
		
		}
	catch(Exception e) {
		e.printStackTrace();
	}
		
}
	
	
	public void initilization() {
		String BrowserName = prop.getProperty("browser");
		if (BrowserName.contains("chrome")){
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\software testing\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
		else if (BrowserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else if (BrowserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		else {
			System.out.println("Please select valid browser name");
		}
		
		
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		//driver.get("website");
		driver.get(prop.getProperty("website"));
	
	
	}
	

}
