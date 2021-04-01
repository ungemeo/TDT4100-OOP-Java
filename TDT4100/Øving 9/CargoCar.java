package inheritance;

public class CargoCar extends TrainCar{
	
	private int cargo;
	
	CargoCar(int w, int c){
		super(w);
		setCargoWeight(c);
	}

	
	 int getCargoWeight(){
		 return cargo;
	 }
	 
	void setCargoWeight(int c) {
		cargo=c;		
	}	
	
	@Override
	int getTotalWeight(){
		return getDeadWeight() + getCargoWeight();
	}
}