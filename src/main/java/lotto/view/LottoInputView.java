package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.exception.InputMachTypeException;
import lotto.message.ErrorMessage;
import lotto.model.Lotto;
import lotto.model.Money;

public class LottoInputView {

	private static final String BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String LAST_WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String LAST_WIN_NUMBER_REGEX = ",";
	private static final String INT_REG_EXP = "^\\d+$";
	private static final int LOTTO_NUMBER_LENGTH = 6;
	private static final Scanner scanner = new Scanner(System.in);

	private LottoInputView() {
	}

	public static Money buyLottos() {
		System.out.println(BUY_MONEY_MESSAGE);
		if (!scanner.hasNextInt()) {
			throw new InputMachTypeException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
		Money money = new Money(scanner.nextInt());
		scanner.nextLine();
		return money;
	}

	public static Lotto inputLastWinningLotto() {
		System.out.println(LAST_WIN_NUMBER_MESSAGE);
		String lastWinningLotto = scanner.nextLine();
		checkLottoEmpty(lastWinningLotto);
		return new Lotto(toList(lastWinningLotto));
	}

	private static List<Integer> toList(String lotto) {
		List<Integer> lottoNumbers = Arrays.stream(lotto.split(LAST_WIN_NUMBER_REGEX))
			.map(LottoInputView::toInt)
			.collect(Collectors.toList());
		checkLottoSize(lottoNumbers);
		checkDuplicateNumber(lottoNumbers);
		return lottoNumbers;
	}

	private static int toInt(String lottoNumber) {
		checkNumberType(lottoNumber.trim());
		return Integer.parseInt(lottoNumber.trim());
	}

	private static void checkLottoEmpty(String lotto) {
		if (lotto.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
		}
	}

	private static void checkNumberType(String lottoNumber) {
		if (!lottoNumber.matches(INT_REG_EXP)) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
	}

	private static void checkLottoSize(List<Integer> lottoNumbers) {
		if (lottoNumbers.size() != LOTTO_NUMBER_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE);
		}
	}

	private static void checkDuplicateNumber(List<Integer> lottoNumbers) {
		if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_MESSAGE);
		}
	}
}
