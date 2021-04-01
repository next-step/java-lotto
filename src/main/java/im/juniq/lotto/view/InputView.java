package im.juniq.lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	public static int purchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		return Integer.parseInt(scanner.next());
	}

	public static List<Integer> winningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.next();
		return Arrays.stream(inputString.split(",")).map(Integer::valueOf).collect(Collectors.toList());
	}

	public static int bonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		return Integer.parseInt(scanner.next());
	}
}
