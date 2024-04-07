package com.callhub.flipkart.pages;

import com.callhub.flipkart.base.Driver;
import com.callhub.flipkart.util.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static com.callhub.flipkart.base.Driver.*;

public class Mainpage extends Driver {
    public static Logger log= LogManager.getLogger(Mainpage.class.getName());
      WebDriverWait wait = null;
    @FindBy(name = "q")
    WebElement SearchBox;
    @FindBy(linkText = "Mobiles")
    public WebElement Mobile_Filter;
    @FindBy(xpath = "//input[@type='checkbox']/following::div[contains(text(),'SAMSUNG')]")
    public WebElement SAMSUNG_Brand_Checkbox;
    @FindBy(xpath = "//input[@type='checkbox']/following::div/img[@src=\"//static-assets-web.flixcart.com/fk-p-linchpin-web/fk-cp-zion/img/fa_62673a.png\"]")
    public WebElement Flipkart_Assured_image_Checkbox;
    @FindBy(xpath = "//span[contains(text(),'Sort By')]/following::div[contains(text(),'Price -- High to Low')]")
    public WebElement Sort_By_Price;
    @FindBy(xpath = "//span[contains(text(),'results for')]/span")
    WebElement Search_Result_Assertion;
    public Mainpage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    public Boolean SearchProduct(String Product) throws InterruptedException {

        log.info("seraching the product in the sarch box ");
        SearchBox.click();
        SearchBox.sendKeys(Product);
        log.info("Pressing Enter ");
        SearchBox.sendKeys(Keys.ENTER);
        if(Search_Result_Assertion.getText().equals(Product)){
            log.info("Search is Successful !!!");
            return true;
        }
        return false;
    }
    public void ClickElement( WebElement element) throws InterruptedException {

        log.info("Filtering  the product in the search Result ");
        TestUtil.toBeclickable(element);
        element.click();


    }
    public static ArrayList<String> myproductdetail(String field_xpath, String attribute, WebDriver driver)    {
        List<WebElement> elementList= new ArrayList<WebElement>();
        ArrayList<String> list = new ArrayList<String>();
        WebElement tempelement;
        elementList = driver.findElements(By.xpath(field_xpath));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<elementList.size();i++){
            tempelement= elementList.get(i);
            if(attribute.equals("text")){
                list.add(tempelement.getText());}
            if(attribute.equals("href")){
                list.add(tempelement.getAttribute(attribute));
            }
        }
        return(list);
    }
    public WebElement getWebElClickable(String xpath, int waitSeconds) {
        wait = new WebDriverWait(driver, waitSeconds);
        return wait.ignoring(StaleElementReferenceException.class).until(
                ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
    }
}

