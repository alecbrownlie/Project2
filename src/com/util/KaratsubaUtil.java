package com.util;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
import java.lang.StringBuilder;

public class KaratsubaUtil{

	public static String add(String a, String b) {
		int lengthA = a.length();
		int lengthB = b.length();
		String result = "";
		int carry = 0;
		int maxLength = Math.max(lengthA, lengthB);

		// pad zeros to match length
		if (lengthA < lengthB) a = padZeros(a, b);
		else if (lengthA > lengthB) b = padZeros(b, a);
		
		int i = 0;  
		for (int j = maxLength - 1; j >= 0 ; j--) {
			int sum = Integer.parseInt(Character.toString(a.charAt(j))) + Integer.parseInt(Character.toString(b.charAt(j))) + carry;
			if (sum >= 10) {
				carry = 1;
				i = 1; 
			} else {
				carry = 0;
				i = 0;
			}
			result = Integer.toString(sum).substring(i) + result;
		}
		return carry == 0 ? result : "1" + result;
	}

	public static String subtract(String a, String b) {
		int lengthA = a.length();
		int lengthB = b.length();
		String result = "";
		int maxLength = Math.max(lengthA, lengthB);

		// pad zeros to match length
		if (lengthA < lengthB) a = padZeros(a, b);
		else if (lengthA > lengthB) b = padZeros(b, a);

		String[] carry = a.split(""); 

		for (int i = maxLength - 1; i >= 0; i--) {
			int digitA = Integer.parseInt(carry[i]);
			int digitB = Integer.parseInt(Character.toString(b.charAt(i)));
			
			if (digitB > digitA) {
				digitA += 10;
				int j = i - 1;
				for (; carry[j].equals("0"); j--) {
					carry[j] = "9";
				}
				carry[j] = Integer.toString(Integer.parseInt(carry[j]) - 1);
			}
			result = Integer.toString(digitA - digitB) + result;
		}
		return result;
	}

	public static String multiply(String a, String b) {
		return Integer.toString(Integer.parseInt(a) * Integer.parseInt(b));
	}

	public static String padZeros(String a, String b) {
		int maxLength = Math.abs(a.length() - b.length());
		for (int i = 1; i <= maxLength; i++)
			a = "0" + a;
		return a;
	}

	public static String trimZeros(String str) {
		return str.replaceFirst("^0+(?!$)", "");
	}
}