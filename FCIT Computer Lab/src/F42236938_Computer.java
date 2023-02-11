// Turki Alqahtani 2236938 F4 
import java.util.ArrayList;
class F42236938_Computer extends F42236938_Device implements F42236938_Comparable<F42236938_Computer> {
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//date fields
private double speed;
private String modelName;
private ArrayList<F42236938_Software> software = new ArrayList<>();
private F42236938_Mouse mouse;
private F42236938_Printer printer;
private int totalSofware;
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//constructor
public F42236938_Computer (String company, String Code, String modelName, double speed) {
	super(company,Code);
	this.modelName = modelName;
	this.speed = speed;
}
//methods
public double getSpeed() {
	return speed;
}
public void setSpeed(double speed) {
	this.speed = speed;
}
public String getModelName() {
	return modelName;
}
public void setModelName(String modelName) {
	this.modelName = modelName;
}
public ArrayList<F42236938_Software> getSoftware() {
	return software;
}
public void setSoftware(F42236938_Software software) {
	this.software.add(software);
}
public F42236938_Mouse getMouse() {
	return mouse;
}
public void setMouse(F42236938_Mouse mouse) {
	this.mouse = mouse;
}
public F42236938_Printer getPrinter() {
	return printer;
}
public void setPrinter(F42236938_Printer printer) {
	this.printer = printer;
}
public int getNumSoftware() {
	return totalSofware;
}
//************ in the interface class to the given uml is int return, and in computer class to the given uml in pdf is computer return. that means it's 100% wrong from pdf
public int compareTo(F42236938_Computer c1) {
	//faster return 1, equal return 0, slower return -1
	if(speed > c1.getSpeed()) {
		return 1;
	}
	else if (speed == c1.getSpeed()) {
		return 0;
	}
	else {
		return -1;
	}
}
@Override
public String toString() {
	return "Company :"+company +"  Model: " + modelName;
}



}
