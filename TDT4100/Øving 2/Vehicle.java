package encapsulation;

public class Vehicle {
	
	private char typeVehicle;
	private char fuel;
	private String registration;
	
	public Vehicle(char typeVehicle, char fuel, String registration) {
		if (!((typeVehicle == 'M') || (typeVehicle == 'C'))) {
			throw new IllegalArgumentException("Vehicle type is invalid. Please enter either \'C' for car or \'M' for motorbike."); 
		}
		this.typeVehicle = typeVehicle;
		if (!((fuel == 'H') || (fuel == 'E') || (fuel == 'D') || (fuel == 'G'))) {
			throw new IllegalArgumentException("Fuel must be either hydrogen, electricity, diesel or gasoline.");
		}
		else if ((fuel == 'H') && (typeVehicle == 'M')) {
			throw new IllegalArgumentException("Only cars may use hydrogen as fuel.");
		} 
		this.fuel = fuel;
		
		setRegistrationNumber(registration);
	}
	
	
	public void setRegistrationNumber(String registration) {

		if (typeVehicle == 'C') {
			if (fuel == 'H') {
				if (registration.matches("HY[0-9]{5}")) {
					this.registration = registration;
				}
				else {
					throw new IllegalArgumentException("Registration is wrong in correspondance to fuel type and or vehicle type.");
				}
			}
			else if (fuel == 'E') {
				if (registration.matches("EL[0-9]{5}") || registration.matches("EK[0-9]{5}")) {
					this.registration = registration; 
				} 
				else 
					throw new IllegalArgumentException("Registration is wrong in correspondance to fuel type and or vehicle type.");
			}
			else if ((registration.matches("[A-Z]{2}[0-9]{5}") && (!registration.matches("EL[0-9]{5}") && (!registration.matches("EK[0-9]{5}")) && (!registration.matches("HY[0-9]{5}"))))) {
				this.registration = registration;
			}
			else {
				throw new IllegalArgumentException("Registration is wrong in correspondance to fuel type and or vehicle type.");
			}
		}
		
		else {
			if (fuel == 'E') {
				if (registration.matches("EL[0-9]{4}") || registration.matches("EK[0-9]{4}"))
					this.registration = registration;
				else 
					throw new IllegalArgumentException("Registration is wrong in correspondance to fuel type and or vehicle type.");	
				}
			else if ((registration.matches("[A-Z]{2}[0-9]{4}") && (!registration.startsWith("EL") && (!registration.startsWith("EK")) && (!registration.matches("HY[0-9]{4}"))))) {
				this.registration = registration;
			}
			else {
				throw new IllegalArgumentException("Registration is wrong in correspondance to fuel type and or vehicle type.");
			}
		}
	}
	
	public String getRegistrationNumber() {
		return registration;
	}
	
	public char getVehicleType() {
		return typeVehicle;
	}
	
	public char getFuelType() {
		return fuel;
	}
}
