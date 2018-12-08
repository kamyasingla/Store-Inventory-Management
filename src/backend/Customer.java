/*
 * Customer class can browse products, select products and place order
 */
package backend;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
	public String customerUID;
	private List<Order> orders = new ArrayList<>();
	
	public Customer(String email, String password, String address, String phoneNumber, String creditCardNumber) {
		super(email, password, address, phoneNumber, creditCardNumber);
		customerUID = UUID.randomUUID().toString();
	}
	
	public void placeOrder(Order order) {
		this.orders.add(order);
		NotificationManager.sendEmail(getEmail(), "Order received successfully!");
		OrderProcessor.processOrder(order);
	}
	
	public void logOut() {
		UserManagement.setCurrentUser(null);
	}
}
