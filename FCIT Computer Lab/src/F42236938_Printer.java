// Turki Alqahtani 2236938 F4 
class F42236938_Printer extends F42236938_Device{
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//datafield
private String type;
private boolean isColor;
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//constructor
public F42236938_Printer(String company,String Code,String type, boolean isColor) {
	super(company,Code);
	this.type = type;
	this.isColor = isColor;
}
//methods
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public boolean isColor() {
	return isColor;
}
public void setColor(boolean isColor) {
	this.isColor = isColor;
}
@Override
public String toString() {
	//boolean to string
	String BoToSt = "";
	if (isColor)
		BoToSt = "Colored";
	else
		BoToSt = "Black&white";
	return "Company :" + company + " Color Type: " + BoToSt + "  Printer Type :"+type;
}

}
