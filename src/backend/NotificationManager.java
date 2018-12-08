/*
 * NotificationManager is used to notify the customer with mails about the order status
 */
package backend;

public class NotificationManager {

	public static void sendEmail(String email, String message) {
		System.out.println("Sending email to: " + email + " with message: " + message);
	}
}
