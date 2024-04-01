package lotto.io;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputPurchasePrice() {
		System.out.println("구매금액을 입력해주세요");
		return Integer.parseInt(scanner.nextLine());
	}

	public static String[] inputWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine().replace(" ", "").split(",");
	}
}
