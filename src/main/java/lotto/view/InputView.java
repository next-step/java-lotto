package lotto.view;

import java.util.Scanner;

import lotto.domain.Amount;
import lotto.domain.LottoNumber;
import lotto.domain.WinningNumbers;

public class InputView {

	private InputView() {}

	public static final Scanner scanner = new Scanner(System.in);

	public static String inputPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextLine();
	}

	public static String inputWinningNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine();
	}

	public static String inputBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextLine();
	}
}
