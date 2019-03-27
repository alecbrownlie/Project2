package com.algorithms;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Karatsuba {

	public List<Integer> multiply(int a, int b) {
		return karatsuba_mult(convertIntToList(a), convertIntToList(b));
	}

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

	private List<Integer> karatsuba_mult(List<Integer> listA, List<Integer> listB) {
		int lengthA = listA.size();
		// base case
		if (lengthA == 1 && listB.size() == 1) {
			return convertIntToList(listA.get(0) * listB.get(0));
		}
		
		// pad 0s
		padLists(listA, listB);
		padLists(listB, listA);

		// DEBUG:
		System.out.println("[DEBUG] listA after pad " + listA);
		System.out.println("[DEBUG] listB after pad " + listB);

		int split = lengthA / 2;
		if (lengthA % 2 == 1) split += 1;

		List<Integer> subListA0 = new ArrayList<Integer>();
		List<Integer> subListB0 = new ArrayList<Integer>();
		List<Integer> subListA1 = new ArrayList<Integer>();
		List<Integer> subListB1 = new ArrayList<Integer>();

		for (int i = 0; i < split; i++) {
			subListA0.add(listA.get(i));
			subListB0.add(listB.get(i));
		}
		for (int j = split; j < lengthA; j++) {
			subListA1.add(listA.get(j));
			subListB1.add(listB.get(j));
		}

		System.out.println("[DEBUG] subListA0: " + subListA0);
		System.out.println("[DEBUG] subListB0: " + subListB0);
		System.out.println("[DEBUG] subListA1: " + subListA1);
		System.out.println("[DEBUG] subListB1: " + subListB1);

		List<Integer> c2 = karatsuba_mult(subListA1, subListB1);
		List<Integer> c0 = karatsuba_mult(subListA0, subListB0);


		return null;
	}

	// public List<Integer> addLists(List<Integer> listA, List<Integer> listB) {
	// 	int lengthA = listA.size();
	// 	List<Integer> result = new LinkedList<Integer>();
	// 	int carry = 0;
	// 	padLists(listA, listB);

	// 	for (int i = 0; i < lengthA + 1;) {
	// 		if (i == lengthA) {
	// 			if (carry) result.add(1);
	// 			else return result;
	// 		} else {
	// 			Integer sum = listA.get(i) + listB.get(i);
	// 			carry = sum >= 10 ? 0 : 1;
	// 			sum = sum % 10;
	// 			result.add(sum);
	// 		}
	// 	}
	// }

	// public List<Integer> subtract(List<Integer> listA, List<Integer> listB) {
	// 	List<Integer> result = new ArrayList<Integer>();
	
	// 	// reverse the lists
	// 	listA.reverse();
	// 	listB.reverse();

	// 	Integer listALength = listA.length(); 
	// 	Integer listBLength = listB.length(); 

	// 	// pad
	// 	padLists(listA, listB);
	// 	padLists(listB, listA);

	// 	for (int i = 0; i < listALength; i++) {
	// 		if (listA.get(i) < listB.get(i)) {
	// 			// do subtraction
	// 		}
	// 	}
	// 	return result.reverse();
	// }

	// public List<Integer> add(List<Integer> listA, List<Integer> listB) {
	// 	return null;
	// }

	private List<Integer> padLists(List<Integer> listToPad, List<Integer> listToCompare) {
		if (listToPad.size() < listToCompare.size()) {
			while (listToPad.size() != listToCompare.size()) {
				listToPad.add(0, 0);
			}
		}
		return listToPad;
	}

	private List<Integer> convertIntToList(int val) {
		int[] result = String.valueOf(val).chars().map(Character::getNumericValue).toArray();
		return Arrays.stream(result).boxed().collect(Collectors.toList());
	}
}