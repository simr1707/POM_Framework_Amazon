package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 18;
	public static long IMPLICIT_WAIT = 10;
	public static long EXPLICIT_WAIT = 5;
	public static String TESTDATA_SHEET_PATH = "D:\\QA\\Testing\\AmazonSignUpData.xlsx";
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;

	public static Object[][] getTestData(String sheetName) {

		FileInputStream file = null;

		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {

				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException{
		File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShotFile, new File(filePath + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
	}
}
