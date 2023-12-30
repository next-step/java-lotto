package lotto.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import lotto.domain.LottoNumber;

public final class InputView {
	private static final int WON1000 = 1000;
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int printPriceInput() {
		System.out.println("구입금액을 입력해 주세요.");
		return Integer.parseInt(validate(SCANNER.nextLine()));
	}

	public static String inputText() {
		return validate(SCANNER.nextLine());
	}

	private static String validate(final String text) {
		if (text == null || text.isBlank()) {
			throw new InputMismatchException("입력해 주세요.");
		}

		return text;
	}

	public static int printPrice(final int price) {
		int number = price / WON1000;
		System.out.printf("%d개를 구매했습니다.\n", number);

		return number;
	}

	public static void printWinningNumber() {
		System.out.println();
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
	}

	public static Set<LottoNumber> winningNumbers(final String text) {
		String[] numbers = text.split(",");
		Set<LottoNumber> winningNumbers = new HashSet<>(6);
		for (int i = 0; i < numbers.length; i++) {
			winningNumbers.add(new LottoNumber(Integer.parseInt(numbers[i].trim())));
		}
		return winningNumbers;
	}
}
