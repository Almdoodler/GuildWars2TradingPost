package data;

import java.util.Iterator;
import java.util.LinkedList;

public class Favorites {
	
	private LinkedList<FavoriteList> favorites;
	
	public Favorites(){
		favorites = new LinkedList<FavoriteList>();
	}
	
	public boolean addNewFavoritList(String name, String description){
		if(isDuplicate(name) == false){
			favorites.add(new FavoriteList(name, description));
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean deleteFavoriteList(String name){
		Iterator<FavoriteList> iter = favorites.iterator();
		int pos = -1;
		while(iter.hasNext()){
			pos++;
			if(iter.next().getName().equals(name)){
				break;
			}
		}
		System.out.println(pos);
		if(pos != -1){
			
			favorites.remove(pos);
			return true;
		}else{
			return false;
		}
	}
	
	public int numLists(){
		return favorites.size();
	}
	
	private boolean isDuplicate(String name){
		Iterator<FavoriteList> iter = favorites.iterator();
		while(iter.hasNext()){
			if(iter.next().getName().equals(name)){
				return true;
			}
		}
		return false;
	}

}
