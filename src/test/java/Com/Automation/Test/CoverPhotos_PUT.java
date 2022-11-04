package Com.Automation.Test;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import Com.Automation.genericUtils.API_utils;

public class CoverPhotos_PUT extends API_utils{
	
	@Test
	public void put_request() throws FileNotFoundException {
		API_utils object = new API_utils();
		object.Update_Method("https://fakerestapi.azurewebsites.net","api/v1/CoverPhotos/100", "C:\\Users\\aksh.pundir\\eclipse-workspace\\API_Testing\\src\\test\\resources\\request_body\\CoverPhotos.txt");
		object.Validation_response_body("id","46");
		object.Validation_response_body("idBook","364");
		
	}

}
