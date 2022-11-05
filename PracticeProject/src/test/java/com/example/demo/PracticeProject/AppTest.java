package com.example.demo.PracticeProject;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AppTest
{
	@Test
    public void test()
    {
		ExtentReports reports = new ExtentReports(System.getProperty("user.dir")+"/reports/TestExecutionReport.html", true);
		ExtentTest test = reports.startTest("Sample Test");
		Response response=RestAssured.given().baseUri("https://reqres.in/api/users?page=2").get();
		test.log(LogStatus.INFO, response.asString());
		reports.endTest(test);
		reports.flush();
    }
}
