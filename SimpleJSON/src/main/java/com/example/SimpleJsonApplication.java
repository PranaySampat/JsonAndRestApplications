package com.example;
import java.io.FileNotFoundException;
/**
 * 
 * Reference on mykong.com
 * @author pranaysampat
 */
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





public class SimpleJsonApplication {

	public static void main(String[] args) throws ParseException, org.json.simple.parser.ParseException {
		//SpringApplication.run(SimpleJsonApplication.class, args);
		JSONParser parser  = new JSONParser();
		try{
			//reading the json schema
			Object obj = parser.parse(new FileReader("/Users/pranaysampat/Desktop/test.json"));
			JSONObject jsonObject = (JSONObject) obj;
			String name = (String) jsonObject.get("name");
			System.out.println(name);
			long age = (Long) jsonObject.get("age");
			System.out.println(age);
			
			//array of messages
			
			JSONArray msg = (JSONArray) jsonObject.get("messages");
			Iterator<String> iterator = msg.iterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next());
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	
}
}
