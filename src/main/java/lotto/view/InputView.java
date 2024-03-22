package lotto.view;

import java.util.Scanner;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	public Integer inputPay() {
		System.out.println("구입금액을 입력해 주세요.");
		return new Scanner(System.in).nextInt();
	}

	public String getWinNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return new Scanner(System.in).nextLine();
	}

	public String getBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return new Scanner(System.in).nextLine();
	}
}
