package pageObjects;

import java.io.File;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


public class loginPage  {

	public WebDriver rdriver;
	 
	
	public loginPage(WebDriver ldriver) {
		
		rdriver = ldriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	@FindBy (how=How.XPATH, using="//input[@type='email']")
	@CacheLookup
	public WebElement username;
	
	
	@FindBy (how=How.XPATH, using="//input[@type='password']")
	@CacheLookup
	public WebElement password;
	
	@FindBy (how=How.XPATH, using="//button[@type='submit']")
	public WebElement login;
	
	@FindBy (how=How.XPATH, using="/html[1]/body[1]/app-root[1]/app-app-layout[1]/div[1]/aside[1]/app-sidemenu[1]/aside[1]/app-sidemenu-header[1]/ul[1]/li[2]/app-post-button-modal[1]/button[1]")
	                                
	public WebElement clickCreate;
	
	@FindBy (how=How.XPATH, using="//div[@class='d-flex mb-3']//textarea[@type='text']")
	
	public WebElement giveTitle;
	
	@FindBy (how=How.XPATH, using = "//textarea[@class='form-control border-0 post-desc ng-untouched ng-pristine ng-valid']")
	
	public WebElement giveDescription;
	
	@FindBy (how=How.XPATH, using="//div[@class='form-group mb-2']//textarea[@type='text']")
	
	public WebElement giveTag;
	
	@FindBy (how=How.XPATH, using="//input[@type='file']")
	
	public WebElement uploadPic;
	
	@FindBy (how=How.XPATH, using= "/html[1]/body[1]/modal-container[1]/div[1]/div[1]/div[2]/form[1]/div[7]/div[1]/div[1]/button[1]")
	
	public WebElement clickPost;
	
	@FindBy (how=How.XPATH, using="/html[1]/body[1]/app-root[1]/app-app-layout[1]/div[1]/section[1]/app-feed[1]/section[1]/div[1]/div[1]/app-feed-post[1]/div[2]/div[1]/div[3]/div[2]/p[1]")
	
	public WebElement scrollPost;
	
	
	public void giveUsername(String uName) {
		
		username.sendKeys(uName);
		
	}
	
	public void givePassword(String pwd) {
		
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public void createPost() {
		
		clickCreate.click();
	}
	
public void postTitle(String title) {
		
		giveTitle.sendKeys();
		
	}

public void postDescription(String description) {
	
	giveDescription.sendKeys(description);
	
}

public void postTag(String tag) {
	
	giveTag.sendKeys(tag);
}

public void uploadInPost(String FilePath) throws InterruptedException  {
	
	Thread.sleep(3000);

	uploadPic.sendKeys(FilePath);
	
}


public void postPost() throws InterruptedException {
	
	Thread.sleep(5000);
	
	rdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	clickPost.click();
}

public void validatePost() throws IOException, InterruptedException {
	
	JavascriptExecutor js = (JavascriptExecutor) rdriver;
	
	SoftAssert verify = new SoftAssert();
	
	if(rdriver.getPageSource().contains("Post has been Created Successfully")) {
		
		verify.assertTrue(true);
		System.out.println("Post has been Created Successfully");
		
	}else {
		verify.assertTrue(false);
		
	}

	Thread.sleep(3000); 
	
js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

File image = ((TakesScreenshot) rdriver).getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(image , new File("C:\\Users\\nveenrm\\eclipse-workspace\\testSBNetwork\\Screenshots\\UploadedPost1.png"));
}

	
	public void logOut() {
		rdriver.close();
	}

}
