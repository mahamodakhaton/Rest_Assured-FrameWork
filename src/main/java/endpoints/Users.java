package endpoints;

import java.io.InputStream;
import utils.RestSpecifications;

public class Users extends RestSpecifications {
	
	private final String USERS = "/users";
	private final String USERS1 = "/users?id=7";
	private final String fileName="usersid.jason";
	public void getUsers() {
		getcall(USERS);
	}
	public void getUsers1() {
		getcall(USERS1);
	}
	public void getEachUsers(int usersId, String endpoints ) {
		getcall(endpoints + "/" + usersId);
		
	}
	public void postAUsers() {
		setBody(getClass().getClassLoader().getResourceAsStream(fileName));
		setContentTypeAsjason();
		setBasicAuth("users", "pass");
		postCall(USERS);
		
	}
	private void setBody(InputStream resourceAsStream) {
		
	}
	public void getEachUsers(int i) {
		
		
	}

}
