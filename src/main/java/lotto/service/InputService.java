package lotto.service;

import lotto.domain.LottoGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputService {

	protected static final String INPUT_LOTTO_NUMBERS_DELIMITER = ",";
	private final Scanner scanner;

	public InputService() {
		this.scanner = new Scanner(System.in);
	}

	public int inputPurchaseAmount() {
		boolean continues = true;
		String inputAmount = null;
		while (continues) {
			System.out.println("구입금액을 입력해 주세요.");
			inputAmount = inputNumbersUsingScanner();
			continues = isContinuesInputPurchaseAmount(inputAmount);
		}
		return Integer.parseInt(inputAmount);
	}

	public List<Integer> inputWinLottoNumbers() {
		boolean continues = true;
		String inputNumbers = null;
		while (continues) {
			System.out.println("지난 주 당첨 번호를 입력해 주세요.");
			inputNumbers = inputNumbersUsingScanner();
			continues = isContinuesInputWinLottoNumbers(inputNumbers);
		}
		return toNumbers(inputNumbers, INPUT_LOTTO_NUMBERS_DELIMITER);
	}

	private String inputNumbersUsingScanner() {
		return this.scanner.nextLine();
	}

	protected boolean isContinuesInputPurchaseAmount(String inputAmount) {
		boolean continues;
		try {
			continues = !validationInputPurchaseAmount(inputAmount);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
			continues = true;
		}
		return continues;
	}

	protected boolean isContinuesInputWinLottoNumbers(String inputNumbers) {
		boolean continues;
		try {
			continues = !validationInputWinLottoNumbers(inputNumbers);
		} catch (IllegalArgumentException e) {
			System.out.println("[ 예외발생 ] : " + e.getMessage());
			continues = true;
		}
		return continues;
	}

	protected boolean validationInputPurchaseAmount(String inputAmount) throws IllegalArgumentException {
		if (inputAmount == null || inputAmount.trim().length() == 0) {
			return false;
		}
		if (!isNumeric(inputAmount)) {
			throw new IllegalArgumentException("구입금액은 숫자만 입력가능합니다.");
		}
		if (Integer.parseInt(inputAmount) < LottoGame.PURCHASE_AMOUNT_PER_LOTTO) {
			throw new IllegalArgumentException(String.format("구입금액은 최소 %,d원 이상이어야 합니다.", LottoGame.PURCHASE_AMOUNT_PER_LOTTO));
		}
		return true;
	}

	protected boolean validationInputWinLottoNumbers(String inputNumbers) throws IllegalArgumentException {
		if (inputNumbers == null || inputNumbers.trim().length() == 0) {
			return false;
		}
		String[] numbers = this.split(inputNumbers, INPUT_LOTTO_NUMBERS_DELIMITER);
		if (numbers == null || numbers.length != 6) {
			throw new IllegalArgumentException("로또 당첨번호는 6개의 숫자를 입력하셔야 합니다.");
		}
		return true;
	}

	protected static List<Integer> toNumbers(String inputNumbers, String delimiter) {
		List<Integer> numbers = new ArrayList<>();
		List<String> strings = Arrays.asList(split(inputNumbers, delimiter));
		for (String s : strings) {
			numbers.add(Integer.parseInt(s.trim()));
		}
		return numbers;
	}

	protected static String[] split(String inputNumbers, String delimiter) {
		return inputNumbers.split(delimiter);
	}

	protected static boolean isNumeric(String str) {
		if (str == null || str.trim().length() == 0) {
			return false;
		}
		String regex = "[0-9]+";
		return str.matches(regex);
	}

}
