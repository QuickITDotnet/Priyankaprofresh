package StepDefination;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepData {
	WebDriver driver;
	@Given("^open browser And Enter URL$")
	public void open_browser_And_Enter_URL() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium_Evening_19_Nov\\jars\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://profresh.flowers/");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		
		
		WebElement closepopup = driver.findElement(By.xpath("//*[@id=\"promocode_pop_up\"]/div[1]"));
		/*Actions act = new Actions(driver);
		act.moveToElement(closepopup).build().perform();
		closepopup.click();*/
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", closepopup);
	}

	@Given("^move mouse to Login$")
	public void move_mouse_to_Login() throws Throwable {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@id='loginID']")).click();
	}

	@When("^I enter valid username and password for Login$")
	public void i_enter_valid_username_and_password_for_Login(DataTable Credentials) throws Throwable {
		for(Map<String, String> data:Credentials.asMaps(String.class, String.class)){
		 System.out.println(data);
		
			 driver.findElement(By.xpath("//div[@id='loginPopupDiv']//input[@id='email']")).sendKeys(data.get("username"));
			 driver.findElement(By.xpath("//div[@id='loginPopupDiv']//input[@id='pass']")).sendKeys(data.get("password"));
		 }
	}

	@Then("^I can able to Login successfully$")
	public void i_can_able_to_Login_successfully() throws Throwable {
		System.out.println("User is successfully logged in");
	}

	@Given("^Click on Account Information tab and update the contact details$")
	public void click_on_Account_Information_tab_and_update_the_contact_details() throws Throwable {
		driver.findElement(By.xpath("//a[@title='Account Information']")).click();
	}

	@When("^I update the$")
	public void i_update_the(DataTable data) throws Throwable {
	 for(  Map<String, String> accountdata : data.asMaps(String.class, String.class)) {
		 driver.findElement(By.xpath("//input[@id='profresh_mobilenumber']")).clear();
			driver.findElement(By.xpath("//input[@id='profresh_mobilenumber']")).sendKeys(accountdata.get("mobile_number"));
			driver.findElement(By.id("profresh_company_website")).clear();
			driver.findElement(By.id("profresh_company_website")).sendKeys(accountdata.get("company website"));
			driver.findElement(By.id("profresh_company_instagram")).clear();
			driver.findElement(By.id("profresh_company_instagram")).sendKeys(accountdata.get("Insta ID"));
			
	 }
	   
	}

	@Then("^click on save button$")
	public void click_on_save_button() throws Throwable {
		driver.findElement(By.xpath("//div[@id='forEditAccount']//button[@title='Save']")).click();
	}

	@Then("^Contact details successfully updated\\.$")
	public void contact_details_successfully_updated() throws Throwable {
	    System.out.println("Thank you for updating user story");
	}

}
