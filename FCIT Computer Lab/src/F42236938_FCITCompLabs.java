// Turki Alqahtani 2236938 F4 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

class F42236938_FCITCompLabs {
	//creating array list 
	public static ArrayList<F42236938_Device> devicelist = new ArrayList<F42236938_Device>();
	public static void main(String[] args) throws FileNotFoundException {
		//creating files
		File inputfile = new File("fcitInput.txt");
		File outputfile = new File("fcitOutPutLab.txt");
		File reportfile = new File ("fcitReportLab.txt");
		//check if input file exist
		if (!inputfile.exists()) {
			System.out.print("File Not Found");
			System.exit(0);
		}
		//creating scanner and printwriter
		Scanner read1 = new Scanner(inputfile);
		PrintWriter printoutput = new PrintWriter(outputfile);
		PrintWriter printreport = new PrintWriter(reportfile);
		
		
		printoutput.print("Welcome to the FCIT Lab  System.\n");
		//creating current date and put it in the format
		Date date = new Date();
		SimpleDateFormat simple1 = new SimpleDateFormat("EEE MMM d HH:mm:ss");
		SimpleDateFormat simple2 = new SimpleDateFormat("y");
		printoutput.print("Today Date is "+ simple1.format(date) + " GMT+03:00 " + simple2.format(date) + "\n\n");
		//this step will use it in the last**************
		int numofcomp = 0;
		//loop
		while(true) {
			//command
			String command = read1.next();
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//add commputer command
			if (command.equals("Add_Computer")) {
				//reading
				String Company = read1.next();
				double speed = read1.nextDouble();
				String model = read1.next();
				String code = read1.next();
				//save it on array list
				devicelist.add(new F42236938_Computer (Company,code,model,speed));
				//output
				printoutput.println("**************************************************************************************************************");
				printoutput.print("Command: Add_Computer\n\n");
				printoutput.print("\nComputer Details \n");
				printoutput.print("Company :"+Company + "  Model: " + model + "  Speed: "+speed+ " GHz \n");
				printoutput.print("-- Following Softwares are Installed in the Machine ---\n");
				printoutput.print(" No Software has been installed\n");
				printoutput.print("--- Following  Peripheral are  attached in the Machine ---\n");
				printoutput.print(" No Pripheral has been attached\n\n");
				printoutput.print(" has been added to the FCIT Lab. Database.\n\n");
				//counting how many computers we saved.
				numofcomp++;
			}
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//command
			else if (command.equals("Add_Printer")) {
				//reading
				String Company = read1.next();
				String printertype = read1.next();
				boolean printercolor = read1.nextBoolean();
				String printercode = read1.next();
				//saving to arraylist
				devicelist.add(new F42236938_Printer (Company,printercode,printertype,printercolor));
				//output
				printoutput.println("**************************************************************************************************************");
				printoutput.print("Command: Add_Printer\n\n\n");
				printoutput.print("Printer Details \n \n");
				// Boolean to string **********
				String BoToSt = "";
				if(printercolor)
					BoToSt = "Colored";
				else
					BoToSt = "Black&white";
				printoutput.print("Company :"+Company+ " Color Type: " + BoToSt+ "  Printer Type :"+ printertype+"\n\n");
				printoutput.print(" has been added to the FCIT Lab. Database.\n\n");
			}
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//command
			else if (command.equals("Add_Mouse")) {
				//reading
				String Company = read1.next();
				String mousetype = read1.next();
				String mousecode = read1.next();
				//saving to arraylist
				devicelist.add(new F42236938_Mouse (Company,mousecode,mousetype));
				//output
				printoutput.println("**************************************************************************************************************");
				printoutput.print("Command: Add_Mouse\n\n\n");
				printoutput.print("Mouse Details \n\n");
				printoutput.print("Company :" + Company + " Mouse Type: " + mousetype+"\n\n");
				printoutput.print(" has been added to the FCIT Lab. Database.\n\n");
			}
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//command
			else if (command.equals("Add_Software")) {
				//reading
				String name = read1.next();
				double version = read1.nextDouble();
				String code = read1.next();
				//saving
				devicelist.add(new F42236938_Software (null,code,name,version));
				//output
				printoutput.println("**************************************************************************************************************");
				printoutput.print("Command: Add_Software\n\n\n");
				printoutput.print("Software Details \n\n");
				printoutput.print("S/W name: "+ name + " S/W version: "+version + "\n\n");
				printoutput.print(" has been added to the FCIT Lab. Database.\n\n");
			}
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//command
			else if (command.equals("Install_SW")) {
				//reading
				String computercode = read1.next(); 
				String softwarecode = read1.next();
				// here we initialize index of computer and software
				int ctoken = 0;
				int stoken = 0;
				//loop to check all devicelist objects and get their device code to check if it's equal to the given computer code or software code
				for (int i = 0 ; i < devicelist.size() ; i++) {
					//if yes then we get their index
					if (devicelist.get(i).getDevice_code().equals(computercode)) {
						ctoken= i;
						
					}
					if (devicelist.get(i).getDevice_code().equals(softwarecode)) {
						stoken = i;
					}
				}
				//this is extra step no need to put it. because we already checked their codes.
				if (devicelist.get(ctoken) instanceof F42236938_Computer) {
					
					if (devicelist.get(stoken)instanceof F42236938_Software) {
						//saving to objects to use their methods
						F42236938_Computer c = (F42236938_Computer) devicelist.get(ctoken);
						F42236938_Software s = (F42236938_Software) devicelist.get(stoken);
						//output
						printoutput.println("**************************************************************************************************************");
						printoutput.print("Command: Install_SW\n\n");
							//must be less than 5<-------- *****in The assaignment pdf is incorrect it must be less than 5 not equal, to be matched with the output example********** software installed in the computer software arraylist
							if(c.getSoftware().size()<5) {
								//check if software is not saved to prevent duplication
								if (!(c.getSoftware().contains(s))) {
									//saving the software
									c.setSoftware(s);
									printoutput.print("The S/W "+ s.getName() + "  has been installed in the The computer  Company : " + c.getCompany() + "  Model: "+c.getModelName()+"\n");
									
								}
								//else means there is already software installed.
								else {
									printoutput.print("The computer  Company : "+ c.getCompany() + "  Model: " +c.getModelName() +"\nhas already S/W "+ s.getName() + "  installed..\n");
								}
							}
							//else means that it has more than 4 ******** pdf is incorrect
							else {
								printoutput.print("The computer  Company : " + c.getCompany() + "  Model: " + c.getModelName() + "\nhas 5 S/W installed.. You can not install any S/W\n");
							}
					}
				}
				
			}
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//comand
			else if(command.equals("Install_printer")) {
				//reading
				String computercode = read1.next(); 
				String printercode = read1.next();
				//initialize index
				int ctoken = 0;
				int ptoken = 0;
				//loop to get index of computer and printer
				for (int i = 0 ; i < devicelist.size() ; i++) {
					if (devicelist.get(i).getDevice_code().equals(computercode)) {
						ctoken= i;
						
					}
					if (devicelist.get(i).getDevice_code().equals(printercode)) {
						ptoken = i;
					}
				}
				//extra step
				if (devicelist.get(ctoken) instanceof F42236938_Computer) {
					if (devicelist.get(ptoken) instanceof F42236938_Printer) {
						//saving to objects to use their methods
						F42236938_Computer c = (F42236938_Computer) devicelist.get(ctoken);
						F42236938_Printer p = (F42236938_Printer) devicelist.get(ptoken);
						printoutput.println("**************************************************************************************************************");
						printoutput.print("Command: Install_printer\n\n");
						//must be clear or not same printer to avoid duplication
						if(c.getPrinter()==null || c.getPrinter()!=p){
							c.setPrinter(p);
							printoutput.print("The Printer " + c.getPrinter().getCompany() + "  Printer Type :"+c.getPrinter().getType() +"  has been attached to the The computer  Company : "+c.getCompany() + "  Model: " + c.getModelName()+"\n" );
						}
						else {
							printoutput.print("The computer  Company : "+c.getCompany() + "  Model: " + c.getModelName()+"\n" + "has already attached to Printer "+c.getPrinter().getCompany() + "  Printer Type :"+c.getPrinter().getType() + "\n");
						}
					}
				}
			}
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//same logic as before
			else if (command.equals("Install_mouse")) {
				String computercode = read1.next(); 
				String mousecode = read1.next();
				int ctoken = 0;
				int mtoken = 0;
				for (int i = 0 ; i < devicelist.size() ; i++) {
					if (devicelist.get(i).getDevice_code().equals(computercode)) {
						ctoken= i;
						
					}
					if (devicelist.get(i).getDevice_code().equals(mousecode)) {
						mtoken = i;
					}
				}
				if (devicelist.get(ctoken) instanceof F42236938_Computer) {
					if (devicelist.get(mtoken) instanceof F42236938_Mouse) {
						F42236938_Computer c = (F42236938_Computer) devicelist.get(ctoken);
						F42236938_Mouse m = (F42236938_Mouse) devicelist.get(mtoken);
						printoutput.println("**************************************************************************************************************");
						printoutput.print("Command: Install_mouse\n\n");
						if(c.getMouse()==null || c.getMouse()!=m){
							c.setMouse(m);
							printoutput.print("The Mouse " + c.getMouse().getCompany() + "  "+c.getMouse().getType() +"  has been attached to the The computer  Company : "+c.getCompany() + "  Model: " + c.getModelName()+"\n" );
						}
						else {
							printoutput.print("The computer  Company : "+c.getCompany() + "  Model: " + c.getModelName()+"\n" + "has already attached to Mouse "+ c.getMouse().getCompany() + "  "+c.getMouse().getType()  + "\n");
						}
					}
				}
			}
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//command
			else if (command.equals("UnInstall_SW")) {
				//samelogic
				String computercode = read1.next(); 
				String softwarecode = read1.next();
				int ctoken = 0;
				int stoken = 0;
				for (int i = 0; i < devicelist.size() ; i++) {
					if (devicelist.get(i).getDevice_code().equals(computercode)) {
						ctoken= i;
						
					}
					if (devicelist.get(i).getDevice_code().equals(softwarecode)) {
						stoken = i;
					}
				}
				if (devicelist.get(ctoken) instanceof F42236938_Computer) {
					
					if (devicelist.get(stoken)instanceof F42236938_Software) {
						F42236938_Computer c = (F42236938_Computer) devicelist.get(ctoken);
						F42236938_Software s = (F42236938_Software) devicelist.get(stoken);
						printoutput.println("**************************************************************************************************************");
						printoutput.print("Command: UnInstall_SW\n\n");
						//we need to check if it contains the object to remove it
						if (c.getSoftware().contains(s)){
							//remove command if true that means he removed it
							if (c.getSoftware().remove(s)) {
								printoutput.print("The S/W " + s.getName() + "  has been uninstalled from the The computer  Company : "+ c.getCompany() + "  Model: "+c.getModelName() + "\n");
							}
						}
						else {
							printoutput.print("The Software : " + s.getName() + "  is not installed \nin The computer  Company : "+ c.getCompany() + "  Model: "+c.getModelName() +"\n");
						}
						
							
					}
				}
			}
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//command
			else if (command.equals("List_All_Computer_Configuration")) {
				printreport.println("**************************************************************************************************************");
				printreport.print("Command: List_All_Computer_Configuration");
				//**here why we need to use numofcomp variable
				//loop depends of how many computers
				for(int i =1 ; i <= numofcomp ; i++) {
					//computer No i. i = loop index
					printreport.print("\n\n---------Computer No "+i+" ---------\n\n\n");
					//we get the computer code c + indext of computer, for ex: first iteration = c1 
					String computercode = "c"+i;
					//initialize index
					int index =0;
					//loop to search which devicelist array contains computer code to take the index
					for (int k = 0; k < devicelist.size() ; k++) {
						if (devicelist.get(k).getDevice_code().equals(computercode)) {
							index= k;
							
						}
					}
					//saving it to object to use their methods
					F42236938_Computer c = (F42236938_Computer) devicelist.get(index);
					printreport.print("Computer Details \n"+ c.toString() + "  Speed: "+c.getSpeed()+" GHz \n");
					printreport.print("-- Following Softwares are Installed in the Machine ---");
					//check if software is not empty
					if(!c.getSoftware().isEmpty()) {
						//printing softwares on their size
						for(int f = 0; f<c.getSoftware().size() ; f++) {
							printreport.print("\n\nSoftware Details \n\n");
							printreport.print(c.getSoftware().get(f).toString()+"\n");
							
						}
						
					}
					//else means that the software is empty
					else {
						printreport.print("\n No Software has been installed\n");
					}
					printreport.print("--- Following  Peripheral are  attached in the Machine ---");
					//we must check that either one of mouse or printer is not empty
					if ((c.getMouse() != null) || c.getPrinter() != null) {
						if (c.getMouse() != null) {
							printreport.print("\n\nMouse Details \n\n" + c.getMouse().toString()+"\n");
						}
						if (c.getPrinter()!= null) {
							printreport.print("\n\nPrinter Details \n \n" + c.getPrinter().toString()+"\n");
						}
					}
					//means that mouse and printer are empty
					else {
						printreport.print("\n No Pripheral has been attached");
					}
					printreport.print("\n");
				}
			}
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//command
			else if (command.equals("List_Computer_With_SW")) {
				//reading
				String SW = read1.next();
				printreport.print("\n**************************************************************************************************************\n");
				printreport.print("Command: List_Computer_With_Microsoft_Software\n");
				//same logic as before
				for(int i = 1 ; i <= numofcomp ; i++) {
					String computercode = "c"+i;
					int index =0;
					for (int k = 0; k < devicelist.size() ; k++) {
						if (devicelist.get(k).getDevice_code().equals(computercode)) {
							index= k;
							
						}
					}
					F42236938_Computer c = (F42236938_Computer) devicelist.get(index);
					//loop in software size
					for(int k = 0 ; k <c.getSoftware().size() ; k++) {
						//check if the software name is equals to the given one
						if(c.getSoftware().get(k).getName().equals(SW)) {
							printreport.print("\n---------Computer No "+i+" ---------\n");
							printreport.print("\nThe computer  "+c.toString()+"\n");
						}
					}
				}
			}
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//command
			else if(command.equals("List_Computer_Speed_>")) {
				//reading
				int speed = read1.nextInt();
				printreport.print("\n**************************************************************************************************************\n");
				printreport.print("Command: List_Computer_With_Speed_above_"+speed +"\n");
				//same logic as before
				for(int i = 1 ; i <= numofcomp ; i++) {
					String computercode = "c"+i;
					int index =0;
					for (int k = 0; k < devicelist.size() ; k++) {
						if (devicelist.get(k).getDevice_code().equals(computercode)) {
							index= k;
							
						}
					}
					F42236938_Computer c = (F42236938_Computer) devicelist.get(index);
					//check if the computer speed is faster than to the given one
					if(c.getSpeed() > speed) {
						printreport.print("\n---------Computer No "+i+" ---------\n");
						printreport.print("\nThe computer  "+c.toString()+"\n");
					}
				}
			}
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//command
			else if(command.equals("Compare_Computer_Speed")) {
				//reading
				String computercode1 = read1.next();
				String computercode2 = read1.next();
				int index1 = 0;
				int index2 = 0;
				//same logic as before
				for(int i = 0 ; i < devicelist.size() ; i++) {
					if (devicelist.get(i).getDevice_code().equals(computercode1)) {
						index1= i;	
					}
					if (devicelist.get(i).getDevice_code().equals(computercode2)) {
						index2= i;	
					}
				}
				F42236938_Computer c1 = (F42236938_Computer) devicelist.get(index1);
				F42236938_Computer c2 = (F42236938_Computer) devicelist.get(index2);
				//returning int number on compareto method
				int result = c2.compareTo(c1);
				//initializing int to string 
				String ResultString = "";
				//if 1 means faster if 0 means equal if -1 means slower
				if(result ==1) {
					ResultString = " ****** Faster**** than ";
				}
				else if (result ==0) {
					ResultString = " ****** Equal****  ";
				}
				else {
					ResultString = " ****** Slower**** than ";
				}
				printreport.print("\n**************************************************************************************************************");
				printreport.print("\nCommand: Compare_Computer_Speed\n");
				printreport.print("\n(" + c2.getCompany() +" , " + c2.getModelName()+","+c2.getSpeed()+")"+ResultString +"("+ c1.getCompany() +" , " + c1.getModelName()+","+c1.getSpeed()+")\n");
			}
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//command
			else if(command.equals("Quit")){
				//closing scanner and printwriter. and exiting.
				printreport.close();
				printoutput.close();
				read1.close();
				System.exit(0);
			}
			//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
			//else means there is no command to the given one so we skip the line
			else {
				
				read1.nextLine();
			}
			
		}
	}

}
