package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lotto.exception.InputMachTypeException;
import lotto.message.ErrorMessage;
import lotto.utils.LottoCountCalculator;

public class LottoInputView {

	private static final String BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String LAST_WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String LAST_WIN_NUMBER_REGEX = ",";
	private static final String INT_REG_EXP = "^\\d+$";
	private static final int LOTTO_LENGTH = 6;
	private static final int MONEY_UNIT = 1000;
	public static final int ZERO_POINT = 0;
	private static final Scanner scanner = new Scanner(System.in);

	private LottoInputView() {
	}

	public static int buyLottos() throws RuntimeException {
		int money;
		System.out.println(BUY_MONEY_MESSAGE);
		if (scanner.hasNextInt()) {
			money = scanner.nextInt();
			scanner.nextLine();
			return LottoCountCalculator.calculateLottoCount(checkThousandUnit(checkPositive(money)));
		}
		throw new InputMachTypeException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
	}

	public static List<Integer> inputLastWinningNumbers() {
		System.out.println(LAST_WIN_NUMBER_MESSAGE);
		String lastWinningNumber = scanner.nextLine();
		checkEmptyCheck(lastWinningNumber);
		return toList(lastWinningNumber);
	}

	private static List<Integer> toList(String lastWinningNumber) {
		String[] lastWinNumbers = lastWinningNumber.split(LAST_WIN_NUMBER_REGEX);
		checkLottoSizeCheck(lastWinningNumber.split(LAST_WIN_NUMBER_REGEX));
		List<Integer> lottoNumbers = new ArrayList<>();
		Arrays.stream(lastWinNumbers).forEach(lottoNumber -> lottoNumbers.add(toInt(lottoNumber)));
		checkDuplicateNumberCheck(lottoNumbers);
		return lottoNumbers;
	}

	private static int toInt(String lottoNumber) {
		checkNumberTypeCheck(lottoNumber.trim());
		return Integer.parseInt(lottoNumber.trim());
	}

	private static void checkEmptyCheck(String lastWinNumbers) {
		if (lastWinNumbers.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
		}
	}

	private static void checkNumberTypeCheck(String lastWinNumber) {
		if (!lastWinNumber.matches(INT_REG_EXP)) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
	}

	private static void checkLottoSizeCheck(String[] lastWinNumbers) {
		if (lastWinNumbers.length != LOTTO_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE);
		}
	}

	private static int checkThousandUnit(int money) {
		if (money % MONEY_UNIT != ZERO_POINT) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_THOUSAND_UNIT_MESSAGE);
		}
		return money;
	}

	private static int checkPositive(int money) {
		if (money < 0) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_POSITIVE_MESSAGE);
		}
		return money;
	}

	private static void checkDuplicateNumberCheck(List<Integer> lastWinNumbers) {
		if (lastWinNumbers.size() != lastWinNumbers.stream().distinct().count()) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_MESSAGE);
		}
	}

}
