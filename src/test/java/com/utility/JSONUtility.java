package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Envrironment;

public class JSONUtility {

	public static Envrironment readJSON(Env env)  {
		Gson gson = new Gson();
		File jsonFile = new File(System.getProperty("user.dir")+"\\config\\Config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		Envrironment environment = config.getEnvironments().get("QA");
		return environment;
		
		
	}

}
