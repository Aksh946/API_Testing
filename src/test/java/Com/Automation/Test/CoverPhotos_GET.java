package Com.Automation.Test;


import org.testng.annotations.Test;

import Com.Automation.genericUtils.API_utils;

public class CoverPhotos_GET extends API_utils{
	@Test
	public void get_method() {
		API_utils cp_get = new API_utils();
		cp_get.s_getMethod("https://fakerestapi.azurewebsites.net","api/v1/CoverPhotos");
	}
	

}
