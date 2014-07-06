package main;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JsonIO {

	public boolean saveJsonToFile(JsonObject json) {
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

	public JsonObject readJsonFromUrl(String url) throws IOException,
			JSONException {
		InputStream is = new URL(url).openStream();
		Gson gson = new Gson();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			JsonObject json = gson.fromJson(rd, JsonObject.class);
			return json;
		} finally {
			is.close();
		}
	}

}
