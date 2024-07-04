package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userendpoints;
import api.payload.user;
import io.restassured.response.Response;

public class usertests {
	
	Faker fk;
	user userpayload;
	public Logger log;
	
	@BeforeClass
	public void setupdata()
	{
		 fk=new Faker();
		 userpayload=new user();
		 
		
		 
		 userpayload.setId(fk.idNumber().hashCode()); //most of times it wont generate random id so using hashcode to generate random id
		 userpayload.setUsername(fk.name().username());
		 userpayload.setFirstNam(fk.name().firstName());
		 userpayload.setLastName(fk.name().lastName());
		 userpayload.setEmail(fk.internet().safeEmailAddress());
		 userpayload.setPhone(fk.phoneNumber().cellPhone());
		 
		 log=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testpostuser()
	{
		log.info("******creating user************");
		
		Response res=userendpoints.createuser(userpayload);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),200);
		
		log.info("******user is created************");
	}
	
	@Test(priority=2)
	public void testgetuserbyname()
	
	{
		log.info("******Reading user data************");
		
		Response res=userendpoints.retriveuser(this.userpayload.getUsername());
		res.then().log().all();
		
		//Assert.assertEquals(res.getStatusCode(),200);
		log.info("******sucessfully read user data***********");
	}
	
    @Test(priority=3)
	public void testupdateuserbyname()
	{
    	//update data using payload
    	
    	log.info("******updating user by username************");
    	
    	 userpayload.setFirstNam(fk.name().firstName());
		 userpayload.setLastName(fk.name().lastName());
		 userpayload.setEmail(fk.internet().safeEmailAddress());
		 
		Response res=userendpoints.updateuser(this.userpayload.getUsername(),userpayload);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),200);	
		
		//checking data after updating
		Response resafterupdate=userendpoints.retriveuser(this.userpayload.getUsername());
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),200);
		
		log.info("******user got updated sucessfully ************");
		
	}
    @Test(priority=4)
	public void testdeleteeuserbyname(String username)
	{
    	log.info("******Deleting user by username************");
		Response res=userendpoints.deleteuser(this.userpayload.getUsername());
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),200);
		
		log.info("******user deleted************");
		
	}

}
