/*
 * ItemInventory lets a customer browse items and checks if the item is in stock for the order and can also be used to
 * add or delete items
 */
package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ItemInventory {
	private static Map<String, Integer> stock = new HashMap<>();
	private static List<Item> itemList = new ArrayList<>();
	
	public static Item searchItem(String productName) {
		for(Item item : itemList) {
			if(item.getProductName().contains(productName))
				return item;
		}
		return null;
	}
	
	public static boolean checkIfItemInStock(Item item, int mStock) {
		if(stock.containsKey(item.getItemUID()) && stock.get(item.getItemUID())- mStock > 0)
			return true;
		else
			return false;
	}
	
	public static void addNewItem(Item item, int mStock) {
		itemList.add(item);
		stock.put(item.getItemUID(), mStock);
	}
	
	public static void removeItem(Item item, int mStock) {
		int a;
		if(stock.containsKey(item.getItemUID()) && (a = stock.get(item.getItemUID())) > 0) {
			a -= mStock;
			if(a <= 0 ) {
				stock.remove(item.getItemUID());
				removeByUID(item.getItemUID());
			} else  {
				stock.put(item.getItemUID(), a);
			}
		}
	}
	
	private static void removeByUID(String uid) {
		for(Iterator<Item> iterator = itemList.iterator(); iterator.hasNext();) {
			if(iterator.next().getItemUID().equals(uid))
				iterator.remove();
		}	
	}
	
	public static List<Item> getItems() {
		return itemList;
	}

}
