package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
	private static final String SEPARATOR = ",";
	private static final String INPUT_PURCHASED_AMOUNT = "구매금액을 입력해주세요.";
	private static final String INPUT_WINNING_NUMBER_LAST_WEEK = "지난 주 당첨 번호를 입력해주세요.";
	private static final String INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
	private static final String INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
	public static final String INPUT_BONUS_BALL = "보너스볼 번호를 입력하세요.";

	private static final Scanner INT_SCANNER = new Scanner(System.in);
	private static final Scanner STRING_SCANNER = new Scanner(System.in);

	public static int inputPurchaseAmount() {
		System.out.println(INPUT_PURCHASED_AMOUNT);
		return INT_SCANNER.nextInt();
	}

	public static int inputManualLottoCount() {
		System.out.println(INPUT_MANUAL_LOTTO_COUNT);
		return INT_SCANNER.nextInt();
	}

	public static List<Integer> userInputManualLottoNumbers() {
		String lottoNumbers = inputManualLottoNumberAsString();
		return convertedStringToIntegerList(lottoNumbers);
	}

	public static List<Integer> userInputLastWeekLottoNumbers() {
		String lottoNumbers = inputWinningNumberLastWeekAsString();
		return convertedStringToIntegerList(lottoNumbers);
	}

	public static int inputBonusNumber() {
		System.out.println(INPUT_BONUS_BALL);
		return INT_SCANNER.nextInt();
	}

	private static String inputWinningNumberLastWeekAsString() {
		System.out.println(INPUT_WINNING_NUMBER_LAST_WEEK);
		return STRING_SCANNER.nextLine();
	}

	private static String inputManualLottoNumberAsString() {
		System.out.println(INPUT_MANUAL_LOTTO_NUMBERS);
		return STRING_SCANNER.nextLine();
	}

	public static List<Integer> convertedStringToIntegerList(String winningsNumber) {
		return Stream.of(winningsNumber.split(SEPARATOR))
			.map(value -> Integer.parseInt(value.trim()))
			.collect(Collectors.toList());
	}

	public static List<List<Integer>> inputManualLottoNumbers(int manualBuyingCount) {
		List<List<Integer>> userInputLottoNumbers = new ArrayList<>();
		for (int i = 0; i < manualBuyingCount; i++) {
			userInputLottoNumbers.add(userInputManualLottoNumbers());
		}
		return userInputLottoNumbers;
	}
}
