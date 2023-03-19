package functionalTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.UsersID;

public class GetListUsersIdTest {
	UsersID usersID;
	@BeforeMethod
	public void init() {
		usersID=new UsersID();
		usersID.init();
	}
	@Test
	public void getPages() {
		usersID.getPages();
		usersID.validatesStatusCode(200);
	}

}
