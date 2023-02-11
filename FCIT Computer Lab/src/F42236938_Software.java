// Turki Alqahtani 2236938 F4 
class F42236938_Software extends F42236938_Device{
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//datafeild
private String name;
private double version;
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//constructor
public F42236938_Software(String company, String Code, String name, double version) {
	super(company,Code);
	this.name = name;
	this.version = version;
}
//methods
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getVersion() {
	return version;
}
public void setVersion(double version) {
	this.version = version;
}
@Override
public String toString() {
	return "S/W name: " + name + " S/W version: " + version;
}
}
