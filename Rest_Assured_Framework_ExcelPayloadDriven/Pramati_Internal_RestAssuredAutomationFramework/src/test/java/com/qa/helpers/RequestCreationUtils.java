package com.qa.helpers;

import java.util.HashMap;

import org.json.JSONObject;

import com.qa.utils.CommonUtils;
import com.qa.utils.ExcelUtil;

public class RequestCreationUtils {
	
	public static String getEndpoint(String TCName) {
		try {
			int rowNum = ExcelUtil.findRow(TCName);
			int colNum = ExcelUtil.findcolumn("Endpoint");
			String resourcePath = ExcelUtil.getCellData(rowNum, colNum);
			return resourcePath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getResource(String TCName) {
		try {
			int rowNum = ExcelUtil.findRow(TCName);
			int colNum = ExcelUtil.findcolumn("Resource");
			String resourcePath = ExcelUtil.getCellData(rowNum, colNum);
			return resourcePath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static HashMap<String, Object> getHeaderParams(String TCName) {
		try {
			int rowNum = ExcelUtil.findRow(TCName);
			int colNum = ExcelUtil.findcolumn("HeaderParams");
			JSONObject jsonObj = new JSONObject(ExcelUtil.getCellData(rowNum, colNum));
			HashMap<String, Object> headerParams = CommonUtils.jsonToMap(jsonObj.toString());
			return headerParams;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static HashMap<String, Object> getQueryParams(String TCName) {
		try {
			int rowNum = ExcelUtil.findRow(TCName);
			int colNum = ExcelUtil.findcolumn("QueryParams");
			JSONObject jsonObj = new JSONObject(ExcelUtil.getCellData(rowNum, colNum));
			HashMap<String, Object> QueryParams = CommonUtils.jsonToMap(jsonObj.toString());
			return QueryParams;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static HashMap<String, Object> getPayload(String TCName) {
		try {
			int rowNum = ExcelUtil.findRow(TCName);
			int colNum = ExcelUtil.findcolumn("Payload");
			JSONObject jsonObj = new JSONObject(ExcelUtil.getCellData(rowNum, colNum));
			HashMap<String, Object> Payload = CommonUtils.jsonToMap(jsonObj.toString());
			return Payload;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		/*String filePath = System.getProperty("user.dir") + "\\src\\main\\Resources\\com\\qa\\TestData\\TestData.xlsx";
		ExcelUtil.setExcelFile(filePath, "UserManagement");
		HashMap<String, Object> payload = RequestCreationUtils.getPayload("AddNewUser");
		System.out.println(payload.toString());
		System.out.println("____________________________________");
		HashMap<String, Object> HeaderParams = RequestCreationUtils.getHeaderParams("AddNewUser");
		System.out.println(HeaderParams.toString());
		System.out.println("____________________________________");
		HashMap<String, Object> QueryParams = RequestCreationUtils.getQueryParams("GetAutomotiveUsers");
		System.out.println(QueryParams.toString());*/
	}
}
