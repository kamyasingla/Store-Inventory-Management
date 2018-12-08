/*
 * Item class gets the item details 
 */
package backend;

import java.util.UUID;

public class Item {
	private String itemUID;
	private double cost;
	private String productName;
	private String productDetails;
	
	public Item(String itemUID, double cost, String productName, String productDetails) {
		this.itemUID = itemUID;
		this.cost = cost;
		this.productName = productName;
		this.productDetails = productDetails;
	}
	
	public Item(double cost, String productName, String productDetails) {
		itemUID = UUID.randomUUID().toString();
		this.cost = cost;
		this.productName = productName;
		this.productDetails = productDetails;
	}
	
	public String getItemUID() {
		return itemUID;
	}
	public void setItemUID(String itemUID) {
		this.itemUID = itemUID;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	
	public String toString() {
		return productName;
	}
}
