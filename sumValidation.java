package RestAssured;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class sumValidation {
	@Test
	public void sumOfCourses() {
		
		int sum = 0;
JsonPath js=new JsonPath(payload.CoursePrice());
		
		int courseCount=js.getInt("courses.size()");
		
		for (int i=0; i<courseCount;i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int amount = price*copies;
			System.out.println(amount);
			sum = sum+amount;
			
		}
		System.out.println("\n"+"the sum of all courses is : "+sum);
		int purchaseAmount=js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
	}

}
