package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Train {
	
	List<TrainCar> train = new ArrayList<TrainCar>();
	
	void addTrainCar(TrainCar t){
		train.add(t);
	}
	
	boolean contains(TrainCar t){
		if (train.contains(t)){
			return true;
		}
		return false;
	}
	
	int getTotalWeight(){
		int totalWeight = 0;
		
		for (TrainCar t : train){
			totalWeight += t.getTotalWeight();
		}
		
		return totalWeight;
	}
	
	int getPassengerCount(){
		int totalPassengerCount = 0;
		
		for (TrainCar t : train){
			if (t instanceof PassengerCar){
				totalPassengerCount += ((PassengerCar) t).getPassengerCount();
			}	
		}
		return totalPassengerCount;
	}
	
	int getCargoWeight(){
		int totalCargoWeight = 0;
		
		for (TrainCar t : train){
			if (t instanceof CargoCar){
				totalCargoWeight += ((CargoCar) t).getCargoWeight();
			}	
		}
		return totalCargoWeight;
	}

	@Override
	public String toString() {
		return "Train [train=" + train + ", getTotalWeight()="
				+ getTotalWeight() + ", getPassengerCount()="
				+ getPassengerCount() + ", getCargoWeight()="
				+ getCargoWeight() + ", getClass()=" + getClass() + "]";
	}
	
	
	
}