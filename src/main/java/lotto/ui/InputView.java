package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.domain.Lotto;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static long inputPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		long purchaseAmount;
		try {
			purchaseAmount = scanner.nextLong();
			scanner.nextLine();
		} catch (Exception e) {
			throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
		}

		return purchaseAmount;
	}

	public static List<Integer> inputWinNumbers() {
		System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
		String[] split = scanner.nextLine().split(", ");

		checkSize(split.length);

		List<Integer> winNumbers = new ArrayList<>();
		for (String winNumberString : split) {
			winNumbers.add(correctWinNumber(winNumberString));
		}

		return winNumbers;
	}

	private static void checkSize(int length) {
		if (length != Lotto.LOTTO_SIZE) {
			throw new IllegalArgumentException("로또의 크기인 6만큼만 입력 가능합니다.");
		}
	}

	private static int correctWinNumber(String winNumbersString) {
		return checkRange(toInt(winNumbersString));
	}

	private static int toInt(String winNumbersString) {
		int winNumber;
		try {
			winNumber = Integer.parseInt(winNumbersString);
		} catch (Exception e) {
			throw new IllegalArgumentException("당첨번호는 숫자만 입력 가능합니다.");
		}
		return winNumber;
	}

	private static int checkRange(int winNumber) {
		if (winNumber < 1 || winNumber > 45) {
			throw new IllegalArgumentException("당첨 넘버는 1~45까지의 숫자만 입력 가능합니다.");
		}
		return winNumber;
	}
}
