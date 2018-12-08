/*
 * This class is used to register a new customer or delete a customer and login a customer
 */
package backend;

public class UserManagement {
	private static UserRepository userRepository = UserRepository.getInstance();
	private static Customer currentUser;
	
	public static boolean registerUser(User user) {
		if(userRepository.getUserByEmail(user.getEmail()) != null)
			return false;
		else {
			userRepository.saveUser(user);
			return true;
		}
	}
	
	public static boolean deleteUser(User user) {
		userRepository.removeUser(user);
		return true;
	}
	
	public static boolean login(User user) {
		User u = userRepository.getUserByEmail(user.getEmail());
		if(u == null)
			return false;
		if(u.getPassword().equals(user.getPassword())){
			currentUser = new Customer(user.getEmail(), user.getPassword(), user.getAddress(), user.getPhoneNumber(), user.getCreditCardNumber());
			return true;
		}
		else
			return false;	
	}
	
	public static Customer getCurrentUser() {
		return currentUser;
	}
	
	public static void setCurrentUser(Customer user) {
		UserManagement.currentUser = user;
	}
}
