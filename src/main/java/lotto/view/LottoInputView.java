package lotto.view;

import java.util.Scanner;

import lotto.exception.InputMachTypeException;
import lotto.message.ErrorMessage;

public class LottoInputView {

	private static final String BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String LAST_WEEK_WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final Scanner scanner = new Scanner(System.in);

	private LottoInputView() {
	}

	public static int inputLottoPurchaseMoney() {
		System.out.println(BUY_MONEY_MESSAGE);
		if (!scanner.hasNextInt()) {
			throw new InputMachTypeException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
		return Integer.parseInt(scanner.nextLine());
	}

	public static String inputLastWinningLotto() {
		System.out.println(LAST_WEEK_WIN_NUMBER_MESSAGE);
		return scanner.nextLine();
	}
}
