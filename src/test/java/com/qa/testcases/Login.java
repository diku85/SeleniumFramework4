package com.qa.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utils.ExcelReader;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Login {

	String filePath = "src/test/resources/Login.xlsx";
	Map<String,Map<String, String>> dataMap;
	
	//commit feature changes-1
	
	@BeforeClass
	public void setup() throws IOException {
		System.out.println("inside before class");
		dataMap = ExcelReader.getData(filePath, "Sheet1");
		System.out.println(dataMap);
	}
	
	@Test
	public void TC1() throws IOException {
		System.out.println("TC1");
		System.out.println(dataMap.get("TC1").get("LOB"));
		System.out.println(dataMap.get("TC1").get("Category"));

	}
	
	@Test
	public void TC2() throws IOException {
		System.out.println("TC2");
		System.out.println(dataMap.get("TC2").get("LOB"));
		System.out.println(dataMap.get("TC2").get("Category"));

	}

}
