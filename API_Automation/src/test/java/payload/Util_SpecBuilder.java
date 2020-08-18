package payload;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Util_SpecBuilder {

	public static RequestSpecification reqBuilder;//If it is not static the variable will be reset to null.
	ResponseSpecification resBuilder;
	
	public RequestSpecification req_SpecBuilder() throws IOException {

		if (reqBuilder==null) {
		//Print Stream helps to print any thing in it
		PrintStream log = new PrintStream(new FileOutputStream("Log.txt"));
		//Creating Request Spec Builders to re use the code 
		 reqBuilder = new RequestSpecBuilder().setBaseUri(GlobalValue("baseURI"))
				 .addFilter(RequestLoggingFilter.logRequestTo(log))//used to log request 
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				.addQueryParam("Key", "qaclick123").setContentType(ContentType.JSON).build();
		
		return reqBuilder;
	}
		return reqBuilder;
	}
	
	public ResponseSpecification response_SpecBuilder() {
		
		 resBuilder = new ResponseSpecBuilder().expectStatusCode(200).expectBody("scope", equalTo("APP"))
				.expectContentType(ContentType.JSON).build();
		
		 return resBuilder;
	}
	
	public static String GlobalValue(String Key) throws IOException {
		
		Properties prop = new Properties();//Properties class is used to get the data in propertie file
		FileInputStream input = new FileInputStream("F:\\Study\\REST\\RESTAPI\\RESTAPI_workspace\\API_Automation\\Global.properties");
		prop.load(input);
		return prop.getProperty(Key);
	}
	
	
	
	
	
	
	
	
}
