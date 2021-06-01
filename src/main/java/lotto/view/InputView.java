package lotto.view;

import lotto.Constants;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
	private static final String SPLIT_REGEX = ", |,";
	private static final Scanner scanner = new Scanner(System.in);

	public static BigDecimal inputMoney() {
		System.out.println(Constants.INPUT_MONEY_PRINT);
		int inputInt = getInputInt();
		return BigDecimal.valueOf(inputInt);
	}

	private static int getInputInt() {
		int inputInt = scanner.nextInt();
		scanner.nextLine();
		return inputInt;
	}

	public static List<Integer> inputWinningNumber() {
		System.out.println(Constants.INPUT_WINNING_NUMBER_PRINT);
		String inputLine = scanner.nextLine();
		return getIntegerList(inputLine.split(SPLIT_REGEX));
	}

	private static List<Integer> getIntegerList(String[] numbers) {
		return Arrays.stream(numbers)
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	public static int inputBonusNumber() {
		System.out.println(Constants.INPUT_BONUS_BALL);
		return getInputInt();
	}

	public static int inputManualLottosNumberToBuy() {
		System.out.println(Constants.INPUT_MANUAL_LOTTOS_NUMBER_TO_BUY);
		return getInputInt();
	}

	public static List<List<Integer>> inputManualLottoNumbers(int manualLottosNumberToBuy) {
		System.out.println(Constants.PRINT_MANUAL_LOTTOS);
		return IntStream.range(0, manualLottosNumberToBuy)
				.mapToObj(it -> scanner.nextLine().split(SPLIT_REGEX))
				.map(InputView::getIntegerList)
				.collect(Collectors.toList());
	}
}
