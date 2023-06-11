package com.JsonExample;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConfigFileReader {
	public static void main(String[] args) throws Exception {
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(new FileReader(
				"C:\\Users\\ACER\\eclipse-workspace\\Product-Order\\src\\main\\resources\\product.json"));
		JSONObject jsonObject = (JSONObject) obj;

		JSONObject orderObj = (JSONObject) jsonObject.get("order");
		JSONObject userObj = (JSONObject) orderObj.get("user");

		String username = (String) userObj.get("username");
		System.out.println("User name :" + username);

		String password = (String) userObj.get("password");
		System.out.println("Password :" + password);

//		System.out.println("User Details :" + userObj);
//		JSONObject productObj = (JSONObject) orderObj.get("product");
//		System.out.println("Product Details :" + productObj);
//		
		JSONArray product = (JSONArray) orderObj.get("product");

//		System.out.println("Product List :" + productList);

		Iterator itr = product.iterator();

		while (itr.hasNext()) {

			Object item = itr.next();
			System.out.println(item);
			JSONObject jsonObj1 = (JSONObject) item;
			JSONObject mango = (JSONObject) jsonObj1.get("mango");

			String price = (String) mango.get("amount_price");
			System.out.println("Price :" + price);

			String quantity = (String) mango.get("quantity");
			System.out.println("Quantities :" + quantity);

		}

		System.out.println("-------------------------------------------------------------------------");

		String file = "C:\\Users\\ACER\\eclipse-workspace\\Product-Order\\src\\main\\resources\\product.json";
		String result;

		result = new String(Files.readAllBytes(Paths.get(file)));

//			System.out.println(result);

		Map<String, Object> productData = new Gson().fromJson(result, new TypeToken<HashMap<String, Object>>() {
		}.getType());

		System.out.println(productData.get("mango"));

	}
}
