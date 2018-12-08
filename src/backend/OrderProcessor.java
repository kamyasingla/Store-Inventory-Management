/*
 * OrderProcessor gathers ordered items and processes the order by forwarding info to AccountingManager 
 */
package backend;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import backend.Order.OrderStatus;

public class OrderProcessor {
	
	public static Order gatherItems(List<OrderedItem> items) {
		List<OrderedItem> orderItems = new ArrayList<OrderedItem>();
		
		for(OrderedItem item: items) {
			if(ItemInventory.checkIfItemInStock(item.getItem(), item.getQuantity()))
				orderItems.add(item);
		}
		
		LocalDateTime dateTime = LocalDateTime.now();
		return new Order(dateTime.toString(), OrderStatus.RECEIVED, orderItems);
	}
	
	public static void processOrder(Order order) {
		AccountingManager.chargeCreditCard(order);
	}
}
