package wootecam.lotto.ui;

import java.util.Scanner;

public class InputView extends View {
	public static final String PURCHASE_INPUT_MESSAGE = "구입금액을 입력해주세요.";
	private final Scanner scanner = new Scanner(System.in);

	public String makeLottoPurchaseMoneyInput() {
		out.println(PURCHASE_INPUT_MESSAGE);
		return this.scanner.nextLine();
	}

	public void closeScanner() {
		this.scanner.close();
	}
}
