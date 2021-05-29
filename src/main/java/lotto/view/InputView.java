package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);

	public static int getBuyAmount() {
		System.out.println("구매금액을 입력해 주세요.");

		return scanner.nextInt();
	}

	public static List<Integer> getLastWinLotto() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");

		scanner.nextLine();
		String lastWinLotto = scanner.nextLine();
		return Arrays.stream(lastWinLotto.split(","))
			.map((x) -> Integer.parseInt(x.trim()))
			.collect(Collectors.toList());
	}

	public static int getBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");

		return scanner.nextInt();
	}
}
