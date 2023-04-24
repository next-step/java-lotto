package lotto.ui;

import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static int inputPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		int purchaseAmount;
		try {
			purchaseAmount = scanner.nextInt();
		} catch (Exception e) {
			throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
		}

		return purchaseAmount;
	}
}
