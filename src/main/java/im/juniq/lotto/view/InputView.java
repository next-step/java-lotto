package im.juniq.lotto.view;

import java.util.Scanner;

public class InputView {
	public static int purchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		return Integer.parseInt(scanner.next());
	}

	public static void main(String[] args) {
		InputView.purchaseAmount();
	}
}
