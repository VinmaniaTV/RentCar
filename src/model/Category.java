package model;

public class Category {
	private String name;
	private float price;
	private float bail;
	
	public Category(String name, float price, float bail) {
		this.name = name;
		this.price = price;
		this.bail = bail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getBail() {
		return bail;
	}

	public void setBail(float bail) {
		this.bail = bail;
	}
}
