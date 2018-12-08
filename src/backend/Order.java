/*
 * Order class get the info about the order such as orderTime, orderStatus and orderUID
 */
package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
	public enum OrderStatus {
		RECEIVED, IN_PROGRESS, SHIPPED, DELIVERED
	}
	
	private List<OrderedItem> items = new ArrayList<>();
	
	private String orderUID;
	private String orderTime;
	private OrderStatus orderStatus;
	
	public List<OrderedItem> getItems() {
		return items;
	}

	public void setItems(List<OrderedItem> items) {
		this.items = items;
	}

	public String getOrderUID() {
		return orderUID;
	}
	
	public void setOrderUID(String orderUID) {
		this.orderUID = orderUID;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public Order(String orderTime, OrderStatus orderStatus, List<OrderedItem> items) {
		this.orderUID = UUID.randomUUID().toString();
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
		this.items = items;
	}
	
	public Order(String orderUID, String orderTime, OrderStatus orderStatus) {
		this.orderUID = orderUID;
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
	}	
}
