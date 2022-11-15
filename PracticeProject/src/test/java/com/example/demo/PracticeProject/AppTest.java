package com.example.demo.PracticeProject;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AppTest
{
	ExtentReports reports = new ExtentReports(System.getProperty("user.dir")+"/reports/TestExecutionReport.html", true);
	ExtentTest test;
	@Test
    public void test()
    {
		test = reports.startTest("Sample Test");
		Response response=RestAssured.given().baseUri("https://reqres.in/api/users?page=2").get();
		test.log(LogStatus.INFO, response.asString());
		reports.endTest(test);
		reports.flush();
    }
	
	@Test
    public void test2()
    {
		test = reports.startTest("Sample Test2");
		test.log(LogStatus.INFO, System.getProperty("env"));
		reports.endTest(test);
		reports.flush();
    }
}
