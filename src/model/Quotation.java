package model;

public class Quotation {
	private int duration;
	private float discount;
	private boolean assurance;
	
	public Quotation(int duration, float discount, boolean assurance) {
		this.duration = duration;
		this.discount = discount;
		this.assurance = assurance;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public boolean isAssurance() {
		return assurance;
	}

	public void setAssurance(boolean assurance) {
		this.assurance = assurance;
	}
}
