package utils;

import java.util.Map;
import javax.print.DocFlavor.INPUT_STREAM;
import org.hamcrest.Matchers;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import reporting.Logs;

public abstract class RestSpecifications {
	protected RequestSpecification request;
	protected Response response;

	public void init() {
		String baseUrl = TestConfig.getUrl();
		request = RestAssured.given().baseUri(baseUrl);
	}

	public void getcall(String endpoint) {
		request.log().all();
		response = request.get(endpoint);
		Logs.log("Response :\n" + response.asPrettyString());
	}

	public void setContentTypeAsjason() {
		request.contentType(ContentType.JSON);
	}

	
	public void setBody(Map<String, ?> file) {
		request.body(file);
	}

	public void setBody(INPUT_STREAM is) {
		request.body(is);

	}
	public void setBasicAuth(String users,String passs) {
	request.auth().basic(users, passs);	
		
	}
	public void set0auth2Token(String token) {
		request.auth().preemptive().oauth2(token);
		
	}
	public void setHeader(String key,String value) {
		request.header(key,value);
	}
	public void setHeaders(Header...headers) {
		for (Header header : headers) {
			request.header(header);
		}
	}
	public Header setHeaderobject(String key,String value) {
		Header header = new Header(key, value);
		return header;
		
	}
	public Response getResponse() {
		return response;
	}
	
	
	public void postCall(String endpoint) {
		request.log().all();
		response = request.post(endpoint);
	}
	public void validateStatusCode(int statusCode) {
		Logs.log("Expected Response Code is" + statusCode + "Actual Status code is :" + response.statusCode());
		response.then().statusCode(200);
	}
	public void validatePayloadobject(String key, Object expectedValue) {
		Logs.log("Key is:" + key + ".Expected value is : " + expectedValue);
		response.then().body(key, Matchers.equalTo(expectedValue));
	}

	public void validate_w_jasonPath(String path, Object expectedValue) {
		response.then().body(path, Matchers.equalTo(expectedValue));
		Logs.log("Expected:" + expectedValue + ". Actual:" + response.getBody().jsonPath().get(path));
	}

}
