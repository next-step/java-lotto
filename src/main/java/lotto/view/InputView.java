package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

	public static final String MESSAGE_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String MESSAGE_INPUT_WIN_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String MESSAGE_INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
	public static final String MESSAGE_INPUT_BONUS_NUMBERS = "보너스 볼을 입력해 주세요.";
	public static final String MESSAGE_PURCHAGE_COMPLETE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
	public static final String INPUT_LOTTO_NUMBERS_DELIMITER = ",";
	public static final String MESSAGE_ERROR_PREFIX = "[ 예외발생 ] : ";
	public static final String MESSAGE_EMPTY = "";
	public static final String MESSAGE_INPUT_COUNT_OF_MANUAL = "수동으로 구매할 로또 수를 입력해 주세요.";
	public static final String MESSAGE_INVALID_NUMBER_REINPUT = "유효하지 않은 숫자를 입력하셨습니다. 다시 입력해주세요.";
	public static final String MESSAGE_INVALID_NUMBER = "유효하지 않은 숫자를 입력하셨습니다.";
	public static final String MESSAGE_INVALID_PURCHASE_AMOUNT = "구입금액은 숫자(정수)만 입력가능합니다.";
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
			return new PurchaseAmount(Integer.parseInt(inputPurchaseAmount));
		} catch (NumberFormatException e) {
			printError(MESSAGE_INVALID_PURCHASE_AMOUNT);
			return null;
		} catch (IllegalArgumentException e) {
			printError(e.getMessage());
			return null;
		}
	}

	public static Lottos inputManualLottos() {
		int countOfManual = inputCountOfManual();
		return inputManualLottos(countOfManual);
	}

	private static Lottos inputManualLottos(int countOfManual) {
		if (countOfManual > 0) {
			print();
			print(MESSAGE_INPUT_MANUAL_LOTTO_NUMBERS);
		}
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < countOfManual; i++) {
			Lotto lotto = inputManualLotto();
			lottos.add(lotto);
		}
		return new Lottos(lottos);
	}

	private static int inputCountOfManual() {
		Integer countOfManual = null;
		while (countOfManual == null) {
			print();
			print(MESSAGE_INPUT_COUNT_OF_MANUAL);
			countOfManual = toCountOfManual(inputUsingScanner());
		}
		return countOfManual;
	}

	private static Integer toCountOfManual(String inputUsingScanner) {
		try {
			return Integer.parseInt(inputUsingScanner);
		} catch (NumberFormatException e) {
			printError(MESSAGE_INVALID_NUMBER);
			return null;
		}
	}

	public static WinningLotto inputWinningLotto() {
		Lotto inputWinningLotto = inputLotto(MESSAGE_INPUT_WIN_LOTTO_NUMBERS);
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

	private static Lotto inputManualLotto() {
		Lotto winLotto = null;
		while (winLotto == null) {
			winLotto = toLotto(inputUsingScanner());
		}
		return winLotto;
	}

	private static Lotto inputLotto(String message) {
		Lotto winLotto = null;
		while (winLotto == null) {
			print(message);
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
		} catch (NumberFormatException e) {
			printError(MESSAGE_INVALID_NUMBER);
			return null;
		} catch (IllegalArgumentException e) {
			printError(e.getMessage());
			return null;
		}
	}

	private static Lotto toLotto(String inputNumbers) {
		try {
			return new Lotto(toNumbers(inputNumbers, INPUT_LOTTO_NUMBERS_DELIMITER));
		} catch (NumberFormatException e) {
			printError(MESSAGE_INVALID_NUMBER_REINPUT);
			return null;
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

	public static void printPurchaseLottos(PurchaseRequest purchaseRequest, Lottos purchaseLottos) {
		int manualQuantity = purchaseRequest.manualQuantity();
		int autoQuantity = purchaseRequest.autoQuantity();

		print();
		print(String.format(MESSAGE_PURCHAGE_COMPLETE, manualQuantity, autoQuantity));

		for (Lotto lotto : purchaseLottos.getLottos()) {
			print(lotto);
		}
		print();
	}
}
