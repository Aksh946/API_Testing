package Com.Automation.Test;

import org.testng.annotations.Test;

import Com.Automation.genericUtils.API_utils;

public class Authors_DELETE extends API_utils{
	@Test
	public void delete_method() {
		API_utils object = new API_utils();
		object.delete_method("https://fakerestapi.azurewebsites.net","api/v1/Authors/45");
	}

}
