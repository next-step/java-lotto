package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
			checkThousandUnit(money);
			checkPositive(money);
			scanner.nextLine();
			return LottoCountCalculator.calculateLottoCount(money);
		}
		throw new InputMachTypeException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
	}

	public static List<Integer> inputLastWinningLotto() {
		System.out.println(LAST_WIN_NUMBER_MESSAGE);
		String lastWinningLotto = scanner.nextLine();
		checkLottoEmpty(lastWinningLotto);
		return toList(lastWinningLotto);
	}

	private static List<Integer> toList(String lotto) {
		List<Integer> lottoNumbers = Arrays.stream(lotto.split(LAST_WIN_NUMBER_REGEX))
			.map(LottoInputView::toInt)
			.collect(Collectors.toList());
		checkLottoSize(lottoNumbers);
		checkDuplicateNumber(lottoNumbers);
		return lottoNumbers;
	}

	private static int toInt(String lotto) {
		checkNumberType(lotto.trim());
		return Integer.parseInt(lotto.trim());
	}

	private static void checkLottoEmpty(String lotto) {
		if (lotto.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
		}
	}

	private static void checkNumberType(String lotto) {
		if (!lotto.matches(INT_REG_EXP)) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
	}

	private static void checkLottoSize(List<Integer> lotto) {
		if (lotto.size() != LOTTO_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE);
		}
	}

	private static void checkThousandUnit(int money) {
		if (money % MONEY_UNIT != ZERO_POINT) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_THOUSAND_UNIT_MESSAGE);
		}
	}

	private static void checkPositive(int money) {
		if (money < 0) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_POSITIVE_MESSAGE);
		}
	}

	private static void checkDuplicateNumber(List<Integer> lottoNumbers) {
		if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_MESSAGE);
		}
	}

}
