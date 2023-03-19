package unittest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostTest {
	@Test (enabled = true, priority = 1)
	public void postTestStringBody() {
		RestAssured.given()
	.baseUri("https://reqres.in/api/users")
	.contentType(ContentType.JSON)
	.body("{\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Zayaan\",\"last_name\": \"Mayeda\",\"avatar\": \"https://reqres.in/img/faces/12-image.jpg\",\"id\":\"1\",\"createdAt\":\"2023-03-11T02:07:02.869Z\"}")
	.basePath("/users")
	.when()
	.log().all()
	.post()
	.then()
	.log().all()
	.statusCode(201);
	}
	@Test(enabled = true, priority = 2)//no run
	public void postTestStringBody400() {
		RestAssured.given()
	.baseUri("https://reqres.in/ap/useer")
	.contentType(ContentType.JSON)
	.body("{\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Zayaan\",\"last_name\": \"Mayeda\",\"avatar\": \"https://reqres.in/img/faces/12-image.jpg\",\"id\":\"1\",\"createdAt\":\"2023-03-11T02:07:02.869Z\"}")
	.basePath("/users")
	.when()
	.log().all()
	.post()
	.then()
	.log().all()
	.statusCode(404);
	
	}	
		@Test (enabled = true, priority = 3)//run fail
		public void postTestFileBody500() {
			RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.body(new File("src/test/resources/users.jason"))
		.basePath("/users")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
		}
		@Test (enabled = true, priority = 4)
		public void postTestInputStreamBody() {
			RestAssured.given()
		.baseUri("https://reqres.in/api")
		.contentType(ContentType.JSON)
		.body(getClass().getClassLoader().getResourceAsStream("users2.jason"))
		.basePath("/users")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
		
		}
		@Test (enabled = true, priority = 5)
		public void postTestByteBody() {		
		try {
			RestAssured.given()
			.baseUri("https://reqres.in/api/users")
			.contentType(ContentType.JSON)
			.body(getClass().getClassLoader().getResourceAsStream("users2.jason").readAllBytes())
			.basePath("/users")
			.when()
			.log().all()
			.post()
			.then()
			.log().all()
			.statusCode(201);
		} catch (IOException e) {		
			e.printStackTrace();
		}
		}
		@Test (enabled = true, priority = 6)//it was pass but i didnot follow get call
		public void postTestMapBody() {
			Map<String, Object> map = new HashMap<>();
			map.put("firstName", "Mahamoda");
			map.put("lastName", "Khaton");
			map.put("dob", "11/05/1990");
			map.put("id", 20);
			RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.body(map)
		.basePath("/users")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
			
		
	}}
