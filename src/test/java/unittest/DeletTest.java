package unittest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class DeletTest {
	@Test(enabled = true)//no pass no undersdan
	public void deletTest() {
		RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.basePath("/users/7")
		.log().all()
		.delete()
		.then()
		.log().all()
		.statusCode(204);
		
		
	}

}
