package nextstep.step2.view;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {
	private static final String INPUT_MESSAGE_MONEY = "구입금액을 입력해 주세요.";
	private static final String INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String INPUT_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
	private static final String INPUT_MESSAGE_LAST_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String INPUT_MESSAGE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
	private static final String WRONG_INPUT_NUMBER = "숫자로 입력해주세요.";
	private static final String WRONG_INPUT_STRING = "문자열은 필수입니다.";

	private Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public int getInputMoney() {
		System.out.println(INPUT_MESSAGE_MONEY);
		return getInputNumber();
	}

	public int getInputManualCount() {
		System.out.println(INPUT_MANUAL_LOTTO_COUNT);
		return getInputNumber();
	}

	public String getInputManualNumbers(int count) {
		System.out.println(INPUT_MANUAL_NUMBERS);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(getInputString());
			sb.append((i < (count - 1) ? ":" : ""));
		}
		return sb.toString();
	}

	public String getInputLottoWinningNumbers() {
		System.out.println(INPUT_MESSAGE_LAST_LOTTO);
		return getInputString();
	}

	public int getInputLottoBonusNumber() {
		System.out.println(INPUT_MESSAGE_BONUS_NUMBER);
		return getInputNumber();
	}

	protected int getInputNumber() {
		try {
			return scanner.nextInt();
		} catch (InputMismatchException ex) {
			throw new IllegalArgumentException(WRONG_INPUT_NUMBER);
		}
	}

	protected String getInputString() {
		try {
			return scanner.nextLine();
		} catch (NoSuchElementException ex) {
			throw new IllegalArgumentException(WRONG_INPUT_STRING);
		}
	}
}
