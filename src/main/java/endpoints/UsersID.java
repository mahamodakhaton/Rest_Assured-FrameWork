package endpoints;

import io.restassured.RestAssured;

public class UsersID extends RestAssured{
	private final String ENDPOINT = "/pages";
	public void getPages() {
		getCall(ENDPOINT);
		
	}
	private void getCall(String eNDPOINT2) {
	
	}
	public void validatesStatusCode(int i) {
		
	}
	
	public void init() {
		
		
	}
	
	
}
