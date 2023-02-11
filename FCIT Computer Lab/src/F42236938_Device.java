// Turki Alqahtani 2236938 F4 
class F42236938_Device {
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//datafeild
protected String company;
protected String device_code;
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//constructors
public F42236938_Device() {
	
}
public F42236938_Device(String company, String device_code) {
	this.company = company;
	this.device_code = device_code;
}
//methods
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getDevice_code() {
	return device_code;
}
public void setDevice_code(String device_code) {
	this.device_code = device_code;
}
@Override
public String toString() {
	return "Device [company=" + company + ", device_code=" + device_code + "]";
}
}
