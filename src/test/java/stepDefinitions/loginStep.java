package stepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;

import pageObjects.loginPage;

import utilities.excel;


public class loginStep {
	
	
	public WebDriver driver;
	
	public loginPage lp;
	excel read = new excel();
	
	
	@Given("user launches the firefox browser")
	
	public void user_launches_the_firefox_browser() throws IOException {
		
  System.setProperty("webdriver.firefox.driver", "C://Users//nveenrm//eclipse-workspace//testSBNetwork//Drivers//geckodriver.exe");
		
		driver = new FirefoxDriver();
		loginPage lp = new loginPage(driver);
	}

	@Given("user gives url")
	public void user_gives_url() {
	
		driver.get("https://test.smartblacknetwork.com");
	}

	@When("user gives the username and password")
	public void user_gives_the_username_and_password(String username, String password) {
	

		lp.giveUsername(username);
		lp.givePassword(password);
	  
	}

		
	@Then("user clicks the login button")
	public void user_clicks_the_login_button() {
		
     lp.clickLogin();
	}

	@And("user will create new post by clicking create option")
	public void user_will_create_new_post_by_clicking_create_option() {
		
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		lp.createPost();
	    
	}

	@When("user gives title, description and tag")
	public void user_gives_title_description_and_tag(String title,String description, String tag) {
		
		lp.postTitle(title);
		lp.postDescription(description);
		lp.postTag(tag);
	    
	}

	@Then("user uploads pics and videos")
	public void user_uploads_pics_and_videos(String filePath) throws InterruptedException  {
		
		lp.uploadInPost(filePath);
	   
	}

	@Then("user will post the selected pics and videos")
	public void user_will_post_the_selected_pics_and_videos() throws InterruptedException {
		
		
		lp.postPost();
		
	   
	}

	@Then("verifying the uploaded post")
	public void verifying_the_uploaded_post() throws IOException, InterruptedException {
		
		lp.validatePost();
	    
	}

	@Then("user logsout and closes the browser")
	public void user_logsout_and_closes_the_browser() {
		
		lp.logOut();
	    
	}


}
