package RestAssured;

import io.restassured.path.json.JsonPath;

public class complexJsonParse {
	
	public static void main(String[] args) {
		
		JsonPath js=new JsonPath(payload.CoursePrice());
		
		//number of courses
		int courseCount=js.getInt("courses.size()");
		System.out.println(courseCount);
		
		int totalAmount=js.getInt("dashboard.purchaseAmount");
				System.out.println(totalAmount);
				
				String FC=js.getString("courses[0].title");
				System.out.println(FC);
				int CP=js.getInt("courses[0].price");
				System.out.println(CP +"\n");
				
				for (int i=0 ; i< courseCount ; i++)
				{
					System.out.println(js.getString("courses["+i+"].title"));
					System.out.println(js.getInt("courses["+i+"].price"));
				}
				
				System.out.println("\n" + "RPA copies SOLD" +"\n");
				
				for (int i=0 ; i< courseCount ; i++)
				{
					String CTCS = js.getString("courses["+i+"].title");
					if (CTCS.equalsIgnoreCase("RPA"))
					{
						System.out.println(js.getString("courses["+i+"].copies"));
						break;
					}
					
				}
		
	}

	private static void String(Object object) {
		// TODO Auto-generated method stub
		
	}
	
	


}
