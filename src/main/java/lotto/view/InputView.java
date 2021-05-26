package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

	public static final String MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String MESSAGE_INPUT_WIN_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String MESSAGE_INPUT_BONUS_NUMBERS = "보너스 볼을 입력해 주세요.";
	public static final String MESSAGE_PURCHAGE_COMPLETE = "%d개를 구매했습니다.\n";
	public static final String INPUT_LOTTO_NUMBERS_DELIMITER = ",";
	public static final String MESSAGE_ERROR_PREFIX = "[ 예외발생 ] : ";
	public static final String MESSAGE_EMPTY = "";
	private static final Scanner scanner = new Scanner(System.in);

	public static PurchaseAmount inputPurchaseAmount() {
		PurchaseAmount purchaseAmount = null;
		while (purchaseAmount == null) {
			print(MESSAGE_INPUT_PURCHASE_AMOUNT);
			purchaseAmount = toPurchaseAmount(inputUsingScanner());
		}
		return purchaseAmount;
	}

	protected static PurchaseAmount toPurchaseAmount(String inputPurchaseAmount) {
		try {
			return new PurchaseAmount(inputPurchaseAmount);
		} catch (IllegalArgumentException e) {
			printError(e.getMessage());
			return null;
		}
	}

	public static WinningLotto inputWinningLotto() {
		Lotto inputWinningLotto = inputLotto();
		WinningLotto winningLotto = null;
		while (winningLotto == null) {
			winningLotto = toWinningLotto(inputWinningLotto, inputBonusNumber());
		}
		return winningLotto;
	}

	private static WinningLotto toWinningLotto(Lotto inputWinningLotto, LottoNumber inputBonusNumber) {
		try {
			return new WinningLotto(inputWinningLotto, inputBonusNumber);
		} catch (IllegalArgumentException e) {
			printError(e.getMessage());
			return null;
		}
	}

	public static Lotto inputLotto() {
		Lotto winLotto = null;
		while (winLotto == null) {
			print(MESSAGE_INPUT_WIN_LOTTO_NUMBERS);
			winLotto = toLotto(inputUsingScanner());
		}
		return winLotto;
	}

	public static LottoNumber inputBonusNumber() {
		LottoNumber bonusNumber = null;
		while (bonusNumber == null) {
			print(MESSAGE_INPUT_BONUS_NUMBERS);
			bonusNumber = toBonusNumber(inputUsingScanner());
		}
		return bonusNumber;
	}

	private static LottoNumber toBonusNumber(String inputNumber) {
		try {
			return new LottoNumber(inputNumber);
		} catch (IllegalArgumentException e) {
			printError(e.getMessage());
			return null;
		}
	}

	private static Lotto toLotto(String inputNumbers) {
		try {
			return new Lotto(toNumbers(inputNumbers, INPUT_LOTTO_NUMBERS_DELIMITER));
		} catch (IllegalArgumentException e) {
			printError(e.getMessage());
			return null;
		}
	}

	private static String inputUsingScanner() {
		return scanner.nextLine();
	}

	private static void print() {
		System.out.println(MESSAGE_EMPTY);
	}

	private static void print(Object message) {
		System.out.println(message);
	}

	private static void printError(Object message) {
		print(MESSAGE_ERROR_PREFIX + message);
	}

	protected static List<Integer> toNumbers(String inputNumbers, String delimiter) {
		List<Integer> numbers = new ArrayList<>();
		String[] strings = split(inputNumbers, delimiter);
		for (String s : strings) {
			numbers.add(Integer.parseInt(s.trim()));
		}
		return numbers;
	}

	protected static String[] split(String inputNumbers, String delimiter) {
		return inputNumbers.split(delimiter);
	}

	public static void printPurchaseLottos(Lottos purchaseLottos) {
		System.out.printf(MESSAGE_PURCHAGE_COMPLETE, purchaseLottos.size());

		for (Lotto lotto : purchaseLottos.getLottos()) {
			print(lotto);
		}
		print();
	}
}
