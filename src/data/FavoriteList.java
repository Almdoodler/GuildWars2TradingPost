package data;

import java.util.Iterator;

import java.util.LinkedList;

/**
 * Stores users favorite Items in a LinkedList, including name and list description;
 * 
 * @author Markus Klenk
 *
 */
public class FavoriteList {
	
	private LinkedList<Integer> itemList;
	private String name;
	private String description;
	
	public FavoriteList(String name, String description){
		itemList = new LinkedList<Integer>();
		this.name = name;
		this.description = description;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean addItem(int itemID){
		if(isDuplicate(itemID) == false){
			itemList.add(itemID);
			return true;
		}else{
			return false;
		}
	}

	private boolean isDuplicate(int itemID) {
		Iterator<Integer> iter = itemList.iterator();
		while(iter.hasNext()){
			if(iter.next() == itemID){
				return true;
			}
		}
		return false;
	}

}
