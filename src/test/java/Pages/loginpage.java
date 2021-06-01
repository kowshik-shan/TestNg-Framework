package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver driver;
	public loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@id='username']")
	public WebElement Username;
	
	@FindBy(xpath = "//input[@id='password']")
	public WebElement Password;
	
	@FindBy(xpath = "//input[@id='Login']")
	public WebElement Login;
	
	@FindBy(xpath = "//*[@id='error']")
	public WebElement Errormsg;
	
	@FindBy(id = "rememberUn")
	public WebElement RememberMe;
	
	@FindBy(xpath = "//*[@id='userNavLabel']")
	public WebElement Usermenu;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[5]")
	public WebElement Logout;
	
	@FindBy (id = "forgot_password_link")
	public WebElement ForgotPassword;
	
	@FindBy (id = "un")
	public WebElement Forgotusername;
	
	@FindBy(id = "continue")
	public WebElement Continue;
	
	@FindBy (id = "//h2[@id='header']")
	public WebElement Header;
	
	@FindBy (xpath = "//div[@id='error']")
	public WebElement Error;
	
	
	
	
			
}
