/**
 * 
 */
package com.bridgelabz.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MD_AFROZ
 *
 */
public class AddressBookService {
	String firstName, lastName, email, address, city, state;
	long phoneNo, zipCode;
	List<Person> personList;

	public AddressBookService() {
		this.personList = new ArrayList<Person>();
	}

	public void addPerson() {
		System.out.println("-------------- Add New Contact --------------");
		System.out.print("Enter First Name : ");
		firstName = InputUtil.getStringValue();
		System.out.print("Enter Last Name : ");
		lastName = InputUtil.getStringValue();
		System.out.print("Enter email : ");
		email = InputUtil.getStringValue();
		System.out.print("Enter Address : ");
		address = InputUtil.getStringValue();
		System.out.print("Enter city : ");
		city = InputUtil.getStringValue();
		System.out.print("Enter state : ");
		state = InputUtil.getStringValue();
		System.out.print("Enter Phone Number : ");
		phoneNo = InputUtil.getLongValue();
		System.out.print("Enter zip : ");
		zipCode = InputUtil.getLongValue();

		personList.add(new Person(firstName, lastName, email, address, city, state, phoneNo, zipCode));
		System.out.println("Contact added successfully...");
		System.out.println("<------------------------------------------------------->");
	}

	public void editRecord() {
		System.out.println("-------------- Edit Contact --------------");
		if (personList.isEmpty()) {
			System.out.println("No Records To edit!!!");
		} else {
			for (Person person : personList) {
				System.out.println("ID: #" + personList.indexOf(person) + " : " + person);
			}
			System.out.print("\nEnter #ID to Edit Contact : ");
			int id = InputUtil.getIntValue();
			System.out.println(personList.get(id));
			System.out.println("<------------------------------------------------------->");

			boolean exit = false;
			while (!exit) {
				System.out.println("---------- Select field ----------");
				System.out.println(
						"1.First name \t2.Last name \t3.Email \t4.Address \t5.City \t6.State \t7.Phone Number \t8.Zip code \t9.Quit");
				System.out.println("---------- Enter Your Choice ----------");
				int choice = InputUtil.getIntValue();

				switch (choice) {
				case 1:
					System.out.print("Enter new Firstname : ");
					firstName = InputUtil.getStringValue();
					personList.get(id).setFname(firstName);
					break;
				case 2:
					System.out.print("Enter new Lastname : ");
					lastName = InputUtil.getStringValue();
					personList.get(id).setLname(lastName);
					break;
				case 3:
					System.out.print("Enter new Email : ");
					email = InputUtil.getStringValue();
					personList.get(id).setEmail(email);
					break;
				case 4:
					System.out.print("Enter new Address : ");
					address = InputUtil.getStringValue();
					personList.get(id).setAddress(address);
					break;
				case 5:
					System.out.print("Enter new City : ");
					city = InputUtil.getStringValue();
					personList.get(id).setCity(city);
					break;
				case 6:
					System.out.print("Enter new State : ");
					state = InputUtil.getStringValue();
					personList.get(id).setState(state);
					break;
				case 7:
					System.out.print("Enter new Phone : ");
					phoneNo = InputUtil.getLongValue();
					personList.get(id).setPhone(phoneNo);
					break;
				case 8:
					System.out.print("Enter new Zip Code : ");
					zipCode = InputUtil.getLongValue();
					personList.get(id).setZip(zipCode);
					break;
				case 9:
					exit = true;
					System.out.println("---------- Edit option Quit ----------");
					break;
				default:
					System.out.println("Please Enter Valid Option");
				}
				System.out.println(personList.get(id));
				System.out.println("Contact is updated successfully.!!!");
			}
		}
		System.out.println("<------------------------------------------------------->");

	}

	public void showAllContacts() {
		System.out.println("-------------- Show All Contacts --------------");
		if (personList.isEmpty()) {
			System.out.println("No Records To show!!!");
		} else {
			for (Person person : personList) {
				System.out.println(person);
			}
		}
		System.out.println("<------------------------------------------------------->");
	}
}
