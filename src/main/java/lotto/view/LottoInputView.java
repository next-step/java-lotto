package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import lotto.exception.InputMachTypeException;
import lotto.utils.ErrorMessage;
import lotto.utils.TicketCalculation;
import lotto.validation.MoneyUnitCheckValidation;
import lotto.validation.NumberPositiveValidation;

public class LottoInputView {

	private static final String BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String BUY_RESULT_MESSAGE = "개를 구매했습니다.";
	private static final Scanner scanner = new Scanner(System.in);
	private static final String LAST_WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

	private LottoInputView() {
	}

	public static int buyRequestView() {
		int money;
		System.out.println(BUY_MONEY_MESSAGE);
		try {
			money = scanner.nextInt();
			NumberPositiveValidation.validPositiveCheck(money);
			MoneyUnitCheckValidation.validThousandUnitCheck(money);
			System.out.println(TicketCalculation.getLottoTicketNumber(money) + BUY_RESULT_MESSAGE);
			scanner.nextLine();
		} catch (InputMismatchException e) {
			throw new InputMachTypeException(ErrorMessage.NUMBER_TYPE_ERROR_MESSAGE);
		}
		return money;
	}

	public static String lastWinLottoNumberView() {
		System.out.println(LAST_WIN_NUMBER_MESSAGE);
		return scanner.nextLine();
	}

}
