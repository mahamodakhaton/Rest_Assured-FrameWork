package unittest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@Test(enabled = true)
public class PutTest {
	public void putTest() {

		Map<String, Object> map = new HashMap<>();
		map.put("firstName", "Zayaan");
		map.put("lastName", "Akter");
		map.put("dob", "11/05/1990");
		map.put("id", 20);

		RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.basePath("/users/7")// endPoints
		.contentType(ContentType.JSON)
		.body(map)// payload
		.log().all()
		.put()
		.then()
		.log().all()
		.statusCode(200);

	}
}
