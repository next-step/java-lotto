package lotto.view;

import java.util.Scanner;

import lotto.domain.Amount;
import lotto.domain.WinningNumber;

public class InputView {

	private InputView() {}

	public static final Scanner scanner = new Scanner(System.in);

	public static Amount inputPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		return new Amount(scanner.nextLine());
	}

	public static WinningNumber inputWinningNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return new WinningNumber(scanner.nextLine());
	}
}
