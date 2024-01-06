package lotto.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import lotto.domain.LottoNumber;

public final class InputView {
	private static final String DELIMITER = ",";
	private static final int WON1000 = 1000;
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int priceInput() {
		System.out.println("구입금액을 입력해 주세요.");

		return Integer.parseInt(inputText());
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

	public static int manualCount() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

		return Integer.parseInt(inputText());
	}

	public static List<String> manualNumbers(int manualCount) {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");

		List<String> manualNumbers = new ArrayList<>();

		for (int i = 0; i < manualCount; i++) {
			manualNumbers.add(inputText());
		}

		return manualNumbers;
	}

	public static int numberOfLotto(final int price, final int manualCount) {
		int number = price / WON1000;
		System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.\n" ,manualCount, number-manualCount);

		return number;
	}

	public static void winningNumber() {
		System.out.println();
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
	}

	public static Set<LottoNumber> winningNumbers(final String text) {
		String[] numbers = text.split(DELIMITER);
		Set<LottoNumber> winningNumbers = new HashSet<>(6);
		for (String number : numbers) {
			winningNumbers.add(new LottoNumber(Integer.parseInt(number.trim())));
		}

		return winningNumbers;
	}

	public static int bonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");

		return Integer.parseInt(inputText());
	}
}
