package com.qait.demo.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.qait.automation.TestSessionInitiator;
import com.qait.automation.getpageobjects.BaseUi;
import com.qait.automation.utils.YamlReader;

public class Advanced_Tatoc {

	private TestSessionInitiator test;
	String username, password, loginUrl, input_code, input_name, customersetupurl,tatoc_url;

	@BeforeClass
	public void initializeVariable(){
		test = new TestSessionInitiator(this.getClass().getName());
		_initVars();
	}
	
	//@BeforeClass
	private void _initVars() {
		tatoc_url = YamlReader.getYamlValue("baseUrl");
		
	}

	@Test
	public void Tatoc01ClickAdvanced() throws SQLException {
		test.openUrl(tatoc_url);
		test.tatocadvanced.advanced_Course();
	}
	
	
	@AfterClass	  
	public void closeBrowser() {
		test.closeBrowserSession();
	}

}

