package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "(//button[@type=\"submit\"])[1]")
    public WebElement letsFindOutButton;

    @FindBy(xpath = "//body/div[@id='__next']/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]/iframe[1]")
    public WebElement frame;

    @FindBy(xpath = "(//span[@class='irs-handle single'])[1]")
    public WebElement ageSlider;

    @FindBy(xpath ="(//span[@class='irs-handle single'])[2]" )
    public WebElement initialDepositAmountSlider;

    @FindBy(xpath = "(//span[@class='irs-handle single'])[3]")
    public WebElement monthlyDepositAmountSlider;

    @FindBy(xpath = "//input[@name='radioRate']")
    public List<WebElement> rateOfReturnCheckBox;

    @FindBy(xpath = "//select[@id='dpdProvince']")
    public WebElement provinceDropDown;

    @FindBy(xpath = "//*[@id='SvgjsText2045']")
    public WebElement totalValueOfResp;

    @FindBy(xpath = "//*[@id='start-saving-now-resp-calculator']")
    public WebElement startSavingNowButton;























}
