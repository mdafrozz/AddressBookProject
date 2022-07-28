/**
 * 
 */
package com.bridgelabz.java;

import java.util.Scanner;

/**
 * @author MD_AFROZ
 *
 */
public class InputUtil {
	private final static Scanner sc = new Scanner(System.in);

	public static int getIntValue() {
		return sc.nextInt();
	}

	public static String getStringValue() {
		return sc.nextLine();
	}
	
	public static long getLongValue() {
		return sc.nextLong();
	}
}
