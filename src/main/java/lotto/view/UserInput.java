package lotto.view;

import java.util.Scanner;

import calculator.util.StringValid;

public class UserInput {

	private static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * 유저 문자 입력 메서드
	 * @return 유저 입력 값
	 */
	public static String getString() {
		return UserInput.systemInput();
	}

	/**
	 * 유저 숫자 입력 메서드
	 * @return 유저 입력 숫자
	 */
	public static int getNumber() {
		String inputData = SCANNER.nextLine();

		if (StringValid.isNoNNumber(inputData)) {
			throw new IllegalArgumentException("숫자를 입력해 주세요.");
		}
		return Integer.parseInt(inputData);
	}
}
