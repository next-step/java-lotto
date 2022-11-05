package step3.view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public int inputMoney() {
		System.out.println("구입금액을 입력해 주세요");
		return scanner.nextInt();
	}

	public String inputWinnerNumber() {
		scanner.nextLine();
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine();
	}

	public int inputBonusNumber() {
		System.out.println("보너스 번호를 입력해주세요");
		return scanner.nextInt();
	}
}
