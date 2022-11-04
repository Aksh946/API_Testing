package Com.Automation.Test;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import Com.Automation.genericUtils.API_utils;

public class Books_PUT_Method extends API_utils{
	@Test
	public void Update_book() throws FileNotFoundException {
		API_utils idkidk =  new API_utils();
		idkidk.Update_Method("https://fakerestapi.azurewebsites.net","api/v1/Books/24","C:\\Users\\aksh.pundir\\eclipse-workspace\\API_Testing\\src\\test\\resources\\request_body\\books.txt");
		
	}

}
