package inheritance;

public class PassengerCar extends TrainCar{
	
	private int count;
	
	PassengerCar(int w, int c){
		super(w);
		setPassengerCount(c);
	}

	
	 int getPassengerCount(){
		 return count;
	 }
	 
	void setPassengerCount(int c) {
		count=c;		
	}	
	
	@Override
	int getTotalWeight(){
		return getDeadWeight() + getPassengerCount()*80;
	}
}