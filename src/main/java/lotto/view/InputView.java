package lotto.view;

import java.util.Scanner;
import lotto.dto.PurchaseInfo;
import lotto.dto.WinningNumber;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static PurchaseInfo buyLotto() {
		System.out.println("구입금액을 입력해 주세요.");
		int money = scanner.nextInt();

		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		int manualPickCount = scanner.nextInt();

		return new PurchaseInfo(money, manualPickCount);
	}

	public static WinningNumber drawWinningNumbers() {
		scanner.nextLine(); // 엔터 제거
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String winningNumber = scanner.nextLine();

		System.out.println("보너스 볼을 입력해 주세요.");
		int bonusNumber = scanner.nextInt();

		return new WinningNumber(winningNumber, bonusNumber);
	}
}
