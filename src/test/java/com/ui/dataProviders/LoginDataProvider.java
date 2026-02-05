package com.ui.dataProviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.Data;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {
	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		Gson gson = new Gson();
		File testDataFile = new File(System.getProperty("user.dir") + "\\testData\\loginData.json");
		FileReader fileReader = new FileReader(testDataFile);
		Data testData = gson.fromJson(fileReader, Data.class);//deserialization
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for(User user:testData.getData()) {
			dataToReturn.add(new Object[] {user});
		}
		return dataToReturn.iterator();	
	}
	@DataProvider(name = "LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.readCsvFile("loginData.csv");
	}
	@DataProvider(name = "LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() {
		return ExcelReaderUtility.readExcelFile("loginData.xlsx");
	}
}
