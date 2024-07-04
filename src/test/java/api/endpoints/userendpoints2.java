package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


	//Userendpoints.java
	//created  to perform CRUD(Create,etrive,Update,Delete) request ot use the API
	//-----------Session-1-------------------- 

	public class userendpoints2 {
		
		//Method created to get URL'S from the properties file
		
		public static ResourceBundle  geturl()
		{
			ResourceBundle routes=ResourceBundle.getBundle("routes");   //read the property file
			return routes;
		}
		
		
		public static Response  createuser(user payload)
		{
			String post_url= geturl().getString("post_url");
			
			Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON) // we need to send 2 headers thats the reason mentioning content.json 2 times along with request body
			//it might bedifferent for other API'S based on the ApI development
			.body(payload)
			
			.when()
			.post(post_url);
			
			return res;
		}
		
		public static Response  retriveuser(String username)
		{
			String get_url= geturl().getString(" get_url");
			
			       Response res=given()
					.pathParam("username", username)
			
			
			.when()
			.post(get_url);
			
			return res;
		}
		
		public static Response  updateuser(String username ,user payload)
		{
			
			String update_url= geturl().getString("update_url");
			
			Response res=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON) //to accept header section that also in Json format
			.pathParam("username", username)
			.body(payload)
			
			.when()
			.put(update_url);
			
			return res;
		}
		
		public static Response  deleteuser(String username )
		{
			
			String delete_url= geturl().getString(" delete_url");
			
			Response res=given()
		
			.pathParam("username", username)
			
			
			.when()
			.delete(delete_url);
			
			return res;
		}

	}



