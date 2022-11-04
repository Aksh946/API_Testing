package Com.Automation.Test;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import Com.Automation.genericUtils.API_utils;

public class Authors_PUT extends API_utils {
	@Test
	public void update_method() throws FileNotFoundException {
		API_utils object = new API_utils();
		object.Update_Method("https://fakerestapi.azurewebsites.net","api/v1/Authors/45","C:\\Users\\aksh.pundir\\eclipse-workspace\\API_Testing\\src\\test\\resources\\request_body\\Authors.txt");
	}

}
