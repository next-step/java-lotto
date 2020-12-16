package lotto.view;

import java.util.List;

import lotto.modal.Lotto;

public class UserOutput {

	private static final String NEXT_LINE_FLAG = "\n";
	private static final String PRINT_USER_BUY_LOTTO_NUMBER = "개를 구매했습니다.";
	private static final String PRINT_LOTTO_BUY_MONEY = "구입금액을 입력해 주세요.";
	public static final String PRINT_LOTTO_WINNER_NUMBER = "지난 주 담청 번호를 입력해 주세요.";

	private static void messagePrint(final String message) {

		System.out.print(message);
	}

	public static void printUserErrorMsg(String msg) {

		messagePrint(msg + NEXT_LINE_FLAG);
	}

	public static void printUserInputMoney() {

		messagePrint(PRINT_LOTTO_BUY_MONEY + NEXT_LINE_FLAG);
	}

	public static void printLottoCount(int size) {

		messagePrint(size + PRINT_USER_BUY_LOTTO_NUMBER + NEXT_LINE_FLAG);
	}

	public static void printLottoPackage(List<Lotto> lottoPackage) {

		for (Lotto lotto : lottoPackage) {

			messagePrint(lotto.toString() + NEXT_LINE_FLAG);
		}

		messagePrint(NEXT_LINE_FLAG);
	}

	public static void printUserInputLotto() {

		messagePrint(PRINT_LOTTO_WINNER_NUMBER + NEXT_LINE_FLAG);
	}
}
