package Com.Automation.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Com.Automation.genericUtils.API_utils;

public class Books_POST_Method extends API_utils {

	@Test(dataProvider = "req_body")
	public void create(String id, String title, String description, String pageCount, String excerpt,
			String publishDate) throws FileNotFoundException {
		API_utils ap = new API_utils();
		ap.Create_excel_data_book_Method(id, title, description, pageCount, excerpt, publishDate);
		ap.Validation_response_body("title", title);
		ap.Validation_response_body("description", description);
	}

	@DataProvider(name = "req_body")
	public String[][] getData() throws IOException {
		String path = "C:\\Users\\aksh.pundir\\eclipse-workspace\\API_Testing\\src\\test\\resources\\excel_files\\Books.ods";
		Com.Automation.genericUtils.XL excel = new Com.Automation.genericUtils.XL(path);
		int totalrows = excel.getrowCount("Request_body");
		int totalcolumns = excel.getcellCount("Request_body", 1);
		String request_body_data[][] = new String[totalrows][totalcolumns];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcolumns; j++) {
				request_body_data[i - 1][j] = excel.getCellData("Request_body", i, j);

			}
		}
		return request_body_data;
	}

	@Test
	public void create() throws FileNotFoundException {
		API_utils ap = new API_utils();
		ap.CreateMethod("https://fakerestapi.azurewebsites.net", "api/v1/Books",
				"C:\\Users\\aksh.pundir\\eclipse-workspace\\API_Testing\\src\\test\\resources\\request_body\\books.txt");
		ap.Validation_response_body("title", "Mathematics");
		ap.Validation_response_body("description", "Simple Maths");

	}

}
