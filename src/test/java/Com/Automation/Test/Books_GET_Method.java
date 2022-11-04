package Com.Automation.Test;

import org.testng.annotations.Test;

import Com.Automation.genericUtils.API_utils;

public class Books_GET_Method extends API_utils {
	@Test
	public void getDetails() {
		API_utils ob = new API_utils();
		ob.s_getMethod("https://fakerestapi.azurewebsites.net","api/v1/Books");
		
	}
	
}
