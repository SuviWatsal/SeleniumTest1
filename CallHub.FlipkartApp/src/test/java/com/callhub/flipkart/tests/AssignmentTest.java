package com.callhub.flipkart.tests;

import com.callhub.flipkart.base.Driver;
import com.callhub.flipkart.pages.Mainpage;
import com.callhub.flipkart.util.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class AssignmentTest extends Driver {
    Mainpage mainpage = null;
    WebDriverWait wait =null;
    List<WebElement> list1=new ArrayList<WebElement>();
    public static Logger log= LogManager.getLogger(AssignmentTest.class.getName());



    @BeforeMethod
    public void setUp() throws Exception {
        log.info("Initializing Drivers");
        initialize();
        log.info("Driver loaded!");
        mainpage = PageFactory.initElements(driver, Mainpage.class);
        wait=new WebDriverWait(Driver.driver, 20);

    }
    public AssignmentTest() {
        super();
    }
    @Test(priority=1)
    public void BrowserStackTest()  {
        try {

               mainpage.SearchProduct(prop.getProperty("toSearch"));
               mainpage.ClickElement(mainpage.Mobile_Filter);
               mainpage.ClickElement(mainpage.SAMSUNG_Brand_Checkbox);
               mainpage.ClickElement(mainpage.Flipkart_Assured_image_Checkbox);
               mainpage.ClickElement(mainpage.Sort_By_Price);


            String productLink_Xpath = "//div[@class='_13oc-S']/descendant::a";
            String productname_Xpath = "//div[@class='_13oc-S']/descendant::div[@class='_4rR01T']";
            String productprice_Xpath = "//div[@class='_13oc-S']/descendant::div[@class='_30jeq3 _1_WHN1']";

            ArrayList<String> list1 = mainpage.myproductdetail(productname_Xpath, "text",  driver);
            ArrayList<String> list2 = mainpage.myproductdetail(productLink_Xpath, "href",  driver);
            ArrayList<String> list3 = mainpage.myproductdetail(productprice_Xpath, "text",  driver);

            for(int i =0;i<list1.size();i++){

                System.out.println(list1.get(i) +" - "+list2.get(i) +" - " + list3.get(i));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @AfterMethod

    public void teardown() {
        log.info("Closing browser..");
        driver.quit();
        log.info("Browser closed!");
    }

    }
