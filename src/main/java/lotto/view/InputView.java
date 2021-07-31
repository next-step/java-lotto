package lotto.view;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import lotto.domain.WinningLottoNumbers;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBERS = "\n지난 주 당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
	private static final String DELIMITER = ",";
	private static final String BLANK = "";
	private static final int INDEX_OF_FIRST_NUMBER = 0;
	private static final int INDEX_OF_SEVENTH_NUMBER = 6;

	private InputView() {
	}

	public static int inputMoney() {
		System.out.println(INPUT_MONEY);
		return SCANNER.nextInt();
	}

	public static WinningLottoNumbers inputWinningNumbers() {
		System.out.println(INPUT_WINNING_NUMBERS);
		List<Integer> numbers = IntStream.range(INDEX_OF_FIRST_NUMBER, INDEX_OF_SEVENTH_NUMBER)
									.mapToObj(index -> Integer.parseInt(SCANNER.next().replace(DELIMITER, BLANK)))
									.collect(collectingAndThen(toList(), Collections::unmodifiableList));
		return WinningLottoNumbers.from(numbers);
	}

	public static int inputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER);
		return SCANNER.nextInt();
	}

}
