package model;

import java.util.Date;

public class Rental extends Quotation {
	private Date startDate;
	
	public Rental(int duration, float discount, boolean assurance, Date startDate) {
		super(duration, discount, assurance);
		this.startDate = startDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
