package unittest;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTest {
	@Test(enabled = true, priority = 1)
	public void getlistusersPreetyPrint() {
     RestAssured.get("https://reqres.in/api/users?page=2").prettyPrint();
	}
	
	
	@Test (enabled = true, priority = 2)
	public void getlistusers() {
Response response= RestAssured.get("https://reqres.in/api/users?page=2");
System.out.println(response.asString());

}
	@Test(enabled = true, priority = 3)
	public void getlistusersResponseCodeValidation() {
 RestAssured.get("https://reqres.in/api/users?page=2&id=7")
 .then()
 .statusCode(200);
 
	}
	@Test(enabled = true, priority = 4)//did not pass expected400 but should be404
	public void getlistusersResponseCodeValidationNegativeTest404() {
 RestAssured.get("https://reqres.in/api/users?page=2&id=17")
 .then()
 .statusCode(404);
}
	@Test(enabled = true, priority = 5)
	public void getlistusersLogs() {
 RestAssured.given()
 .log().all()
 .get("https://reqres.in/api/users?page=2&id=8")
 .then()
 .log().all()
 .statusCode(200);
 
	}
	@Test(enabled = true, priority = 6)
	public void getlistusersResponseValidation() {
 RestAssured.given()
 .log().all()
 .get("https://reqres.in/api/Id/12")
 .then()
 .log().all()
 .statusCode(200)
 .and()
 /*
 .body("id",equalTo("12"))
 .body("firstName",equalTo("Rachel"))
 .body("email",equalTo("rachel.howell@reqres.in"))*/
 ;
 
	}
	
}