package exporter_importer;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonIO {

	/**
	 * Saves given JsonObject at given location
	 * 
	 * @param json
	 * @return true if saving the object was successfully
	 * @throws IOException
	 */
	public boolean saveJsonToFile(JsonObject json) throws IOException {
		try {
			FileWriter file = new FileWriter(
					"C:\\Users\\Markus Klenk\\Desktop\\temp\\test.json");
			file.write(json.toString());
			file.flush();
			file.close();
			return true;
		} catch (IOException e) {

		}
		return false;
	}

	/**
	 * Retrieves JsonObject from given URL
	 * 
	 * @param itemID
	 * @return JsonObject retrieved from URL
	 * @throws IOException
	 * @throws JSONException
	 */
	public JsonObject readJsonFromURL(int itemID) {
		String url = "http://www.gw2spidy.com/api/v0.9/json/item/" + itemID;
			JsonObject json = loadJsonFromURL(url);
			json = json.getAsJsonObject("result");
			return json;
	}
	
	public JsonArray readJsonArrayFromUrl(){
		JsonObject json = loadJsonFromURL("http://www.gw2spidy.com/api/v0.9/json/all-items/*all*");
		JsonArray jsonArray = json.get("results").getAsJsonArray();
		return jsonArray;
	}
	
	private JsonObject loadJsonFromURL(String url){
		InputStream is = null;
			try {
				is = new URL(url).openStream();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Gson gson = new Gson();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			JsonObject json = gson.fromJson(rd, JsonObject.class);
		return json;
	}

}
