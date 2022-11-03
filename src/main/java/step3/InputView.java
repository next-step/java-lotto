package step3;

import java.util.Scanner;

public class InputView {
	private static final int LOTTO_LENGTH = 6;
	private static final Scanner sc = new Scanner(System.in);

	public static String input() {
		return sc.nextLine();
	}

	public static String[] inputWinningNumber() {
		return validLottoNumbers(sc.nextLine().split(", "));
	}

	private static String[] validLottoNumbers(String[] split) {
		if (split.length != LOTTO_LENGTH) {
			throw new IllegalArgumentException("6개의 숫자를 입력해주세요");
		}
		return split;
	}
}
