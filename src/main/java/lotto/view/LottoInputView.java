package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import lotto.exception.InputMachTypeException;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoTicketCalculator;

public class LottoInputView {

	private static final String BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String BUY_RESULT_MESSAGE = "개를 구매했습니다.";
	private static final Scanner scanner = new Scanner(System.in);
	private static final String LAST_WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

	private static final int MONEY_UNIT = 1000;
	public static final int ZERO_POINT = 0;

	private LottoInputView() {
	}

	public static int buyRequest() {
		int money;
		System.out.println(BUY_MONEY_MESSAGE);
		try {
			money = scanner.nextInt();
			validPositiveCheck(money);
			validThousandUnitCheck(money);
			System.out.println(LottoTicketCalculator.calculatorLottoTicketCount(money) + BUY_RESULT_MESSAGE);
			scanner.nextLine();
		} catch (InputMismatchException e) {
			throw new InputMachTypeException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
		return money;
	}

	public static String requestLastWinLottoNumber() {
		System.out.println(LAST_WIN_NUMBER_MESSAGE);
		return scanner.nextLine();
	}

	private static void validThousandUnitCheck(int value) {
		if (value % MONEY_UNIT != ZERO_POINT) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_THOUSAND_UNIT_MESSAGE);
		}
	}

	private static void validPositiveCheck(int money) {
		if (money < 0) {
			throw new IllegalArgumentException(ErrorMessage.NUMBER_POSITIVE_MESSAGE);
		}
	}

}
