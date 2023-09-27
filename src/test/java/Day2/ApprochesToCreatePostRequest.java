package Day2;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class ApprochesToCreatePostRequest {
	
	void testPostUsingHashMap() {
		
		HashMap data = new HashMap();
		
		data.put("name","parag");
		data.put("job", "Automation QA Engineer");
		data.put("location", "Gurgaon");
		
		String courseArr[] = {"c","c++"};
		data.put("courses", courseArr);
		
		
		
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://localhost:3000/students")
		.then()
			.statusCode(201)
			.body("name",equalTo("parag"))
			.body("job",equalTo("Automation QA Engineer"))
			.body("location",equalTo("Gurgaon"))
			.body("courses[1]",equalTo("c++"))
			
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
		
		 
	}
	
	
	

}
