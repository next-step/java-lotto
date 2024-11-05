package step2.view;

import java.util.Scanner;

import step2.domain.Money;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static Money getMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		String input = scanner.nextLine();
		try {
			int money = Integer.parseInt(input);
			return new Money(money);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("입력값이 잘못되었습니다.");
		}
	}

	public static String getWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return scanner.nextLine();
	}

	public static String getBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextLine();
	}
}
