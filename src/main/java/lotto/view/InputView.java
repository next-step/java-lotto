package lotto.view;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import lotto.domain.LottoNumbers;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
	private static final String INPUT_NUMBER_OF_MANUAL_LOTTO_TICKETS = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String INPUT_MANUAL_LOTTO_TICKET_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
	private static final String INPUT_WINNING_LOTTO_NUMBERS = System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
	private static final String DELIMITER = ",";
	private static final String BLANK = "";
	private static final int INITIAL_INDEX = 0;
	private static final int COUNT_OF_LOTTO_NUMBERS = 6;

	private InputView() {
	}

	public static int inputMoney() {
		System.out.println(INPUT_MONEY);
		return SCANNER.nextInt();
	}

	public static int inputManualLottoTicketsCount() {
		System.out.println(INPUT_NUMBER_OF_MANUAL_LOTTO_TICKETS);
		return SCANNER.nextInt();
	}

	public static List<LottoNumbers> inputManualLottoNumbers(int manualLottoTicketsCount) {
		System.out.println(INPUT_MANUAL_LOTTO_TICKET_NUMBERS);
		return IntStream.range(INITIAL_INDEX, manualLottoTicketsCount)
				.mapToObj(index -> LottoNumbers.from(lottoNumbersFromUser()))
				.collect(toList());
	}

	public static LottoNumbers inputWinningLottoNumbers() {
		System.out.println(INPUT_WINNING_LOTTO_NUMBERS);
		List<Integer> numbers = lottoNumbersFromUser();
		return LottoNumbers.from(numbers);
	}

	public static int inputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER);
		return SCANNER.nextInt();
	}

	private static List<Integer> lottoNumbersFromUser() {
		return IntStream.rangeClosed(INITIAL_INDEX, COUNT_OF_LOTTO_NUMBERS)
				.mapToObj(index -> Integer.parseInt(SCANNER.next().replace(DELIMITER, BLANK)))
				.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

}
