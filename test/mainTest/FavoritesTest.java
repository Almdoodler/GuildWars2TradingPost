package mainTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import data.Favorites;

public class FavoritesTest {
	
	Favorites fav;
	
	@Before
	public void initialize(){
		fav = new Favorites();
	}

	@Test
	public void addListTest() {
		fav.addNewFavoritList("Test1", "TestText1");
		fav.addNewFavoritList("Test2", "TestText2");
		assertEquals(2, fav.numLists());
	}
	
	@Test
	public void deleteListTest(){
		fav.addNewFavoritList("Test1", "TestText1");
		fav.addNewFavoritList("Test2", "TestText2");
		assertEquals(2, fav.numLists());
		fav.deleteFavoriteList("Test1");
		assertEquals(1, fav.numLists());
	}
}
