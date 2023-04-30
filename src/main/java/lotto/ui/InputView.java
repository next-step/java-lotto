package lotto.ui;

import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static long inputPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		long purchaseAmount;
		try {
			purchaseAmount = scanner.nextLong();
			scanner.nextLine();
		} catch (Exception e) {
			throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
		}

		return purchaseAmount;
	}

	public static String inputWinNumbers() {
		System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine();
	}

	public static int inputBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextInt();
	}
}
