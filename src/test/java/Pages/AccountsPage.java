package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
	WebDriver driver;
	
	public AccountsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//*[@id='Account_Tab']/a")
	public WebElement Account;
	
	@FindBy(xpath = "//select[@id='fcf']")
	public WebElement View;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/input[1]")
	public WebElement New;
	
	@FindBy(xpath = "//input[@id='acc2']")
	public WebElement AccountName;
	
	@FindBy(xpath = "//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	public WebElement Save_Accounts;
	
	@FindBy(xpath = "//h2[contains(text(),'AWS')]")
	public WebElement NewAccHeader;
	
	@FindBy(xpath = "//a[contains(text(),'Create New View')]")
	public WebElement NewView;
	
	@FindBy(xpath = "//input[@id='fname']")
	public WebElement ViewName;
	
	@FindBy(xpath = "//input[@id='devname']")
	public WebElement ViewUniqueName;
	
	@FindBy(xpath = "//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]")
	public WebElement Save_NewView;
	
	@FindBy(xpath = "(//select[contains(@id,'00B5e00')])[1]")
	public WebElement NewViewAccName;
	
	@FindBy(xpath ="//*[@id='userNavLabel']")
	public WebElement Usermenu;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/div[2]/form[1]/div[1]/span[1]/span[2]/a[1]")
	public WebElement Edit;
	
	@FindBy(xpath = "//select[@id='fcol1']")
	public WebElement Field;
	
	@FindBy(xpath = "//select[@id='fop1']")
	public WebElement Operator;
	
	@FindBy(xpath = "//input[@id='fval1']")
	public WebElement Value;
	
	@FindBy(xpath = "//select[@id='colselector_select_0']")
	public WebElement AvailableFields;
	
	@FindBy(xpath = "//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[2]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/a[1]/img[1]")
	public WebElement Add;		
	
	@FindBy(xpath = "//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	public WebElement Save_EditView;
	
	@FindBy(xpath = "(//select[contains(@id,'00B5e00')])[1]")
	public WebElement ViewBar;
	
	@FindBy(xpath = "//*[@id='ext-gen22']")
	public WebElement LastActivity;
	
	

}
