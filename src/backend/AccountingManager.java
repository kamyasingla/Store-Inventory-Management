/*
 * AccountingManager charges a customer's credit card and sends an email to the customer
 */
package backend;

public class AccountingManager {
	
	public static void chargeCreditCard(Order order) {
		double cost = 0;
		for(OrderedItem item: order.getItems()) {
			System.out.println("Item: "+item.getItem().getProductName()+ " Cost: " + item.getItem().getCost()+" Quantity: "+ item.getQuantity());
			cost += item.getItem().getCost() * item.getQuantity();
		}
		
		System.out.println("Charged credit card for : " + cost);
		NotificationManager.sendEmail(UserManagement.getCurrentUser().getEmail(), "Your credit card has been charged for " + cost);
	}
}
