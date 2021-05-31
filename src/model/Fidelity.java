package model;

import java.util.Calendar;
import java.util.Date;

public class Fidelity {
	private Calendar dateStart;
	private int duration;
	private String description;
	private double price;
	private int reductionRate;
	
	public Fidelity(Calendar dateStart, int duration, String description, double price, int reductionRate) {
		this.dateStart = dateStart;
		this.duration = duration;
		this.description = description;
		this.price = price;
		this.reductionRate = reductionRate;
	}
	
	public Fidelity(Date dateStart, int duration, String description, double price, int reductionRate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateStart);
		this.dateStart = cal;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getReductionRate() {
		return reductionRate;
	}

	public void setReductionRate(int reductionRate) {
		this.reductionRate = reductionRate;
	}
}
