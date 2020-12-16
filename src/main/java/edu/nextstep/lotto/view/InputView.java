package edu.nextstep.lotto.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
	public static Scanner scanner = new Scanner(System.in);

	private InputView() {
	}

	public static int inputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		String input = scanner.nextLine();
		if (!Pattern.matches("^[0-9]+$", input)) {
			return inputMoney();
		}
		return Integer.parseInt(input);
	}
}
