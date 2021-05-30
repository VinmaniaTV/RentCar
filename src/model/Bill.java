package model;

import java.util.Date;

public class Bill extends Rental {
	private float penalty;
	
	public Bill(int duration, float discount, boolean assurance, Date startDate, float penalty) {
		super(duration, discount, assurance, startDate);
		this.penalty = penalty;
	}

	public float getPenalty() {
		return penalty;
	}

	public void setPenalty(float penalty) {
		this.penalty = penalty;
	}
}
