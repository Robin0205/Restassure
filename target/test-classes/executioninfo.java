
public class executioninfo {
	
	
	/*-------------------Execution------------------
	 * We can execute test cases from usertest file just to see the output in console
	 * But if we want to see the results along with extentreport and logs then we need to excute our
	 * usertest cls file must through XML file only.
	 * 
	 * 
	 * if we want to run our test cases remotely through jenkins or commond prompt then we need to run
	 * through POM.XML (we need add the dependencies & plugins regarding that one) 
	 * 
	 * Maven-surefin plugin need to be added in the <plugin>   </plugin> 
	 * Maven-Compiler Plugin need to be added in the pom.xml
	 * 
	 * Inside the Mavn surefin plugin configuration tag we need to give xml file name in suite tag like
	 * 
	 * mentioned below
	 * <configuration>
	 * <suitexmlfiles>
	 * <suitexmlfile>
	 * <suite>  pettestng.xml </suite>
	 * </suitexmlfile>
	 * </suitexmlfiles>
	 * </configuration>
	 * 
	 * As pom.xml is realted to maven so we need to run the pom.xml file through pom.xml only (maven test)
	 * 
	 * --------------Executing test case through command line prompt---------
	 * 
	 * 
	 * If we want to execute the test cases outside the eclipse then the dependencies that we added in pom.xml
	 * doesnt require ,to do that we need to  download and install the maven software
	 * 
	 * Maven available in 2 forms 1.Maven-eclipse plugin 2.Maven software--insatll n set in Os
	 * 
	 * 
	 * 
	 * Eclipse------Maven
	 * 
	 * 
	 * Install on windows
	 * 
	 * Download zip file: https://dlcdn.apache.org/maven/maven-3/3.9.8/binaries/apache-maven-3.9.8-bin.zip
	 * download extract and keep in c drive directlt we dont need to do aany installation
	 * 
	 * project location: C:\Users\Robin\eclipse-workspace\Restassure
	 * 
	 * then enter cd (project location enter here)-----it will redirect to the project location
	 * the enter dir(command in commadn line prompt) it will give all the files
	 * then mvn test(use thhis command) it will exeute your project this is continous deployment
	 * 
	 * Solution for Errie is maintain Java 11 above version(like 12,13,14,15..) for major version 55
	 * 
	 * 
	 * we have use five the jdk path in system variables and ned to refer in path using %Java_Home%/bin like this
	 * or else we can directly add the jdk/bin in path only 
	 * 
	 * 
	 * ------------------------------JENKINS-----------------------------
	 * we can execute the project file in jenkins also ,before that we need to execute through CLP
	 * we have to use same  mvn test command only 
	 */

}
