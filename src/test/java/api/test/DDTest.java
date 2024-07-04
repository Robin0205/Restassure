package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userendpoints;
import api.payload.user;
import api.utilies.dataproviders;
import io.restassured.response.Response;


/*In this class we are creating multiple users from reading data from Excel and 
 * deleting users by getting useranmes from excel sheet.  
 */

public class DDTest {
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=dataproviders.class)
	public void testpostuser(String UserId,String UserName,String FirstName,String LastName,String Email,String Password,String Phone)
	{
		user userpayload =new user();
		
		 userpayload.setId(Integer.parseInt(UserId)); //most of times it wont generate random id so using hashcode to generate random id
		 userpayload.setUsername(UserName);
		 userpayload.setFirstNam(FirstName);
		 userpayload.setLastName(LastName);
		 userpayload.setEmail(Email);
		 userpayload.setPassword(Password);
		 userpayload.setPhone(Phone);
		
		
		 Response res=userendpoints.createuser(userpayload);
		Assert.assertEquals(res.getStatusCode(),200);	
	
	}
	
	@Test(priority=2,dataProvider="usernames",dataProviderClass=dataproviders.class)
	public void testdeletebyusername(String UserName)
	{
		Response res=userendpoints.deleteuser(UserName);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),200);	
	}

}
