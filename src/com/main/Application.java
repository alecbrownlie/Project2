package com.main;

import java.util.Scanner;

public class Application {
	private static String PROJECT_BANNER = "----- Project 02: Multiplication of Large Integers -----";
	private static String INSTRUCTIONS = "Please select a task to execute: ";
	private static String WELCOME_MSG = "      Welcome! " + INSTRUCTIONS;
	private static String MULTIPLICATION = "Multiplication";
	private static String EXPONENTIATION = "Exponentiation";
	private static String QUIT_STR = "Quit";

	private static Boolean quit = false;

	public static void main(String[] args) {
		printMenu();
		while (!quit) {
			processUserInput();
		}
	}

	private static void printMenu() {
		System.out.println(PROJECT_BANNER);
		System.out.println(WELCOME_MSG);
	}

	private static void printChoices() {
		System.out.println("1)    " + MULTIPLICATION);
		System.out.println("2)    " + EXPONENTIATION);
		System.out.println("3)    " + QUIT_STR);
	}

	private static void processUserInput() {
		Scanner scanner = new Scanner(System.in);
		boolean toProcess = true;
		try {
			while (toProcess) {
				printChoices();
				switch (Integer.parseInt(scanner.nextLine())) {
					case 1:
						System.out.println("Selected: " + MULTIPLICATION);
						toProcess = false;
						break;
					case 2: 
						System.out.println("Selected: " + EXPONENTIATION);
						toProcess = false;
						break;
					case 3: 
						System.out.println("Selected: " + QUIT_STR);
						quit = true;
						toProcess = false;
						break;
					default:
						System.out.println("Not a choice. " + INSTRUCTIONS);
				}	
			}
		} catch (java.lang.NumberFormatException e) {
			System.out.println("Not a number. " + INSTRUCTIONS);
			processUserInput();
		}
	}
}