package functionalTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import endpoints.Users;

public class GetListUsersTest {
	Users users;
	@BeforeClass
	public void initTests() {
		users = new Users();
		users.init();
		
	}
	@Test(enabled = false, priority = 1)
	public void getUsersValidation() {
		users.getUsers();
		users.validateStatusCode(200);
}
	@Test(enabled = true, priority = 2)
	public void getUsersById() {
		users.getUsers1();
		users.validateStatusCode(200);
		//users.validatePayloadobject("usersName", "George");
		//users.validatePayloadobject("usersid", 7);
		//users.validate_w_jasonPath(".id",7);
	}
	@Test(enabled = false, priority = 3)
	public void responseValidation() {
		users.getEachUsers(7);
        System.out.println(users.getResponse().getBody().jsonPath().getString("usersName"));
	}
}
