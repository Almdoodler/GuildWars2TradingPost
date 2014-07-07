package exporter_importer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import data.Favorites;

public class FavoriteListIO {

	public boolean saveFavoritesToFile(Favorites favorites) {

		Writer writer = null;
		try {
			File file = new File(
					"C:\\Users\\Markus Klenk\\Desktop\\temp\\test.txt");
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));
			writer.write("Test");
			writer.flush();
			writer.close();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static void main(String[] args) {
		FavoriteListIO io = new FavoriteListIO();
		io.saveFavoritesToFile(null);
	}

}
