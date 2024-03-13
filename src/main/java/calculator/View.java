package calculator;

import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calculator calculator = new Calculator(scanner.nextLine());
		System.out.println(calculator.calculatedInteger());
	}
}
