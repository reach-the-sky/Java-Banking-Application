import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


class Banking {
	int account_no = 1;
	String first_name = "Ling",last_name = "chan",address = "HB colony, Vizag",aadhar_number = "3452343324";
	int amount = 1000000;
	
	
	@SuppressWarnings("unchecked")
	void json_create()
	{
		JSONObject client = new JSONObject();	
		client.put("First_name", this.first_name);
		client.put("Last_name", this.last_name);
		client.put("Address", address);
		client.put("Aadhar_number", aadhar_number);
		client.put("Amount", this.amount);
		
		JSONObject obj = new JSONObject();
		obj.put(String.valueOf(this.account_no), client);
		
		try
		{
			FileWriter file = new FileWriter("client.json");
			file.write(obj.toJSONString());
			file.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	void json_add(int account_no,String first_name,String last_name,String address,String aadhar_number,int amount)
	{
		JSONObject client = new JSONObject();	
		client.put("First_name", first_name);
		client.put("Last_name", last_name);
		client.put("Address", address);
		client.put("Aadhar Number", aadhar_number);
		client.put("Amount", amount);
		
		 try (FileReader reader = new FileReader("client.json")) {
		        JSONParser parser = new JSONParser();
		        JSONObject data = (JSONObject) parser.parse(reader);
		        data.put(String.valueOf(account_no),client);
		        
		        @SuppressWarnings("resource")
		        FileWriter file = new FileWriter("client.json");
		        file.write(data.toJSONString());
		        file.flush();
		        file.close();

		    } catch (IOException e) {
		        e.printStackTrace();
		       } catch (ParseException e1) {
		            e1.printStackTrace();
		       }
		   }
	}
 