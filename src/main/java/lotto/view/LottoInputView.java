package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import lotto.exception.InputMachTypeException;
import lotto.message.ErrorMessage;
import lotto.utils.LottoCountCalculator;

public class LottoInputView {

	private static final String BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String LAST_WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final int MONEY_UNIT = 1000;
	public static final int ZERO_POINT = 0;
	private static final Scanner scanner = new Scanner(System.in);

	private LottoInputView() {
	}

	public static int buyLottos() {
		int money;
		System.out.println(BUY_MONEY_MESSAGE);
		try {
			money = scanner.nextInt();
			verifyPositive(money);
			verifyThousandUnit(money);
			scanner.nextLine();
		} catch (InputMismatchException e) {
			throw new InputMachTypeException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
		return LottoCountCalculator.calculateLottoCount(money);
	}

	public static String requestLastWinLottoNumber() {
		System.out.println(LAST_WIN_NUMBER_MESSAGE);
		return scanner.nextLine();
	}

	private static void verifyThousandUnit(int money) {
		if (money % MONEY_UNIT != ZERO_POINT) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_THOUSAND_UNIT_MESSAGE);
		}
	}

	private static void verifyPositive(int money) {
		if (money < 0) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_POSITIVE_MESSAGE);
		}
	}

}
