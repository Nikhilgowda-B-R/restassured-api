package cancelAPI;


import org.json.simple.JSONObject;

public class JSON {
	public  JSONObject getJSON(String expTicket,
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
			String expdestType) {
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
		
		
		
		JSONObject pri=new JSONObject();
		if(expPdCode!=null) primary.put("productCode", expPdCode);
		if(expPdId!=null) primary.put("productId", expPdId);
		if(expPdName!=null) primary.put("productName", expPdName);
		if(expbrandId!=null) primary.put("brandId",expbrandId);
		if(expmodelId!=null) primary.put("modelId",expmodelId);
		if(expbrandName!=null) primary.put("brandName",expbrandName);
		if(expmodelName!=null) primary.put("modelName",expmodelName);
		if(expdop!=null) primary.put("dateOfPurchase",expdop);
		if(expidNo!=null) primary.put("identificationNo",expidNo);
		if(expprodDesc!=null) primary.put("productDesc",expprodDesc);
		if(expprobDesc!=null) primary.put("problemDesc",expprobDesc);
		if(expprodVal!=null) primary.put("productValue",expprodVal);
		if(expcost!=null) primary.put("cost",expcost);
		if(expisUnderWar!=null) primary.put("isUnderWarranty",expisUnderWar);
		if(exppickUpSell!=null) primary.put("pickupSellerCode",exppickUpSell);
		if(expreturnSelCod!=null) primary.put("returnSellerCode",expreturnSelCod);
		if(expprodType!=null) primary.put("productType",expprodType);
		if(expprodValue!=null) primary.put("prodValue",expprodValue);
		
		
		JSONObject srcAdd=new JSONObject();
		if(expsrcContactP!=null) primary.put("srcContactPerson", expsrcContactP);
		if(expsrcOrg!=null) primary.put("srcOrg",expsrcOrg);
		if(expsrcAdd1!=null) primary.put("srcAdd1",expsrcAdd1);
		if(expsrcAdd2!=null) primary.put("srcAdd2",expsrcAdd2);
		if(expsrcLoc!=null) primary.put("srcLocation",expsrcLoc);
		if(expsrcCont1!=null) primary.put("srcContact1",expsrcCont1);
		if(expsrcCont2!=null) primary.put("srcContact2",expsrcCont2);
		if(expsrcCity!=null) primary.put("srcCity",expsrcCity);
		if(expsrcState!=null) primary.put("srcState",expsrcState);
		if(expsrcPin!=null) primary.put("srcPincode",expsrcPin);
		if(expsrcLand!=null) primary.put("srcLandmark",expsrcLand);
		if(expsrcEmail!=null) primary.put("srcEmailId",expsrcEmail);
		if(expsrcType!=null) primary.put("srcType",expsrcType);
		
		
		JSONObject descAdd=new JSONObject();
		if(expdestContactP!=null) primary.put("dstContactPerson", expdestContactP);
		if(expdestOrg!=null) primary.put("dstOrg",expdestOrg);
		if(expdestAdd1!=null) primary.put("dstAdd1",expdestAdd1);
		if(expdestAdd2!=null) primary.put("dstAdd2",expdestAdd2);
		if(expdestLoc!=null) primary.put("dstLocation",expdestLoc);
		if(expdestCont1!=null) primary.put("dstContact1",expdestCont1);
		if(expdestCont2!=null) primary.put("dstContact2",expdestCont2);
		if(expdestCity!=null) primary.put("dstCity",expdestCity);
		if(expdestState!=null) primary.put("dstState",expdestState);
		if(expdestPin!=null) primary.put("dstPincode",expdestPin);
		if(expdestLand!=null) primary.put("dstLandmark",expdestLand);
		if(expdestEmail!=null) primary.put("dstEmailId",expdestEmail);
		if(expdestType!=null) primary.put("dstType",expdestType);
		
		JSONObject  l= new JSONObject();
		l.put("primary", pri);
		l.put("src_add", srcAdd);
		l.put("dst_add", descAdd);
		requestparams.put("products", l);
		return requestparams;
	}
}
