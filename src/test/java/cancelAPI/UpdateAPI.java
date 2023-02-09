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

public class UpdateAPI {

	static String path="./src/test/resources/UpdateAPI_data.xlsx";
	static String sheet="update";
	static int i=1,j=1;
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

	@BeforeTest
	public void preReq() {
		String token="eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7InBsYXllcklkIjoibmlraDE2NzQ1NTI3MzI2MjhUWjgwNTNmZTg2YmJkZDQ5NWZhYTc5YTU0MzIxM2JhOGNiIiwiY29kZSI6IkJJWiIsImRlc2lnbmF0aW9uSWQiOiJmZSIsImRlc2lnbmF0aW9uIjoiRmllbGQgRW5naW5lZXIiLCJkZXBhcnRtZW50SWQiOiJkZXBhcnRtZW50MSIsImRlcGFydG1lbnQiOiJJbmZvcm1hdGlvbiBUZWNobm9sb2d5IiwidXNlcm5hbWUiOiJuaWtoaWwiLCJmaXJzdG5hbWUiOiJOaWtoaWwiLCJsYXN0bmFtZSI6Imdvd2RhIiwic3RhdHVzIjoiYWN0aXZlIn0sIm5iZiI6MTY3NTA1NDgzOCwiaWF0IjoxNjc1MDU0ODM4LCJleHAiOjE2NzU3NDYwMzh9.eafuWJYUhM7zAWFegWjcO6yIz2r_eHE8KlICIKvOc04";
		RestAssured.baseURI="https://test-api.bizlog.in:8443/core/ticketDetails";
		httpRequest=RestAssured.given()
				.auth()
				.oauth2(token);
	}

	public void jdbc(String expTicket) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://43.204.121.38:3306/rlog_e2?";
		String un="admin";
		String pw="Bizlog@123";

		String query="SELECT * FROM rlog_e2.zzz_ticket_mis_report_ticket_ where TICKET_NO='"+expTicket+"'";
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
			String expPayMode) throws ClassNotFoundException, SQLException, EncryptedDocumentException, IOException {


		JSONObject requestparams=new JSONObject();
		requestparams.put("ticketNo",expTicket);

		JSONObject primary=new JSONObject();
		if(expRetailNo!=null) primary.put("retailerNo", expRetailNo);
		if(expConComNo!=null) primary.put("conComplaintNo",expConComNo);
		if(expOrderNo!=null) primary.put("orderNo",expOrderNo);
		if(expInvoiceNo!=null) primary.put("invoiceNo",expInvoiceNo);
		if(expAppoin!=null) primary.put("isAppointmentReq",expAppoin);
		if(expInstall!=null) primary.put("isInstallationReq",expInstall);
		if(expPhysEval!=null) primary.put("isPhysicalEval",expPhysEval);
		if(expTechEval!=null) primary.put("isTechEval",expTechEval);
		if(expPackReq!=null) primary.put("isPackingReq",expPackReq);
		if(expPayMode!=null) primary.put("paymentMode",expPayMode);

		requestparams.put("primary", primary);
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestparams.toJSONString());

		Response response=httpRequest.request(Method.PUT,"/update");
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		JsonPath jsonpath=response.jsonPath();
		System.out.println(jsonpath.get("msg"));

		jdbc(expTicket);

		if(expTicket!=null) XLUtils.setData(path, sheet, i, 12, actTicket);
		if(expRetailNo!=null) XLUtils.setData(path, sheet, i, 13, actRetailNo);
		if(expConComNo!=null) XLUtils.setData(path, sheet, i, 14, actConComNo);
		if(expOrderNo!=null)XLUtils.setData(path, sheet, i, 15, actOrderNo);
		if(expInvoiceNo!=null) XLUtils.setData(path, sheet, i, 16, actInvoiceNo);
		if(expAppoin!=null) XLUtils.setData(path, sheet, i, 17, actAppoin);
		if(expInstall!=null) XLUtils.setData(path, sheet, i, 18, actInstall);
		if(expPhysEval!=null) XLUtils.setData(path, sheet, i, 19, actPhysEval);
		if(expTechEval!=null) XLUtils.setData(path, sheet, i, 20, actTechEval);
		if(expPackReq!=null) XLUtils.setData(path, sheet, i, 21, actPackReq);

		validate(actTicket,expTicket);
		validate(actRetailNo,expRetailNo);
		validate(actConComNo,expConComNo);
		validate(actOrderNo,expOrderNo);
		validate(actAppoin,expAppoin);
		validate(actInstall,expInstall);
		validate(actPhysEval,expPhysEval);
		validate(actTechEval,expTechEval);
		validate(actPackReq,expPackReq);



		i++;
	}

	public void validate(String act,String exp) throws EncryptedDocumentException, IOException {
		if (exp==null) {
			return;
		}
		else {
			if(act.equals(exp)) {
				XLUtils.setData(path, sheet, i, 11, "Pass");
			}
			else {
				XLUtils.setData(path, sheet, i, 11, "Fail");
				Assert.fail();
			}
		}

	}



	@DataProvider(name="updatexlsxdata")
	public String [][] getData() throws EncryptedDocumentException, IOException{

		int rowNum=XLUtils.countRows(path, sheet);
		String [][] allData= new String [rowNum][11];

		for (int i = 1; i <= allData.length; i++) {
			for (int j = 0; j < allData[0].length; j++) {
				allData[i-1][j]=XLUtils.getData(path, sheet, i, j);

			}
		}
		return allData;
	}


}
