package cancelAPI;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getCancel {
	
	static String path="./src/test/resources/cancelAPI.xlsx";
	static String sheet="Sheet1";
	int i;
	//asdfsv
	@Test(dataProvider = "xlsxdata")
	public void cancelAPI(String tickNo,String value) throws EncryptedDocumentException, IOException {
		System.out.println(tickNo);
		String token="eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7InBsYXllcklkIjoibW9oYTE2NTU4OTcxMjA4NjlUWmJkOGQ2YTA2MjM5YTRhMTFhNGMzODZiNDhiMjAyMjUzIiwiY29kZSI6IkJJWiIsImRlc2lnbmF0aW9uSWQiOiJkZXNpZ25hdGlvbjEiLCJkZXNpZ25hdGlvbiI6IlNvZnR3YXJlIERldmVsb3BlciIsImRlcGFydG1lbnRJZCI6ImRlcGFydG1lbnQxIiwiZGVwYXJ0bWVudCI6IkluZm9ybWF0aW9uIFRlY2hub2xvZ3kiLCJ1c2VybmFtZSI6IklOVDAwMTEiLCJmaXJzdG5hbWUiOiJNb2hhbiIsImxhc3RuYW1lIjoiS3Jpc2huYSIsInN0YXR1cyI6ImFjdGl2ZSJ9LCJuYmYiOjE2NzQwNDI2OTcsImlhdCI6MTY3NDA0MjY5NywiZXhwIjoxNjc0NzMzODk3fQ.3sIrm0AZOwDAfbNzcoHMFx8MNWHx8L5yrto6dqAlQ3k";
		RestAssured.baseURI="https://test-api.bizlog.in:8443/mis-report/ticket/cancel/";

		RequestSpecification httpRequest=RestAssured.given()
				.auth().oauth2(token);
		Response response=httpRequest.request(Method.GET,tickNo);
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		
		
		int code=response.getStatusCode();
		i++;
		XLUtils.setData(path, sheet, i, 2, responseBody);
		if(value=="valid") {
			if(code==200&&responseBody.contains("Ticket is cancel by the retailer by API")) {
				XLUtils.setData(path, sheet, i, 3, "Pass");
			}
			else {
				Assert.fail();
				XLUtils.setData(path, sheet, i, 3, "Fail");
			}
		}
		else {
			if(code==200&&responseBody.contains("Ticket is cancel by the retailer by API")) {
				Assert.fail();
				XLUtils.setData(path, sheet, i, 3, "Fail");
			}
			else {
				XLUtils.setData(path, sheet, i, 3, "Pass");
			}
		}
	}

	@DataProvider(name="xlsxdata")
	public String [][] getData() throws EncryptedDocumentException, IOException{
		
		int rowNum=XLUtils.countRows(path, sheet);
		String [][] allData= new String [rowNum][2];

		for (int i = 1; i <= allData.length; i++) {
			for (int j = 0; j < allData[0].length; j++) {
				allData[i-1][j]=XLUtils.getData(path, sheet, i, j);

			}
		}
		return allData;
	}
}
