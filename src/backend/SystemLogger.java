/*
 * SystemLogger logs the order details with order time, order UID and order status
 */
package backend;

import java.util.ArrayList;
import java.util.List;

public class SystemLogger {
	public static List<String> logs = new ArrayList<>();
	
	public static void writeLog(Order order) {
		String orderLog = "Order with UID: " + order.getOrderUID() + 
				" placed on: " + order.getOrderTime() + " with order status: " + order.getOrderStatus().toString();
		System.out.println("Saved to log: " + orderLog);
		logs.add(orderLog);
	}
	
	public static List<String> getLog() {
		return logs;
	}
}
