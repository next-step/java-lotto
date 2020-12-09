package com.woowahan.calculator;

import java.util.Scanner;

public class StringAddCalculator {

	private static final String MSG_INPUT_REQUEST = "문자열 덧셈 계산기 입니다.식을 입력하십시오.";

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(MSG_INPUT_REQUEST);
		String input = scanner.nextLine();
		Calculator calculator = new Calculator(input);
		System.out.println(calculator.splitAndSum());
	}

}
