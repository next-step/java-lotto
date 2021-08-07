package lotto.view;

import java.util.Scanner;

import lotto.exception.InputMachTypeException;
import lotto.message.ErrorMessage;
import lotto.model.Money;
import lotto.model.WinnerLotto;

public class LottoInputView {

	private static final String BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String LAST_WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
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

	public static WinnerLotto inputLastWinningLotto() {
		System.out.println(LAST_WIN_NUMBER_MESSAGE);
		return new WinnerLotto(scanner.nextLine());
	}
}
