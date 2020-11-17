package nextstep.step2.view;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {
	private static final String INPUT_MESSAGE_MONEY = "구입금액을 입력해 주세요.";
	private static final String INPUT_MESSAGE_LAST_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String WRONG_INPUT_MESSAGE = "구입금액은 필수입니다.";
	private static final String WRONG_INPUT_LAST_LOTTO = "지난주 로또 당첨 번호는 필수입니다.";

	private Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public int getInputMessage() {
		System.out.println(INPUT_MESSAGE_MONEY);
		return getInputMoney();
	}

	public String getInputLottoWinningNumbers() {
		System.out.println(INPUT_MESSAGE_LAST_LOTTO);
		return getInputLottoNumbers();
	}

	protected int getInputMoney() {
		try {
			return scanner.nextInt();
		} catch (NoSuchElementException ex) {
			throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
		}
	}

	protected String getInputLottoNumbers() {
		try {
			String winnerNumbers = scanner.nextLine();
			return winnerNumbers;
		} catch (NoSuchElementException ex) {
			throw new IllegalArgumentException(WRONG_INPUT_LAST_LOTTO);
		}
	}
}
