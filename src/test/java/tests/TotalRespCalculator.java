package tests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.DashboardPage;
import utilities.BrowserUtils;
import utilities.Driver;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class TotalRespCalculator extends DashboardPage {



    @BeforeMethod
    public void browserSetUp(){

        Driver.getDriver().get(("https://knowledgefirstfinancial.ca/"));
    }



    @Test(description = "Total value of RESP")
    public void letsFindOut()  {

        //User click on "LET'S FIND OUT" button
        letsFindOutButton.click();

        //verify the page title
        String expectedTitle = "How much to save for education | Knowledge First Financial";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Title is :How much to save for education | Knowledge First Financial");


        //User select the age of child (need to switch the driver to frame)
        Driver.getDriver().switchTo().frame(frame);
        BrowserUtils.sleep(2);

        Actions actions=new Actions(Driver.getDriver());
        actions.click().dragAndDropBy(ageSlider,43,12).perform();
        BrowserUtils.sleep(2);


        //User select the initial deposit amount
        actions=new Actions(Driver.getDriver());
        actions.click().dragAndDropBy(initialDepositAmountSlider,33,12).perform();
        BrowserUtils.sleep(2);


        //User select the Monthly deposit amount
        actions=new Actions(Driver.getDriver());
        actions.click().dragAndDropBy(monthlyDepositAmountSlider,73,12).perform();
        BrowserUtils.sleep(2);


        //User select Rate of Return check box(randomly)
        int checkBoxSize=rateOfReturnCheckBox.size();
        System.out.println("Total check box :"+checkBoxSize);
        int randomSelection= ThreadLocalRandom.current().nextInt(0,checkBoxSize);
        rateOfReturnCheckBox.get(randomSelection).click();



        //User select province(randomly)
        Select select = new Select(provinceDropDown);
        int dropdownValuesCount=select.getOptions().size();

        Random randomProvince=new Random();
        int index=randomProvince.nextInt(dropdownValuesCount);

        select.selectByIndex(index);
        System.out.println("Random province index number: "+index);


       //User click on START SAVING NOW button
        Driver.getDriver().switchTo().defaultContent();
        startSavingNowButton.click();



    }


   @AfterMethod
    public void tearDown(){
        Driver.getDriver().quit();
    }



}
