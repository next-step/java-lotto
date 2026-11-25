package view;

import java.util.Scanner;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);

	public int inputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		return Integer.parseInt(SCANNER.nextLine());
	}

	public String inputWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return SCANNER.nextLine();
	}
}
