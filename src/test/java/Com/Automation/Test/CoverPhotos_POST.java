package Com.Automation.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Automation.genericUtils.API_utils;

public class CoverPhotos_POST extends API_utils{
	@Test
	public void create_method() throws FileNotFoundException {
		API_utils object = new API_utils();
		object.CreateMethod("https://fakerestapi.azurewebsites.net","api/v1/CoverPhotos", "C:\\Users\\aksh.pundir\\eclipse-workspace\\API_Testing\\src\\test\\resources\\request_body\\CoverPhotos.txt");
	}
	
	
	@Test(dataProvider = "req_body")
	public void multiple_createRequest(String ID,String ID_BOOK,String URL) {
		API_utils object = new API_utils();
		object.postRequest_excel(ID,ID_BOOK,URL);
		object.Validation_response_body("idBook",ID_BOOK);
		object.Validation_response_body("id",ID);
		object.Validation_response_body("url", URL);
	}

	@DataProvider(name = "req_body")
	public String[][] getData() throws IOException {
		String path = "C:\\Users\\aksh.pundir\\eclipse-workspace\\API_Testing\\src\\test\\resources\\excel_files\\CoverPhotos.ods";
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
}
