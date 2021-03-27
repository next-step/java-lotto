package im.juniq.lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		String[] stringNumbers = inputString.split(",");

		List<Integer> numbers = new ArrayList<>();
		for (String number : stringNumbers) {
			numbers.add(Integer.parseInt(number));
		}
		return numbers;
	}
}
