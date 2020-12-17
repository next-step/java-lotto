package edu.nextstep.lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

	public static List<Integer> inputWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String input = scanner.nextLine();
		if (!Pattern.matches("\\s*\\d+\\s*(,\\s*\\d+\\s*)*", input)) {
			return inputWinningNumbers();
		}
		return Arrays.stream(input.split(","))
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}