package api.utilies;

//ExtentReports  5.x  versio;
//when we need to generate EXtentreport we need to run test cases through XML only
//For Extentreport creation we need to integrtae both the extentreport and Testcase  file

/*<Listeners>
 * 
 * <listener class-name="api.test.ExtentReportManager.java"/>
 * 
 * </listeners>
 * 
 * we need to add log4j and log4j core 2 dependencies in pom.xml   (log4j2 dependecny and log4j.xml)
 * log4j2.xml contains all logs and that should be part of test resources
 * 
 * if we change <Root> tag in log4j.xml <Debug> mode then we can see the communication between client and server slo
 * 
 * We need to refredh LOGD folder to see  all the logs
 * 
 * This need to be placed after Suite i XML
 * After execurtin the XML file we need to refresh the folder so we eill get the extentreport
 * 
 */

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.IDynamicGraph.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repname;
	
	public void onstart(ITestContext testContext)
	{
		String  timestamp=new SimpleDateFormat("yyy:MM:dd:HH:mm.ss").format(new Date());  //time stamp
		repname="Test-Report-"+timestamp+".html";
		
		
		sparkreporter=new ExtentSparkReporter(".\\reports\\"+repname); //specify location of report
		
		
		sparkreporter.config().setDocumentTitle("RestAssuredAutomationProject");   //Title of Report
		sparkreporter.config().setReportName("Pet Store Users API");         //name of the report
		sparkreporter.config().setTheme(Theme.DARK);
		
		
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Application", "Pet Store Users API");
		extent.setSystemInfo("Operating Sytem",System.getProperty("os.name"));
		extent.setSystemInfo("UserName",System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Robin");	
	}
	
	public void  onTestSucess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(com.aventstack.extentreports.Status.PASS, "Test passed");
		
	}
	
	public void  onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(com.aventstack.extentreports.Status.FAIL, "Test Failed");
		test.log(com.aventstack.extentreports.Status.FAIL,result.getThrowable().getMessage());
		
	}
	
	public void  onTestSkkiped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(com.aventstack.extentreports.Status.SKIP, "Test Skipped");
		test.log(com.aventstack.extentreports.Status.SKIP,result.getThrowable().getMessage());
		
	}
	
	public void OnFinish(ITestContext testContext)
	{
		extent.flush();
	}

	
}	


