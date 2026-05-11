package com.qa.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import org.apache.poi.ss.usermodel.*;

public class ExcelReader {

	public static Map<String, Map<String, String>> getData(String filePath, String sheetName) throws IOException {
        Map<String, Map<String, String>> outerMap = new HashMap<>();

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        // First row = headers
        Row headerRow = sheet.getRow(0);
        int colCount = headerRow.getLastCellNum();

        // Iterate rows (skip header row)
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            // First column = Testcase name
            String testcaseName = row.getCell(0).getStringCellValue();

            Map<String, String> innerMap = new HashMap<>();
            for (int j = 1; j < colCount; j++) {
                String key = headerRow.getCell(j).getStringCellValue();
                Cell cell = row.getCell(j);

                String value = "";
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING: value = cell.getStringCellValue(); break;
                        case NUMERIC: value = String.valueOf(cell.getNumericCellValue()); break;
                        case BOOLEAN: value = String.valueOf(cell.getBooleanCellValue()); break;
                        default: value = "";
                    }
                }
                innerMap.put(key, value);
            }
            outerMap.put(testcaseName, innerMap);
        }

        workbook.close();
        fis.close();
        return outerMap;
    }
}
