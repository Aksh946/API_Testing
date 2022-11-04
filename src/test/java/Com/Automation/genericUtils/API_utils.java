package Com.Automation.genericUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class API_utils {
	Response response;

	public void s_getMethod(String baseURI, String request) {
		Response res = given().baseUri(baseURI).when().log().all().get(request);
		res.then().log().all().assertThat().statusCode(200).assertThat().statusCode(200).and()
				.statusLine("HTTP/1.1 200 OK");
	}

	public void CreateMethod(String baseURI, String request, String file_path) throws FileNotFoundException {
		response = given().baseUri(baseURI).body(getFileContent(file_path)).header("Accept", "application/json")
				.header("Content-Type", "application/json").when().log().all().post(request);
	}

	public void Validation_response_body(String key, String value) {

		response.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK");

		int len = value.length();
		int j = 1;
		for (int i = 0; i < len; i++) {
			int num = (int) value.charAt(i);
			if (num >= 48 && num <= 57) {
				continue;
			} else {
				j++;
				break;
			}
		}

		if (j == 1) {
			int VALUE = Integer.parseInt(value);
			response.then().body(key, equalTo(VALUE));
		} else {

			response.then().body(key, equalTo(value));
		}

	}

	public void Create_excel_data_book_Method(String id, String title, String description, String pageCount,
			String excerpt, String publishDate) throws FileNotFoundException {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("description", description);
		map.put("title", title);
		map.put("pageCount", pageCount);
		map.put("excerpt", excerpt);
		map.put("publishDate", publishDate);
		response = given().baseUri("https://fakerestapi.azurewebsites.net").body(map)
				.header("Accept", "application/json").header("Content-Type", "application/json").when().log().all()
				.post("api/v1/Books");
		System.out.println("Title is ---->" + title);
	}

	public void postRequest_excel(String iD, String iD_BOOK, String uRL) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", iD);
		map.put("idBook", iD_BOOK);
		map.put("URL", uRL);
		response = given().baseUri("https://fakerestapi.azurewebsites.net").contentType("application/json").body(map)
				.header("Accept", "application/json").when().log().all().post("api/v1/CoverPhotos");
//		int id_a = Integer.parseInt(iD);
//		int id_b= Integer.parseInt(iD_BOOK);
//		response.then().body("idBook", equalTo(id_b),"id",equalTo(id_a));
	}

	public void postRequest_excel_authors(String iD, String iD_BOOK, String firstName, String lastName) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", iD);
		map.put("idBook", iD_BOOK);
		map.put("firstName", firstName);
		map.put("lastName", lastName);
		response = given().baseUri("https://fakerestapi.azurewebsites.net").contentType("application/json").body(map)
				.header("Accept", "application/json").when().log().all().post("api/v1/Authors");
//		int id_a = Integer.parseInt(iD);
//		int id_b= Integer.parseInt(iD_BOOK);
//		response.then().body("idBook", equalTo(id_b),"id",equalTo(id_a));
	}

	public static String getFileContent(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\Z");
		return sc.next();
	}

	public void Update_Method(String baseURI, String request, String file_path) throws FileNotFoundException {
		response = given().baseUri(baseURI).body(getFileContent(file_path)).header("Accept", "application/json")
				.header("Content-Type", "application/json").when().log().all().put(request);
	}

	public void delete_method(String baseURI, String request) {
		given().baseUri(baseURI).when().log().all().delete(request).then().log().all().assertThat().statusCode(200)
				.statusLine("HTTP/1.1 200 OK");
	}

}
