package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.domain.Number;
import lotto.domain.Numbers;

public class InputView {
	private static final String QUESTION_MONEY = "구입 금액을 입력해주세요.";
	private static final String QUESTION_COUNT_OF_LOTTO_BY_MANUAL = "수동으로 구매할 로또 수를 입력해주세요.";
	private static final String QUESTION_LOTTO_NUMBERS_BY_MANUAL = "수동으로 구매할 번호를 입력해주세요.";
	private static final String QUESTION_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해주세요.";
	private static final String QUESTION_BONUS_NUMBER = "보너스 볼을 입력해주세요.";
	private static final String COMMA = ",";
	private static final String SPACE = " ";
	private static final String EMPTY_STRING = "";
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int inputMoney() {
		System.out.println(QUESTION_MONEY);
		return SCANNER.nextInt();
	}

	public static int inputCountLottoByManual() {
		System.out.println(QUESTION_COUNT_OF_LOTTO_BY_MANUAL);
		return SCANNER.nextInt();
	}

	public static List<Numbers> inputLottoNumbersByManual(int count) {
		clearBuffer();
		System.out.println(QUESTION_LOTTO_NUMBERS_BY_MANUAL);
		List<Numbers> lottoNumbers = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			List<Number> numbers = convertStrInputToNumbers();
			lottoNumbers.add(new Numbers(numbers));
		}

		return lottoNumbers;
	}

	public static String inputWinningNumbers() {
		clearBuffer();
		System.out.println(QUESTION_WINNING_NUMBERS);
		return SCANNER.nextLine();
	}

	public static int inputBonusNumber() {
		System.out.println(QUESTION_BONUS_NUMBER);
		return SCANNER.nextInt();
	}

	private static List<Number> convertStrInputToNumbers() {
		String[] strNumbers = SCANNER.nextLine()
			.replace(SPACE, EMPTY_STRING)
			.split(COMMA);
		return Arrays.stream(strNumbers)
			.map(Integer::parseInt)
			.map(Number::new)
			.collect(Collectors.toList());
	}

	private static void clearBuffer() {
		SCANNER.nextLine();
	}
}
