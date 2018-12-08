/*
 * This program mocks the database to store the user email and password 
 */
package backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepository {
	public static UserRepository ur = null;
	
	private List<User> users;
	
	public static UserRepository getInstance() {
		if(ur == null)
			return new UserRepository();
		else
			return ur;
	}
	
	public UserRepository() {
		users = new ArrayList<User>();
		users.add(new User("a@email.com","a"));
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public User getUserByEmail(String email) {
		for(User u: users) {
			if(u.getEmail().equals(email))
				return u;
		}
		return null;
	}
	
	public void saveUser(User user) {
		users.add(user);
	}
	
	public void removeUser(User user) {
		for (Iterator<User> iter = users.listIterator(); iter.hasNext();) {
			if(iter.next().getEmail().equals(user.getEmail()))
				iter.remove();
		}
	}
	
}
