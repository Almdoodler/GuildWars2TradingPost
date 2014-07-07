import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Test {

	public static void main(String args[]) {

		try {
			JsonObject json = readJsonFromUrl("http://www.gw2spidy.com/api/v0.9/json/item/19746");
			System.out.println(json.has("data_id"));
			System.out.println(json.get("data_id"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static JsonObject readJsonFromUrl(String url) throws IOException,
			JSONException {
		InputStream is = new URL(url).openStream();
		Gson gson = new Gson();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			JsonObject json = gson.fromJson(rd, JsonObject.class);
			if(json.has("results")){
				json = json.getAsJsonObject("results");
			}else{
				json = json.getAsJsonObject("result");
			}
			return json;
		} finally {
			is.close();
		}
	}

	private static boolean saveJsonToFile(JsonObject json) {
		try {
			FileWriter file = new FileWriter("C:\\Users\\Markus Klenk\\Desktop\\temp\\test.json");
			file.write(json.toString());
			file.flush();
			file.close();
			return true;
		} catch (IOException e) {

		}
		return false;
	}
}
