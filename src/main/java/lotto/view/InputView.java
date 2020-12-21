package lotto.view;

import java.util.Scanner;

public class InputView {
	private Scanner sc = new Scanner(System.in);
	public int printBuyMoneyMessageAndReturnInput() {
		System.out.println("구입금액을 입력해 주세요.");
		return sc.nextInt();
	}
}
