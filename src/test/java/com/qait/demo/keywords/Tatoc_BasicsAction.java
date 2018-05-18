package com.qait.demo.keywords;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.util.Cookie;
import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.YamlReader;
import org.testng.*;

public class Tatoc_BasicsAction extends GetPage {

	WebDriver driver;
	String box1Color,box2Color;
	Boolean flag;
	private Object expected;

	public Tatoc_BasicsAction(WebDriver driver) {
		super(driver, "Tatoc_TestData");	
		this.driver = driver;
	}
	
	public void basic_Course() {
		element("basic_course").click();
		element("green_box").click();
		name();
		draganddrop (element("drag_box"), element("drop_box"));
		element("drag_proceed").click();
		element("launch_popup").click();
		switchToNewWindow();
		element("text_window").sendKeys("sujata");
		assertNotNull(element("text_window").getText());
		element("submit_button").click();
		switchtoOriginalWindow();
		element("launch_proceed").click();
		element("generate_token").click();
		addCookie("Token",getelementText("token_text"));
		element("launch_proceed").click();
		Assert.assertEquals(element("finish_msg").getText(), "End");
	}
	
	public void name() {
		switchToDefaultContent();
		switchToFrame("main_frame");
		box1Color = element("box_1").getCssValue("background-color");
		switchToFrame("child_frame");
		box2Color= element("box_2").getCssValue("background-color");
		if(box1Color.equals(box2Color)){
			Assert.assertEquals(box1Color, box2Color);
			System.out.println("value true ");
			switchToDefaultContent();
			switchToFrame("main_frame");
			element("repaint_proceed").click();
		}else{
			switchToDefaultContent();
			switchToFrame("main_frame");
			element("repaint_link").click();
			name();
		}
	}
	

	public org.openqa.selenium.Cookie addCookie(String key,String cookieValue){
		org.openqa.selenium.Cookie cookie = new org.openqa.selenium.Cookie(key, cookieValue);
		driver.manage().addCookie(cookie);
		assertNotSame(cookieValue, driver.manage().getCookies());
		return cookie;
	}

	
	
}

