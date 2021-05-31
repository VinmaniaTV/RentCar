package model;

public class Category {
	private String name;
	private double price;
	private double bail;
	
	public Category(String name, double price, double bail) {
		this.name = name;
		this.price = price;
		this.bail = bail;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", price=" + price + ", bail=" + bail + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getBail() {
		return bail;
	}

	public void setBail(double bail) {
		this.bail = bail;
	}

	public Category getCategory(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
