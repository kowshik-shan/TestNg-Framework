package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMenupage {
	WebDriver driver;
	public UserMenupage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy (xpath = "//*[@id='userNavLabel']")
	public WebElement Usermenu;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[1]")
	public WebElement MyProfile;
	
	@FindBy(xpath = "//*[@id='tailBreadcrumbNode']")
	public WebElement Contact;
	
	@FindBy(xpath = "//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img")
	public WebElement EditProfile;
	
	@FindBy(xpath = "//iframe[@id='contactInfoContentId']")
	public WebElement iFrame;
	
	@FindBy(xpath = "//*[@id='aboutTab']/a")
	public WebElement AboutTab;
	
	@FindBy(xpath = "//*[@id='lastName']")
	public WebElement Lastname;
	
	@FindBy(xpath = "//*[@id='TabPanel']/div/div[2]/form/div/input[1]")
	public WebElement SaveAll;
	
	@FindBy(id = "tailBreadcrumbNode")
	public WebElement Header;
	
	@FindBy(xpath = "//body/div[@id='contactInfo']/div[1]/div[1]")
	public WebElement abouttabHeader;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")
	public WebElement Post;
	
	/*@FindBy(xpath = "//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
	public WebElement Post_iFrame;*/
	
	/*@FindBy(xpath = "//*[@id='cke_39_contents']/iframe")
	public WebElement Post_iFrame;*/
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/iframe[1]")
	public WebElement Post_iFrame;
	
	@FindBy(xpath = "/html/body")
	public WebElement Message;
	
	/*@FindBy(xpath = "//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
	public WebElement Message;*/
	
	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement Share;
	
	@FindBy(xpath ="(//p[contains(text(),'Hello world')][1])")
	public WebElement PostDisplay; 
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")
	public WebElement File;
	
	@FindBy(xpath = "//a[@id='chatterUploadFileAction']")
	public WebElement Upload;
	
	@FindBy(xpath = "//input[@id='chatterFile']")
	public WebElement File_Choose;
	
	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement File_Share;
	
	@FindBy(id = "displayBadge")
	public WebElement Photo;
	
	@FindBy(xpath = "//a[@id='uploadLink']")
	public WebElement AddPhotoLink;
	
	@FindBy(xpath = "//iframe[@id='uploadPhotoContentId']")
	public WebElement Photo_iFrame;
	
	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadInputFile']")
	public WebElement Photo_Choose;
	
	@FindBy(xpath = "//*[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement Photo_Save;
	
	@FindBy(xpath = "//*[@id='j_id0:j_id7:save']")
	public WebElement Photo_Save1;
	
	@FindBy(xpath = "//*[@id=\"userNav-menuItems\"]/a[2]")
	public WebElement MySettings;
	
	@FindBy(id = "PersonalInfo_font")
	public WebElement Personal;
	
	@FindBy(id = "LoginHistory_font")
	public WebElement LoginHistory;
	
	@FindBy(xpath = "//*[@id='RelatedUserLoginHistoryList_body']/div/a")
	public WebElement Download;
	
	@FindBy(id = "DisplayAndLayout_font")
	public WebElement Display;
	
	@FindBy(xpath = "//span[@id='CustomizeTabs_font']")
	public WebElement MyTab;
	
	@FindBy(xpath = "//*[@id='p4']")
	public WebElement CustomApp;
	
	@FindBy(xpath = "//*[@id='duel_select_0']")
	public WebElement AvailableTabs;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/div[2]/a[1]/img[1]")
	public WebElement Add_MyTabs;
	
	@FindBy(xpath = "//*[@id='bottomButtonRow']/input[1]")
	public WebElement Save_MyTabs;
	
	@FindBy(id = "EmailSetup_font")
	public WebElement Email;
	
	@FindBy(xpath = "//span[@id='EmailSettings_font']")
	public WebElement MyEmail;
	
	@FindBy(xpath = "//input[@id='sender_name']")
	public WebElement EmailName;
	
	@FindBy(xpath = "//input[@id='sender_email']")
	public WebElement EmailAddress;
	
	@FindBy(xpath = "//*[@id='auto_bcc1']")
	public WebElement RadioButton;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/input[1]")
	public WebElement Save_MyEmail;
	
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement Calendar;
	
	@FindBy(xpath = "//span[@id='Reminders_font']")
	public WebElement Activity;
	
	@FindBy(xpath = "//input[@id='testbtn']")
	public WebElement TestRemainder;
	
	@FindBy(xpath = "//a[contains(text(),'Reports')]")
	public WebElement Reports;
	
	@FindBy(xpath = "//div[@id='meSaveCompleteMessage']")
	public WebElement SuccessMsg;
	
	@FindBy(xpath = "//a[contains(text(),'Developer Console')]")
	public WebElement DeveloperConsole;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	public WebElement Logout;
	
	@FindBy(xpath = "//*[@id=\"duel\"]/table/tbody/tr/td[3]/div/label")
	public WebElement SelectedTabs;
	
	@FindBy(xpath = "//*[@id=\"duel_select_0_left\"]/img")
	public WebElement Remove;
	
	@FindBy(xpath = "(//span[contains(text(),'MyFirstFile')])[1]")
	public WebElement File_Post;
	
	
	
	
	
	
	
	
	
}

