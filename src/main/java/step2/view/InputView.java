package step2.view;

import java.util.Scanner;

import step2.domain.Money;

public class InputView {
	public static Money getMoney() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("구입금액을 입력해 주세요.");
		String input = scanner.nextLine();
		int money;
		try {
			money = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("입력값이 잘못되었습니다.");
		}

		return new Money(money);
	}

	public static String getWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
