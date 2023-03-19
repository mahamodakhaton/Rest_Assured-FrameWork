package misc;

import java.io.InputStream;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JasonPathExample {
	@Test(enabled = true)
	public void jasonPathGetMap() {
InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample_complex.jason");
JsonPath jasonpath = new JsonPath(inputStream);
System.out.println(jasonpath.getMap("items"));
System.out.println();

	}
	@Test(enabled = false)
	public void jasonPathGetList() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample_complex.jason");
		JsonPath jasonpath = new JsonPath(inputStream);
		System.out.println(jasonpath.getList("items.item"));
		System.out.println();

}
	@Test(enabled = false)
	public void jasonPathGetDouble() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample_complex.jason");
		JsonPath jasonpath = new JsonPath(inputStream);
		System.out.println(jasonpath.getDouble("items.item[0].ppu"));
		
}
	@Test(enabled = false)
	public void jasonPathWildCard() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample_complex.jason");
		JsonPath jasonpath = new JsonPath(inputStream);
		System.out.println(jasonpath.getList("items..ppu"));
		
}
}