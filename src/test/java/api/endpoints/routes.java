package api.endpoints;


/*Swagger URL---->https://petstore.swagger.io  (base_url)
 * 
 * Create user(Post) :https://petstore.swagger.io/v2/user
 * get user(Get) :https://petstore.swagger.io/v2/user/{username}
 * update user(Put) :https://petstore.swagger.io/v2/user/{username}
 * delete user(Delete) :https://petstore.swagger.io/v2/user/{username}
 * 
 * 
 */

public class routes {
	
	public static  String base_url="https://petstore.swagger.io/v2";
	
	
	//user module
	
	public static  String post_url=base_url+"/user";
	public static  String get_url=base_url+"/user/{username}";
	public static  String update_url=base_url+"/user/{username}";
	public static  String delete_url=base_url+"/user/{username}";
	
	
	//same as like User module we need to create the url to both the modules
	
	//Pet module
	
	//store module

}
