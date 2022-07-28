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
	List<Person> personList = new ArrayList<Person>();

	public void addPerson() {
		String firstName, lastName, email, address, city, state;
		long phoneNo, zipCode;

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
		
		personList.add(new Person(firstName, lastName, email, address, state, city, phoneNo, zipCode));
		System.out.println(personList);

	}
}
