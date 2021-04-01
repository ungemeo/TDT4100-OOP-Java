package inheritance;

public class TrainCar {
	
	protected Integer weightEmpty;
	
	TrainCar(int w){
		setDeadWeight(w);
	}

	//dene skal overskrides av subklasser
	int getTotalWeight(){
		return weightEmpty;
	}
	
	public void setDeadWeight(int w) {
		weightEmpty=w;
	}
	
	public int getDeadWeight() {
		return weightEmpty;
	}
}