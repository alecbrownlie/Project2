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
 
	public String exponentiation(Integer a, Integer b) {
		if (b == 0) return "1";

		String val = exponentiation(a, b / 2);

		if (b % 2 == 0) {
			return karatsuba_mult(val, val);
		} 
		return karatsuba_mult(karatsuba_mult(val, val), a.toString());
	}

	public String karatsuba_mult(String a, String b) {
		int lengthA = a.length();
		int lengthB = b.length();
		
		// base case		
		if (lengthA == 1 && lengthB == 1) { 
			return multiply(a, b);
		}       

		// pad zeros to match length
		if (lengthA < lengthB) a = padZeros(a, b);
		else if (lengthA > lengthB) b = padZeros(b, a);

		int size = Math.max(lengthA, lengthB);
		
		String a0 = a.substring(0, size / 2); 
		String a1 = a.substring(size / 2, size); 
		String b0 = b.substring(0, size / 2); 
		String b1 = b.substring(size / 2, size);

		String sumAHalves = add(a0, a1);
		String sumBHalves = add(b0, b1);

		String c0 = karatsuba_mult(a0, b0);      
		String c2 = karatsuba_mult(a1, b1);
		String productABHalves = karatsuba_mult(sumAHalves, sumBHalves);
	
		String diffABC0 = subtract(productABHalves, c0); 
		String c1  = subtract(diffABC0, c2);
		
		double n = (double) size;
		for (int i = 0; i < 2 * Math.ceil(n / 2); i++) {
			if (i < Math.ceil(n / 2)) c1 += "0";
			c0 += "0";
		}
		return trimZeros(add(add(c0, c1), c2));
	}
}
	
