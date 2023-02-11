// Turki Alqahtani 2236938 F4 
class F42236938_Mouse extends F42236938_Device{
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//data field
private String type;
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//constructor
public F42236938_Mouse (String company,String Code,String type) {
	super(company,Code);
	this.type=type;
}
//methods
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@Override
public String toString() {
	return "Company :"+company+" Mouse Type: " + type;
	
}

}
