package Com.Automation.Test;

import org.testng.annotations.Test;

import Com.Automation.genericUtils.API_utils;

public class Books_DELETE_Method extends API_utils{
	@Test
	public void delete() {
		API_utils api = new API_utils();
		api.delete_method("https://fakerestapi.azurewebsites.net","api/v1/Books/23");
		
	}

}
