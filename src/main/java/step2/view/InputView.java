package step2.view;

import java.util.List;
import java.util.Scanner;

import step2.domain.Lotto;

public class InputView {

	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public int inputPurchasePrice() {
		final String messageOfInputPurchasePrice = "구입금액을 입력해 주세요.";
		final String messageOfResultPurchasePrice = "%d개를 구매했습니다.";
		int purchaseAmount;

		System.out.println(messageOfInputPurchasePrice);

		try {
			purchaseAmount = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력 가능합니다.");
		}

		validate(purchaseAmount);
		System.out.printf((messageOfResultPurchasePrice) + "%n", purchaseAmount);

		return purchaseAmount;
	}

	private void validate(final int purchaseAmount) {
		if (purchaseAmount < 0) {
			throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
		}
	}

}
