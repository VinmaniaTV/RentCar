package model;

import java.util.Date;

public class Bill extends Rental {
	private float penalty;
	
	public Bill(int duration, float discount, boolean assurance, Date startDate, float penalty) {
		super(duration, discount, assurance, startDate);
		this.penalty = penalty;
	}
	
	public int penality(Vehicle vehicle) {
		int penality = 0;
		if (vehicle.getFuelQuantity() == 0) {
			return penality+=100;
		}
		if (vehicle.getFuelQuantity() <= vehicle.getFuelQuantity()/4 & vehicle.getFuelQuantity()>=0) {
			return penality+=80;
		}
		if (vehicle.getFuelQuantity() <= vehicle.getCapacityFuel()/2 & vehicle.getFuelQuantity()>=vehicle.getCapacityFuel()/4) {
			return penality+=50;
		}
		if (vehicle.getFuelQuantity() <= 3*vehicle.getCapacityFuel()/4 & vehicle.getFuelQuantity()>=vehicle.getCapacityFuel()/2) {
			return penality+=25;
		}
		else {
		return penality;
		}
	}

	public float getPenalty() {
		return penalty;
	}

	public void setPenalty(float penalty) {
		this.penalty = penalty;
	}
}
