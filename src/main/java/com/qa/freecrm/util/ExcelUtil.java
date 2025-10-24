package com.qa.freecrm.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {

    public static Workbook book;

    public static Sheet sheet;

    public static String TEST_DATA_SHEET_PATH = "src/main/java/com/qa/freecrm/testdata/FreeCrmTestdata.xlsx";

    public static Object[][] getTestData(String sheetName){

        //Fetch data from Excel sheet:

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(TEST_DATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);

        //Get the data
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for(int i=0; i<sheet.getLastRowNum(); i++){
            for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++){
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }
}
