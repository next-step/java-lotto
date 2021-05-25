package utils;

import java.util.Scanner;

public class ConsoleUtils {

	private ConsoleUtils() {
		// empty
	}

	public static void printLine(String message) {
		System.out.println(message);
	}
	public static void printLine() { printLine(""); }

	public static void print(String message) { System.out.print(message); }

	public static String nextString(String inputMessage) {
		printLine(inputMessage);
		return new Scanner(System.in).nextLine();
	}

	public static int nextInt(String inputMessage) {
		printLine(inputMessage);
		return new Scanner(System.in).nextInt();
	}
}
