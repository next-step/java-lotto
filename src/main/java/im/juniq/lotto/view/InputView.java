package im.juniq.lotto.view;

import java.util.Scanner;

import im.juniq.lotto.WinningNumbers;

public class InputView {
	public static int purchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		return Integer.parseInt(scanner.next());
	}

	public static WinningNumbers winningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.next();
		System.out.println();

		return new WinningNumbers(inputString.split(","));
	}
}
