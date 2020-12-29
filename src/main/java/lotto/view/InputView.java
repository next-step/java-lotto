package lotto.view;

import java.util.List;
import java.util.Scanner;

import lotto.domain.LottoNumber;
import lotto.domain.Message;
import lotto.domain.Money;
import lotto.domain.WinLottoNumbers;
import lotto.utils.LottoNumberUtils;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	public static Money waitInputMoney() {
		System.out.println(Message.INPUT_MONEY);

		return new Money(waitInputNumber());
	}

	private static int waitInputNumber() {
		try {
			return Integer.parseInt(SCANNER.nextLine());
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(Message.INPUT_NUMBER);
		}
	}

	public static WinLottoNumbers waitInputWinLottoNumbers() {
		return new WinLottoNumbers(waitInputLastWinNumbers(), waitInputBonusNumber());
	}

	private static List<LottoNumber> waitInputLastWinNumbers() {
		System.out.println(Message.INPUT_LAST_WIN_NUMBERS);

		return LottoNumberUtils.mapToListByComma(SCANNER.nextLine());
	}

	private static LottoNumber waitInputBonusNumber() {
		System.out.println(Message.INPUT_BONUS_BALL_NUMBER);

		return new LottoNumber(waitInputNumber());
	}
}
