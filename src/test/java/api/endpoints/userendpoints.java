package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



//Userendpoints.java
//created  to perform CRUD(Create,etrive,Update,Delete) request ot use the API
//-----------Session-1-------------------- 

public class userendpoints {
	
	public static Response  createuser(user payload)
	{
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON) // we need to send 2 headers thats the reason mentioning content.json 2 times along with request body
		//it might bedifferent for other API'S based on the ApI development
		.body(payload)
		
		.when()
		.post(routes.post_url);
		
		return res;
	}
	
	public static Response  retriveuser(String username)
	{
		Response res=given()
				.pathParam("username", username)
		
		
		.when()
		.post(routes.get_url);
		
		return res;
	}
	
	public static Response  updateuser(String username ,user payload)
	{
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON) //to accept header section that also in Json format
		.pathParam("username", username)
		.body(payload)
		
		.when()
		.put(routes.update_url);
		
		return res;
	}
	
	public static Response  deleteuser(String username )
	{
		Response res=given()
	
		.pathParam("username", username)
		
		
		.when()
		.delete(routes.delete_url);
		
		return res;
	}

}
