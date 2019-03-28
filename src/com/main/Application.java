package com.main;

import java.util.List;
import java.util.Scanner;
import com.algorithms.Karatsuba;

public class Application {
	private static String PROJECT_BANNER = "----- Project 02: Multiplication of Large Integers -----";
	private static String INSTRUCTIONS = "Please enter a single positive value for integer ";
	private static String TASK_INSTRUCTIONS = "Please select a task to execute: ";
	private static String MULTIPLICATION = "Multiplication";
	private static String EXPONENTIATION = "Exponentiation";
	private static String NAC_STR = "Not a choice.";
	private static String NAN_STR = "Not a number.";
	private static String QUIT_STR = "Quit";
	private static String SELECTED = "Selected: ";

	private static Karatsuba karatsuba = new Karatsuba();

	private static Boolean quit = false;

	public static void main(String[] args) {
		System.out.println(PROJECT_BANNER);
		int a = getUserInput("A");
		int b = getUserInput("B");
		while (!quit) {
			processUserInput(a, b);
		}
	}

	private static void printChoices() {
		System.out.println("1)    " + MULTIPLICATION);
		System.out.println("2)    " + EXPONENTIATION);
		System.out.println("3)    " + QUIT_STR);
	}

	private static int getUserInput(String var) {
		Scanner scanner = new Scanner(System.in);
		boolean toProcess = true;
		int result = 0;
		try {
			while (toProcess) {
				System.out.println(INSTRUCTIONS + var + ": ");
				result = Integer.parseInt(scanner.nextLine());
				if (result > 0) return result;
			}
		} catch (java.lang.NumberFormatException e) {
			System.out.println(NAN_STR);
			getUserInput(var);
		}
		return result;
	}

	private static void processUserInput(int a, int b) {
		Scanner scanner = new Scanner(System.in);
		boolean toProcess = true;
	
		try {
			while (toProcess) {
				printChoices();
				switch (Integer.parseInt(scanner.nextLine())) {
					case 1:
						System.out.println(SELECTED + MULTIPLICATION);
						String result = karatsuba.k_mult(Integer.toString(a), Integer.toString(b));
						System.out.println("Result: " + result);
						toProcess = false;
						break;
					case 2: 
						System.out.println(SELECTED + EXPONENTIATION);
						// karatsuba.exponentiation(a, b);
						toProcess = false;
						break;
					case 3: 
						System.out.println(SELECTED + QUIT_STR);
						quit = true;
						toProcess = false;
						break;
					default:
						System.out.println(NAC_STR + TASK_INSTRUCTIONS);
				}	
			}
		} catch (java.lang.NumberFormatException e) {
			System.out.println(NAN_STR + TASK_INSTRUCTIONS);
			processUserInput(a, b);
		}
	}
}