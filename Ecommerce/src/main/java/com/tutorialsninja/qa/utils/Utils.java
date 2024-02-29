package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.java.sl.Ce;

public class Utils {

	public static String DateToAppend() {
		Date date = new Date();
		String EmailId = date.toString().replace(":", "_").replace(" ", "_");
		return "delhiganeshv" + EmailId + "@gmail.com";
	}

	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGELOAD_TIME_OUT = 10;

	public static Object[][] ReadDataFromExcel(String SheetName) {
		XSSFWorkbook workbook = null;
		File Excelfile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\TestData.xlsx");
		try {
			FileInputStream excelstream = new FileInputStream(Excelfile);
			workbook = new XSSFWorkbook(excelstream);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet("Login");
		int row = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[row][cols];
		for (int i = 0; i < row; i++) {			XSSFRow rows = sheet.getRow(i + 1);
			for (int j = 0; j < cols; j++) {
				XSSFCell cell = rows.getCell(j);
				CellType celltype = cell.getCellType();
				switch (celltype) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;
	}

}
