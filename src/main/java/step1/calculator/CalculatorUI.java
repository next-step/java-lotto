package step1.calculator;

import java.util.Scanner;

public class CalculatorUI {
	private static final Scanner scanner = new Scanner(System.in);

	public static String ready() {
		System.out.println("계산할 식을 입력하세요.");
		String input = scanner.nextLine();

		return input;
	}

	public static void terminate(int result) {
		System.out.println("계산 결과: " + result);

		System.out.println("계산기를 종료합니다.");
	}
}
