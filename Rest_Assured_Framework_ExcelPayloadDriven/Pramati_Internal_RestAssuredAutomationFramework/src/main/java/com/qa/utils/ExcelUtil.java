package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.json.JSONObject;


import com.google.gson.JsonObject;
public class ExcelUtil {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	public static void setExcelFile(String Path,String SheetName) throws Exception {

		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception{
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		}catch (Exception e){
			return"";
		}
	}
	
	//This method is to get the row number corresponding to the TCName column's cell value
	public static int findRow (String TCName) {
	    for (Row row : ExcelWSheet) {
	        for (Cell cell : row) {
	            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	                if (cell.getRichStringCellValue().getString().trim().equals(TCName)) {
	                    return row.getRowNum();  
	                }
	            }
	        }
	    }               
	    return -1;
	}
	
	//This method is to get the column number corresponding column name
	public static int findcolumn (String columnName) {
	        for (Cell cell : ExcelWSheet.getRow(0)) {
	            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	                if (cell.getRichStringCellValue().getString().trim().equals(columnName)) {
	                    return cell.getColumnIndex();  
	                }
	        }
	    }               
	    return -1;
	}

	//This method is to write in the Excel cell, Row num and Col num are the parameters
	/*public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
		try{
			Row  = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}catch(Exception e){
			throw (e);
		}
	}*/

	public static void main(String[] args) throws Exception {
		/*String filePath = System.getProperty("user.dir") + "\\src\\main\\Resources\\com\\qa\\TestData\\TestData.xlsx";
		ExcelUtil.setExcelFile(filePath, "UserManagement");
		JSONObject jsonObj = new JSONObject(ExcelUtil.getCellData(2, 3));
		HashMap<String, Object> headerParams = CommonUtils.jsonToMap(jsonObj.toString());
		System.out.println(headerParams.toString());
		System.out.println("---------------------------");
		headerParams.put("UUID", "Aniket");
		System.out.println(headerParams.toString());
		
		System.out.println(ExcelUtil.findRow("AddNewUser"));
		System.out.println(ExcelUtil.findcolumn("HeaderParams"));*/
	}
}
