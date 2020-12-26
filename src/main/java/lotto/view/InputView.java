package lotto.view;

import java.util.List;
import java.util.Scanner;

import lotto.domain.LottoLottery;
import lotto.domain.LottoNumber;
import lotto.domain.Message;
import lotto.utils.LottoNumberUtils;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int waitInputMoney() {
		System.out.println(Message.INPUT_MONEY);

		return waitInputNumber();
	}

	private static int waitInputNumber() {
		try {
			return SCANNER.nextInt();
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(Message.INPUT_NUMBER);
		}
	}

	public static List<LottoNumber> waitInputLastWinNumbers() {
		System.out.println(Message.INPUT_LAST_WIN_NUMBERS);

		return LottoNumberUtils.mapToListByComma(SCANNER.nextLine());
	}
}
