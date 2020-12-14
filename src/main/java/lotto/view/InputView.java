package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.domain.WinningNumber;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int scanPayment() {
		System.out.println("구매금액을 입력해 주세요.");
		String payment = scanner.nextLine();
		return Integer.parseInt(payment);
	}

	public static WinningNumber scanWinningNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String inputNumbers = scanner.nextLine();
		List<Integer> winningNumbers = Arrays.stream(inputNumbers.replaceAll(" ", "").split(","))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		return new WinningNumber(winningNumbers, 45);
	}
}
