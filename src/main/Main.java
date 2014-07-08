package main;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import exporter_importer.JsonIO;

public class Main {

	
	public void saveFavorites(){
		
	}
	
	public String[] updateTable(){
		JsonIO jio = new JsonIO();
		JsonObject json = jio.readJsonFromURL(19746);
		String[] data = new String[1];
		data[0] = json.get("data_id").getAsString();
		return data;
	}
	
	public DefaultTableModel updateTable(DefaultTableModel model){
		String[] columnNames = new String[model.getColumnCount()];
		for(int i = 0; i<model.getColumnCount(); i++){
			columnNames[i] = model.getColumnName(i);
		}
		JsonIO jsonIO = new JsonIO();
		JsonArray json = jsonIO.readJsonArrayFromUrl();
		DefaultTableModel tempModel = new DefaultTableModel(columnNames, json.size());
		String[] data = new String[2];
		for(int i = 0; i<json.size(); i++){
			data[0] = json.get(i).getAsJsonObject().get("data_id").getAsString();
			data[1] = null;
			tempModel.addRow(data);
		}
		return model;
	}
}

