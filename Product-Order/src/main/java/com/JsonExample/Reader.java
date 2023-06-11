package com.JsonExample;

import java.io.File; // for reading file data  
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Reader {
	public static void main(String args[]) {
		ObjectMapper mapper = new ObjectMapper();
		File fileObj = new File("C:\\Users\\ACER\\eclipse-workspace\\Product-Order\\src\\main\\resources\\sample.json");
		try {
			Map<String, Object> userData = mapper.readValue(fileObj, new TypeReference<Map<String, Object>>() {
			});
			System.out.println("Name : " + userData.get("Name"));
			System.out.println("Mobile : " + userData.get("Mobile"));
			System.out.println("Designation : " + userData.get("Designation"));
			System.out.println("Pet : " + userData.get("Pet"));
			System.out.println("Address : " + userData.get("Address"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("----------------------------------");
		String local = "C:\\Users\\ACER\\eclipse-workspace\\Product-Order\\src\\main\\resources\\sample.json";
		String result;
		try {
			result = new String(Files.readAllBytes(Paths.get(local)));
			System.out.println("---->>>>>"+result);
			Map<String, Object> userData = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {
			}.getType());
			System.out.println("Name : " + userData.get("Name"));
			System.out.println("Mobile : " + userData.get("Mobile"));
			System.out.println("Designation : " + userData.get("Designation"));
			System.out.println("Pet : " + userData.get("Pet"));
			System.out.println("Address : " + userData.get("Address"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}