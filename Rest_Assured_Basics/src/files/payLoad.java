package files;

public class payLoad {
	
	public static String getCreateUserPayload() {
		
		String payload = "{" + 
								"\"name\": \"morpheus\"," + 
								"\"job\": \"leader\"" + 
						"}";
		return payload;
	}

	public static String getUpdateUserPayload(String name) {
		String payload = "{"+ 
				"\"name\": \""+name+"\"," + 
				"\"job\": \"zion resident\"" + 
		"}";
			return payload;	
	}
}
