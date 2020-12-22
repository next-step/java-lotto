package lotto.view;

import java.util.Scanner;

import calculator.util.StringValid;

public class UserInput {

	private static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * 유저 문자 입력 메서드
	 * @return 유저 입력 값
	 */
	public static String inputString() {
		return UserInput.systemInput();
	}

	/**
	 * 유저 숫자 입력 메서드
	 * @return 유저 입력 숫자
	 */
	public static int inputNumber() {
		String inputData = UserInput.systemInput();

		if (StringValid.isNoNNumber(inputData)) {
			throw new IllegalArgumentException("숫자를 입력해 주세요.");
		}
		return Integer.parseInt(inputData);
	}

	/**
	 * 유저에게 입력 받는 메서드
	 * @return 입력한 문자열
	 */
	private static String systemInput() {
		return SCANNER.nextLine();
	}
}
