/**
 *
 */
package csv;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
/**
 * @author MD_AFROZ
 *
 */
public class AddressBookCSV {
	static String name;
	static Scanner sc;
	boolean EXIT = false;
	public HashMap<String, Contact> AddressBookCSV = new HashMap<>();
	public List<Contact> listOfContacts = new ArrayList<>();

	public static void main(String[] args) {

		HashMap<String, AddressBookCSV> multiAddressBookCSV = new HashMap<>();
		System.out.println("**************Welcome to the ADDRESS BOOK****************");
		AddressBookCSV ab = new AddressBookCSV();

		AddressBookCSV family = new AddressBookCSV();
		AddressBookCSV friends = new AddressBookCSV();
		AddressBookCSV bussiness = new AddressBookCSV();
		multiAddressBookCSV.put("Family", family);
		multiAddressBookCSV.put("Friends", friends);
		multiAddressBookCSV.put("Business", bussiness);

		ab.createContact(multiAddressBookCSV);

	}

	public void createContact(HashMap<String, AddressBookCSV> multiAddressBookCSV) {
		try {
			CSVWriter familyCsv = new CSVWriter(
					new FileWriter("C:/Users/MD_AFROZ/eclipse-workspace/AddressBook/JSONFiles.Family.csv"));
			CSVWriter friendsCsv = new CSVWriter(
					new FileWriter("C:/Users/MD_AFROZ/eclipse-workspace/AddressBook/JSONFiles.Friends.csv"));
			CSVWriter bussinessCsv = new CSVWriter(
					new FileWriter("C:/Users/MD_AFROZ/eclipse-workspace/AddressBook/JSONFiles.Bussiness.csv"));
			String[] header = { "FirstName", "LastName", "Address", "City", "State", "Zipcode", "PhoneNo", "Email" };
			familyCsv.writeNext(header);
			friendsCsv.writeNext(header);
			bussinessCsv.writeNext(header);

			while (!EXIT) {
				sc = new Scanner(System.in);
				System.out.println("1.Family\n2.Friends\n3.Business\n4.EXIT");
				System.out.println("Enter 1 ,2 ,3 for select address book and 4 to exit");
				int option = sc.nextInt();
				String key = "";
				switch (option) {
				case 1:
					key = "Family";
					break;
				case 2:
					key = "Friends";
					break;
				case 3:
					key = "Bussiness";
					break;
				case 4:
					EXIT = true;
				default:
					System.out.println("Invalid option.Please try again.");
				}

				System.out.println("1.Create new contact\n2.Edit Contact\n3.Delete Contact");
				sc = new Scanner(System.in);
				 int choice = sc.nextInt();
				 if (choice == 1) {
					 Contact contact = new Contact();
					 contact.setContactInfo();
					 name = contact.firstName.toUpperCase() + " " + contact.lastName.toUpperCase();
					 if(multiAddressBookCSV.get(key).AddressBookCSV.keySet().stream().noneMatch(c -> c.equalsIgnoreCase(name))) {
						 multiAddressBookCSV.get(key).AddressBookCSV.put(name, contact);
						 multiAddressBookCSV.get(key).listOfContacts.add(contact);
						 multiAddressBookCSV.get(key).AddressBookCSV.get(name).displayContactInfo();

						 String csvOutputString = multiAddressBookCSV.get(key).AddressBookCSV.get(name).showContactCSV();
						 String[] csvData = csvOutputString.split(",");

						 switch (option) {
						 case 1:
							 familyCsv.writeNext(csvData);
							 break;
						 case 2:
							 friendsCsv.writeNext(csvData);
							 break;
						 case 3:
							 bussinessCsv.writeNext(csvData);
							 break;
						 }
					 }else {
						 System.out.println("Contact already exist duplicate not allowed");
					 }
					 familyCsv.close();
					 friendsCsv.close();
					 bussinessCsv.close();
				 }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void readFromCSVFile() throws CsvValidationException {
		 System.out.println("\nReading from CSV files:  \n");
		 String[] contactInfo;

		 try {
			CSVReader familyCsv = new CSVReader(
						new FileReader("C:/Users/MD_AFROZ/eclipse-workspace/AddressBook/JSONFiles.Family.csv"));
			while ((contactInfo = familyCsv.readNext()) != null) {
				for (String cell : contactInfo) {
	                System.out.print(cell + "\t");
	            }
				System.out.println();
			}
			 System.out.println("\n");

			 CSVReader friendsCsv = new CSVReader(
						new FileReader("C:/Users/MD_AFROZ/eclipse-workspace/AddressBook/JSONFiles.Friends.csv"));
			while ((contactInfo = friendsCsv.readNext()) != null) {
				for (String cell : contactInfo) {
	                System.out.print(cell + "\t");
	            }
				System.out.println();
			}
			 System.out.println("\n");


			 CSVReader bussinessCsv = new CSVReader(
						new FileReader("C:/Users/MD_AFROZ/eclipse-workspace/AddressBook/JSONFiles.Bussiness.csv"));
			while ((contactInfo = bussinessCsv.readNext()) != null) {
				for (String cell : contactInfo) {
	                System.out.print(cell + "\t");
	            }
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
