package com.qa.dp;

import org.testng.annotations.DataProvider;

public class ProfileDP {

	@DataProvider
	 public static Object[][] updateUserInfoService(){
		String[] array = {"rest/profile/user/3695941?site_id=32265&src=end-user:profile-ui","200","maheshwar.gade@deem.com","Mahesh","Gade","8688571" ,"24045","53025","233","333"};
		
		Object[][] dataSet = new Object[][] { array};
		return dataSet;
			
		}

}
