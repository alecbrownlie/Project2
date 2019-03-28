package com.algorithms;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.util.KaratsubaUtil.add;
import static com.util.KaratsubaUtil.subtract;
import static com.util.KaratsubaUtil.multiply;
import static com.util.KaratsubaUtil.padZeros;
import static com.util.KaratsubaUtil.trimZeros;

public class Karatsuba {

	// public List<Integer> exponentiation(int a, int b) {
	// 	List<Integer> result = new ArrayList<Integer>();
	// 	List<Integer> val = new ArrayList<Integer>();

	// 	if (b == 0) return 1;
	// 	if (b % 2 == 0) {
	// 		val = exponentiation(a, b / 2);
	// 		result = karatsuba_mult(val, val);
	// 	} else {
	// 		val = exponentiation(a, (b - 1) / 2);
	// 		result = karatsuba_mult(val, val);
	// 		result = karatsuba_mult(result, convertIntToList(a));
	// 	}
	// 	return result;
	// }

	public String k_mult(String a, String b) {
		int lengthA = a.length();
		int lengthB = b.length();
		
		// base case		
		if (lengthA == 1 && lengthB == 1) { 
			return multiply(a,b);
		}       

		// pad zeros to match length
		b = padZeros(a, b);
		a = padZeros(b, a);

		int size = Math.max(lengthA, lengthB);
		
		String a0 = a.substring(0, size / 2); 
		String a1 = a.substring(size / 2, size); 
		String b0 = b.substring(0, size / 2); 
		String b1 = b.substring(size / 2, size);

		String c0 = k_mult(a0, b0);      
		String c2 = k_mult(a1, b1);

		String sumAHalves = add(a0, a1);
		String sumBHalves = add(b0, b1);

		String productABHalves = k_mult(sumAHalves, sumBHalves);
		 
		String c1  = subtract(subtract(productABHalves, c0), c2);
		
		// add c0, c1 padding if necessary
		for (int i = 0; i < 2 * Math.ceil(size / 2); i++) {
			if (i < Math.ceil(size / 2)) c1 += "0";
			c0 += "0";
		}
		
		return trimZeros(add(add(c0, c1), c2));
	}
}