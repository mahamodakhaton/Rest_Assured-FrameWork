package functionalTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import endpoints.Users; //no pass

public class PostListUsersTest {
	Users users;
	@BeforeMethod
	public void init() {
		users = new Users();
		users.init();
	}
	@Test
	public void postAUsers() {
		users.postAUsers();
		users.validateStatusCode(200);
		users.validatePayloadobject("usersName", "Zayaan");
		users.validate_w_jasonPath("id", 1);
	}

}
