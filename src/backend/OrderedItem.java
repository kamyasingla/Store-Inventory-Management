/*
 * OrderedItem contains the ordered item and the quantity of the ordered item 
 */
package backend;

public class OrderedItem {
	private Item item;
	private Integer quantity;
	
	public OrderedItem(Item item, Integer quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
