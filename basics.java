package RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class basics {
	public static void main(String[] args) {
		
		
		// given when then
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String response = given().log().all().queryParam("key", "qaclick123").header("Contect-Type", "application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		String placeid=js.getString("place_id");
		System.out.println(placeid);
		
		given().log().all().queryParam("key", "qaclick123").header("Contect-Type", "application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+placeid+ "\",\r\n" + 
				"\"address\":\"70 Summer walk, USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200);
		
		
	}

}
