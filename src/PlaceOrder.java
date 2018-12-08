import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import backend.ItemInventory;
import backend.Item;
import backend.*;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class PlaceOrder {

	public JFrame frame;
	private JTextField search;
	private JTextField quantity;
	private List<OrderedItem> cart = new ArrayList<>();

	/**
	 * Create the application.
	 */
	public PlaceOrder() {
		initialize();
	}
	
	private void generateItemInventory() {
		for(int i = 0; i < 10; i++) {
			Item item = new Item(100.0+i, "product"+(i+1), "product detail"+(i+1));
			ItemInventory.addNewItem(item, i+5);
		}	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		generateItemInventory();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 450, 278);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		search = new JTextField();
		search.setText("Search...");
		search.setBounds(41, 23, 284, 26);
		panel.add(search);
		search.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(ItemInventory.getItems().toArray()));
		comboBox.setBounds(189, 81, 160, 26);
		panel.add(comboBox);
		
		JLabel lblSelectProducts = new JLabel("Select Products");
		lblSelectProducts.setBounds(41, 85, 116, 16);
		panel.add(lblSelectProducts);
		
		JButton btnAddToCart = new JButton("Add To Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = (Item)comboBox.getSelectedItem();
				cart.add(new OrderedItem(item, Integer.parseInt(quantity.getText())));
				JOptionPane.showMessageDialog(frame, item.getProductName()+" added to cart successfully!");
			}
		});
		btnAddToCart.setBounds(41, 208, 117, 29);
		panel.add(btnAddToCart);
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManagement.getCurrentUser().placeOrder(OrderProcessor.gatherItems(cart));
				cart.clear();
			}
		});
		btnCheckout.setBounds(189, 208, 117, 29);
		panel.add(btnCheckout);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManagement.getCurrentUser().logOut();
				new SignIn().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnLogout.setBounds(327, 208, 117, 29);
		panel.add(btnLogout);
		
		JLabel lblLoggedInAs = new JLabel("Logged in as: " + UserManagement.getCurrentUser().getEmail());
		lblLoggedInAs.setBounds(51, 243, 255, 16);
		panel.add(lblLoggedInAs);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(41, 130, 116, 16);
		panel.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setBounds(189, 125, 160, 26);
		panel.add(quantity);
		quantity.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = ItemInventory.searchItem(search.getText());
				if(item != null) {
					comboBox.setSelectedItem(item);
				}
				else {
					JOptionPane.showMessageDialog(frame, search.getText()+" not found");
				}
			}
		});
		btnSearch.setBounds(327, 23, 117, 29);
		panel.add(btnSearch);
	}
}
