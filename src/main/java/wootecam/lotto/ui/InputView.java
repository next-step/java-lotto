package wootecam.lotto.ui;

import java.util.Scanner;

public class InputView extends View {
	public static final String PURCHASE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
	public static final String WINNING_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";
	public static final String MANUAL_NUMBER_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
	private final Scanner scanner = new Scanner(System.in);

	public String makeLottoPurchaseMoneyInput() {
		out.println(PURCHASE_INPUT_MESSAGE);
		return this.scanner.nextLine();
	}

	public void close() {
		this.scanner.close();
	}

	public String makeWinningNumberInput() {
		out.println(WINNING_NUMBER_INPUT_MESSAGE);
		return this.scanner.nextLine();
	}

	public String makeBonusNumberInput() {
		out.println(BONUS_NUMBER_INPUT_MESSAGE);
		return this.scanner.nextLine();
	}

	public String makeManualLottoCountInput() {
		out.println(MANUAL_NUMBER_INPUT_MESSAGE);
		return this.scanner.nextLine();
	}
}
