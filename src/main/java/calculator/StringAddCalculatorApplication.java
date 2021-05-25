package calculator;

import java.util.Scanner;

public class StringAddCalculatorApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("문자열을 입력 하세요 : ");
		int result = StringAddCalculator.splitAndSum(scanner.next());
		System.out.println("결과 : " + result);
	}
}
