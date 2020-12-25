package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String DELIMITER = ",";

	public static int inputPurchaseMoney() {
		System.out.println("구입금액을 입력해주세요.");
		String input = scanner.nextLine();
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("숫자를 입력하세요.");
		}
	}

	public static List<Integer> inputWonLottoNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해주세요.");
		String input = scanner.nextLine();
		try {
			return Arrays.stream(input.split(DELIMITER))
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("숫자를 입력하세요.");
		}
	}
}
