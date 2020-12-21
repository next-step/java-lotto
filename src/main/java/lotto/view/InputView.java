package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	public static int inputBuyMoneyAndReturnInputValue() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static List<Integer> inputWinLottoNumbersAndReturnInputValue() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		scanner.skip("[\r\n]+");
		String input = scanner.nextLine();
		String[] inputArray = input.split(",");
		return Arrays.stream(inputArray).map(i -> i.trim()).map(Integer::parseInt).collect(Collectors.toList());
	}
}
