package com.callhub.flipkart.util;

import java.io.*;
import java.util.logging.FileHandler;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.callhub.flipkart.base.Driver;

import static java.awt.SystemColor.text;


public class TestUtil extends Driver {

	public static Logger log=LogManager.getLogger(TestUtil.class.getName());
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 10;
	static FileWriter fWriter;

    static {
        try {
            fWriter = new FileWriter(
                    "C:\\Users\\hp\\Downloads\\SimpleFlipkartAppAutomation-master\\SimpleFlipkartAppAutomation-master\\CallHub.FlipkartApp\\target\\ProductDetail.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TestUtil() throws IOException {
    }


    public static void CaptureScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		log.info("Screenshot captured");
	}

	
	
	public static void toBeclickable(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(Driver.driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

	public static void WrtingDataInFile(String text){

		try {

			// Create a FileWriter object
			// to write in the file

			// Writing into file
			// Note: The content taken above inside the
			// string
			fWriter.append(text);

			// Printing the contents of a file
			System.out.println(text);

			// Closing the file writing connection
			fWriter.close();

			// Display message for successful execution of
			// program on the console
			System.out.println(
					"File is created successfully with the content.");
		} catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
