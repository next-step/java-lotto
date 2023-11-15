package stringCalculator.view;

import java.util.Scanner;

public class InputView {

	private static Scanner sc = new Scanner(System.in);

	public static String userInput() {
		System.out.println("계산할 문자열을 입력하세요");
		String userinput = sc.nextLine();
		validateString(userinput);
		return userinput;
	}

	private static void validateString(String input) {
		if(input == null || input.isEmpty()) {
			throw new IllegalArgumentException("입력값이 없거나 빈 문자열입니다.");
		}
	}
}
