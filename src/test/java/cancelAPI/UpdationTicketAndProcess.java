package cancelAPI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.JSONObject;
import org.junit.runner.Request;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdationTicketAndProcess {

	static String path="./src/test/resources/Updatetick@ProcessAPI_data.xlsx";
	static String sheet="update";
	static int i=1;
	RequestSpecification httpRequest;
	String actTicket;
	String actRetailNo;
	String actConComNo;
	String actOrderNo;
	String actInvoiceNo;
	String actAppoin;
	String actInstall;
	String actPhysEval;
	String actTechEval;
	String actPackReq;
	
	String actPdCode;
	String actPdId;
	String actPdName;
	String actbrandId;
	String actmodelId;
	String actbrandName;
	String actmodelName;
	String actdop;
	String actidNo;
	String actprodDesc;
	String actprobDesc;
	String actprodVal;
	String actcost;
	String actisUnderWar;
	String actpickUpSell;
	String actreturnSelCod;
	String actprodType;
	String actprodValue;
	
	String actsrcContactP;
	String actsrcOrg;
	String actsrcAdd1;
	String actsrcAdd2;
	String actsrcLoc;
	String actsrcCont1;
	String actsrcCont2;
	String actsrcCity;
	String actsrcState;
	String actsrcPin;
	String actsrcLand;
	String actsrcEmail;
	String actsrcType;
	
	String actdestContactP;
	String actdestOrg;
	String actdestAdd1;
	String actdestAdd2;
	String actdestLoc;
	String actdestCont1;
	String actdestCont2;
	String actdestCity;
	String actdestState;
	String actdestPin;
	String actdestLand;
	String actdestEmail;
	String actdestType;

	@BeforeTest
	public void preReq() {
		String token="eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7InBsYXllcklkIjoibW9oYTE2NTU4OTcxMjA4NjlUWmJkOGQ2YTA2MjM5YTRhMTFhNGMzODZiNDhiMjAyMjUzIiwiY29kZSI6IkJJWiIsImRlc2lnbmF0aW9uSWQiOiJkZXNpZ25hdGlvbjEiLCJkZXNpZ25hdGlvbiI6IlNvZnR3YXJlIERldmVsb3BlciIsImRlcGFydG1lbnRJZCI6ImRlcGFydG1lbnQxIiwiZGVwYXJ0bWVudCI6IkluZm9ybWF0aW9uIFRlY2hub2xvZ3kiLCJ1c2VybmFtZSI6IklOVDAwMTEiLCJmaXJzdG5hbWUiOiJNb2hhbiIsImxhc3RuYW1lIjoiS3Jpc2huYSIsInN0YXR1cyI6ImFjdGl2ZSJ9LCJuYmYiOjE2NzQwNDI2OTcsImlhdCI6MTY3NDA0MjY5NywiZXhwIjoxNjc0NzMzODk3fQ.3sIrm0AZOwDAfbNzcoHMFx8MNWHx8L5yrto6dqAlQ3k";
		RestAssured.baseURI="https://test-api.bizlog.in:8443/core/ticketDetails";
		httpRequest=RestAssured.given()
				.auth()
				.oauth2(token);
	}

	public void jdbc(String expTicket) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://43.204.121.38:3306/rlog_e2?";
		String un="admin";
		String pw="Bizlog@123";

		String query="SELECT * FROM rlog_e2.zzz_ticket_mis_report_ticket_   inner join rlog_e2.zzz_ticket_mis_report_prod_ on rlog_e2.zzz_ticket_mis_report_ticket_.PROCESS_ID= rlog_e2.zzz_ticket_mis_report_prod_.PROCESS_ID where TICKET_NO='"+expTicket+"'";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection(url, un, pw);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		actTicket=rs.getString("TICKET_NO");
		actRetailNo=rs.getString("RETAILER_NO");
		actConComNo=rs.getString("CON_COMPLAINT_NO");
		actOrderNo=rs.getString("ORDER_NO");
		actInvoiceNo=rs.getString("INVOICE_NO");
		actAppoin=rs.getString("IS_APPOINTMENT_REQ");
		actInstall=rs.getString("IS_INSTALLATION_REQ");
		actPhysEval=rs.getString("IS_PHYSICAL_EVAL");
		actTechEval=rs.getString("IS_TECH_EVAL");
		actPackReq=rs.getString("IS_PACKING_REQ"); 
		
		 actPdCode=rs.getString("PRODUCT_CODE"); 
		 actPdId=rs.getString("PRODUCT_ID"); 
		 actPdName=rs.getString("PRODUCT_NAME"); 
		 actbrandId=rs.getString("BRAND_ID"); 
		 actmodelId=rs.getString("MODEL_ID"); 
		 actbrandName=rs.getString("BRAND"); 
		 actmodelName=rs.getString("MODEL"); 
		 actdop=rs.getString("DATE_OF_PURCHASE"); 
		 actidNo=rs.getString("IDENTIFICATION_NO"); 
		 actprodDesc=rs.getString("PRODUCT_DESC"); 
		 actprobDesc=rs.getString("PROBLEM_DESC"); 
		 actprodVal=rs.getString("PRODUCT_VALUE"); 
		 actcost=rs.getString("COST"); 
		 actisUnderWar=rs.getString("IS_UNDER_WARRANTY"); 
		 actpickUpSell=rs.getString("RETAILER_NAME"); 
		 actreturnSelCod=rs.getString("RETAILER_CODE"); 
		 actprodType=rs.getString("PRODUCT"); 
		 //actprodValue=rs.getString(""); 
		
		 actsrcContactP=rs.getString("SRC_CONTACT_PERSON"); 
		 actsrcOrg=rs.getString("SRC_ORG"); 
		 actsrcAdd1=rs.getString("SRC_ADD1"); 
		 actsrcAdd2=rs.getString("SRC_ADD2"); 
		 actsrcLoc=rs.getString("SRC_LOCATION"); 
		 actsrcCont1=rs.getString("SRC_CONATCT1"); 
		 actsrcCont2=rs.getString("SRC_CONTACT2"); 
		 actsrcCity=rs.getString("SRC_CITY"); 
		 actsrcState=rs.getString("SRC_STATE"); 
		 actsrcPin=rs.getString("SRC_PINCODE"); 
		 actsrcLand=rs.getString("SRC_LANDMARK"); 
		 actsrcEmail=rs.getString("SRC_EMAILID"); 
		 actsrcType=rs.getString("SRC_TYPE"); 
		
		 actdestContactP=rs.getString("DST_CONTACT_PERSON"); 
		 actdestOrg=rs.getString("DST_ORG"); 
		 actdestAdd1=rs.getString("DST_ADD1"); 
		 actdestAdd2=rs.getString("DST_ADD2"); 
		 actdestLoc=rs.getString("DST_LOCATION"); 
		 actdestCont1=rs.getString("DST_CONATCT1"); 
		 actdestCont2=rs.getString("DST_CONTACT2"); 
		 actdestCity=rs.getString("DST_CITY"); 
		 actdestState=rs.getString("DST_STATE"); 
		 actdestPin=rs.getString("DST_PINCODE"); 
		 actdestLand=rs.getString("DST_LANDMARK"); 
		 actdestEmail=rs.getString("DST_EMAILID"); 
		 actdestType=rs.getString("DST_TYPE"); 

	}

	@Test(dataProvider = "updatexlsxdata")
	public void updateValue(String expTicket,
			String expRetailNo,
			String expConComNo,
			String expOrderNo,
			String expInvoiceNo,
			String expAppoin,
			String expInstall,
			String expPhysEval,
			String expTechEval,
			String expPackReq,
			String expPayMode,
			
			String expPdCode,
			String expPdId,
			String expPdName,
			String expbrandId,
			String expmodelId,
			String expbrandName,
			String expmodelName,
			String expdop,
			String expidNo,
			String expprodDesc,
			String expprobDesc,
			String expprodVal,
			String expcost,
			String expisUnderWar,
			String exppickUpSell,
			String expreturnSelCod,
			String expprodType,
			String expprodValue,
			
			String expsrcContactP,
			String expsrcOrg,
			String expsrcAdd1,
			String expsrcAdd2,
			String expsrcLoc,
			String expsrcCont1,
			String expsrcCont2,
			String expsrcCity,
			String expsrcState,
			String expsrcPin,
			String expsrcLand,
			String expsrcEmail,
			String expsrcType,
			
			String expdestContactP,
			String expdestOrg,
			String expdestAdd1,
			String expdestAdd2,
			String expdestLoc,
			String expdestCont1,
			String expdestCont2,
			String expdestCity,
			String expdestState,
			String expdestPin,
			String expdestLand,
			String expdestEmail,
			String expdestType) throws ClassNotFoundException, SQLException, EncryptedDocumentException, IOException {

		httpRequest.header("Content-Type","application/json");
		JSON json=new JSON();
		JSONObject param = json.getJSON(expTicket, expRetailNo, expConComNo, expOrderNo, expInvoiceNo, expAppoin, expInstall, expPhysEval, expTechEval, expPackReq, expPayMode, expPdCode, expPdId, expPdName, expbrandId, expmodelId, expbrandName, expmodelName, expdop, expidNo, expprodDesc, expprobDesc, expprodVal, expcost, expisUnderWar, exppickUpSell, expreturnSelCod, expprodType, expprodValue, expsrcContactP, expsrcOrg, expsrcAdd1, expsrcAdd2, expsrcLoc, expsrcCont1, expsrcCont2, expsrcCity, expsrcState, expsrcPin, expsrcLand, expsrcEmail, expsrcType, expdestContactP, expdestOrg, expdestAdd1, expdestAdd2, expdestLoc, expdestCont1, expdestCont2, expdestCity, expdestState, expdestPin, expdestLand, expdestEmail, expdestType);
		httpRequest.body(param.toJSONString());
		
		Response response=httpRequest.request(Method.PUT,"/update");
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		JsonPath jsonpath=response.jsonPath();
		System.out.println(jsonpath.get("msg"));
		

		jdbc(expTicket);

		if(expTicket!=null) XLUtils.setData(path, sheet, i, 56, actTicket);
		if(expRetailNo!=null) XLUtils.setData(path, sheet, i, 57, actRetailNo);
		if(expConComNo!=null) XLUtils.setData(path, sheet, i, 58, actConComNo);
		if(expOrderNo!=null)XLUtils.setData(path, sheet, i, 59, actOrderNo);
		if(expInvoiceNo!=null) XLUtils.setData(path, sheet, i, 60, actInvoiceNo);
		if(expAppoin!=null) XLUtils.setData(path, sheet, i, 61, actAppoin);
		if(expInstall!=null) XLUtils.setData(path, sheet, i, 62, actInstall);
		if(expPhysEval!=null) XLUtils.setData(path, sheet, i, 63, actPhysEval);
		if(expTechEval!=null) XLUtils.setData(path, sheet, i, 64, actTechEval);
		if(expPackReq!=null) XLUtils.setData(path, sheet, i, 65, actPackReq);
		
		if(actPdCode!=null) XLUtils.setData(path, sheet, i, 67, actPdCode);
		if(actPdId!=null) XLUtils.setData(path, sheet, i, 68, actPdId);
		if(actbrandId!=null) XLUtils.setData(path, sheet, i, 69, actbrandId);
		if(actmodelId!=null) XLUtils.setData(path, sheet, i, 70, actmodelId);
		if(actbrandName!=null) XLUtils.setData(path, sheet, i, 71, actbrandName);
		if(actmodelName!=null) XLUtils.setData(path, sheet, i, 72, actmodelName);
		if(actdop!=null) XLUtils.setData(path, sheet, i, 73, actdop);
		if(actidNo!=null) XLUtils.setData(path, sheet, i, 74, actidNo);
		if(actprodDesc!=null) XLUtils.setData(path, sheet, i, 75, actprodDesc);
		if(actprobDesc!=null) XLUtils.setData(path, sheet, i, 76, actprobDesc);
		if(actprodVal!=null) XLUtils.setData(path, sheet, i, 77, actprodVal);
		if(actcost!=null) XLUtils.setData(path, sheet, i, 78, actcost);
		if(actisUnderWar!=null) XLUtils.setData(path, sheet, i, 79, actisUnderWar);
		if(actpickUpSell!=null) XLUtils.setData(path, sheet, i, 80, actpickUpSell);
		if(actreturnSelCod!=null) XLUtils.setData(path, sheet, i, 81, actreturnSelCod);
		if(actprodType!=null) XLUtils.setData(path, sheet, i, 82, actprodType);
		if(actprodValue!=null) XLUtils.setData(path, sheet, i, 83, actprodValue);
		
		if(actsrcContactP!=null) XLUtils.setData(path, sheet, i, 85, actsrcContactP);
		if(actsrcOrg!=null) XLUtils.setData(path, sheet, i, 86, actsrcOrg);
		if(actsrcAdd1!=null) XLUtils.setData(path, sheet, i, 87, actsrcAdd1);
		if(actsrcAdd2!=null) XLUtils.setData(path, sheet, i, 88, actsrcAdd2);
		if(actsrcLoc!=null) XLUtils.setData(path, sheet, i, 89, actsrcLoc);
		if(actsrcCont1!=null) XLUtils.setData(path, sheet, i, 90, actsrcCont1);
		if(actsrcCont2!=null) XLUtils.setData(path, sheet, i, 91, actsrcCont2);
		if(actsrcCity!=null) XLUtils.setData(path, sheet, i, 92, actsrcCity);
		if(actsrcState!=null) XLUtils.setData(path, sheet, i, 93, actsrcState);
		if(actsrcPin!=null) XLUtils.setData(path, sheet, i, 94, actsrcPin);
		if(actsrcLand!=null) XLUtils.setData(path, sheet, i, 95, actsrcLand);
		if(actsrcEmail!=null) XLUtils.setData(path, sheet, i,96, actsrcEmail);
		if(actsrcType!=null) XLUtils.setData(path, sheet, i, 97, actsrcType);
		
		if(actdestContactP!=null) XLUtils.setData(path, sheet, i, 98, actdestContactP);
		if(actdestOrg!=null) XLUtils.setData(path, sheet, i, 99, actdestOrg);
		if(actdestAdd1!=null) XLUtils.setData(path, sheet, i, 100, actdestAdd1);
		if(actdestAdd2!=null) XLUtils.setData(path, sheet, i, 101, actdestAdd2);
		if(actdestLoc!=null) XLUtils.setData(path, sheet, i, 102, actdestLoc);
		if(actdestCont1!=null) XLUtils.setData(path, sheet, i, 103,actdestCont1);
		if(actdestCont2!=null) XLUtils.setData(path, sheet, i, 104, actdestCont2);
		if(actdestCity!=null) XLUtils.setData(path, sheet, i, 105, actdestCity);
		if(actdestState!=null) XLUtils.setData(path, sheet, i, 106, actdestState);
		if(actdestPin!=null) XLUtils.setData(path, sheet, i, 107, actdestPin);
		if(actdestLand!=null) XLUtils.setData(path, sheet, i, 108, actdestLand);
		if(actdestEmail!=null) XLUtils.setData(path, sheet, i, 109, actdestLand);
		if(actdestType!=null) XLUtils.setData(path, sheet, i, 110, actdestType);

		/*validate(actTicket,expTicket);
		validate(actRetailNo,expRetailNo);
		validate(actConComNo,expConComNo);
		validate(actOrderNo,expOrderNo);
		validate(actAppoin,expAppoin);
		validate(actInstall,expInstall);
		validate(actPhysEval,expPhysEval);
		validate(actTechEval,expTechEval);
		validate(actPackReq,expPackReq);*/



		i++;
	}

	public void validate(String act,String exp) throws EncryptedDocumentException, IOException {
		if (exp==null) {
			return;
		}
		else {
			if(act.equals(exp)) {
				XLUtils.setData(path, sheet, i, 55, "Pass");
			}
			else {
				XLUtils.setData(path, sheet, i, 55, "Fail");
				Assert.fail();
			}
		}

	}



	@DataProvider(name="updatexlsxdata")
	public String [][] getData() throws EncryptedDocumentException, IOException{

		int rowNum=XLUtils.countRows(path, sheet);
		String [][] allData= new String [rowNum][55];

		for (int i = 1; i <= allData.length; i++) {
			for (int j = 0; j < allData[0].length; j++) {
				allData[i-1][j]=XLUtils.getData(path, sheet, i, j);

			}
		}
		return allData;
	}


}
