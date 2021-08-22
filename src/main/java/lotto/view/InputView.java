package lotto.view;

import java.util.Scanner;

public class InputView {
	private static final String QUESTION_AMOUNT = "구입 금액을 입력해주세요.";
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int inputAmount() {
		System.out.println(QUESTION_AMOUNT);
		return SCANNER.nextInt();
	}
}
