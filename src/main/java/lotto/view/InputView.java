package lotto.view;

import lotto.Constants;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
	private static final String SPLIT_REGEX = ", |,";
	private static final Scanner scanner = new Scanner(System.in);

	public static BigDecimal inputMoney() {
		System.out.println(Constants.INPUT_MONEY_PRINT);
		int inputInt = scanner.nextInt();
		scanner.nextLine();
		return BigDecimal.valueOf(inputInt);
	}

	public static List<Integer> inputWinningNumber() {
		System.out.println(Constants.INPUT_WINNING_NUMBER_PRINT);
		String inputLine = scanner.nextLine();
		return Stream.of(inputLine.split(SPLIT_REGEX))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}
