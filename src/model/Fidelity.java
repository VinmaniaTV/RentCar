package model;

import java.util.Calendar;

public class Fidelity {
	private Calendar dateStart;
	private int duration;
	private String description;
	private float price;
	private int reductionRate;
	
	public Fidelity(Calendar dateStart, int duration, String description, float price, int reductionRate) {
		this.dateStart = dateStart;
		this.duration = duration;
		this.description = description;
		this.price = price;
		this.reductionRate = reductionRate;
	}

	public Calendar getDateStart() {
		return dateStart;
	}

	public void setDateStart(Calendar dateStart) {
		this.dateStart = dateStart;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getReductionRate() {
		return reductionRate;
	}

	public void setReductionRate(int reductionRate) {
		this.reductionRate = reductionRate;
	}
}
