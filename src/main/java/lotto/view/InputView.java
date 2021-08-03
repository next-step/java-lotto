package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.Money;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
	private static final String INPUT_NUMBER_OF_MANUAL_LOTTO_TICKETS = "%n수동으로 구매할 로또 수를 입력해 주세요.%n";
	private static final String INPUT_MANUAL_LOTTO_TICKET_NUMBERS = "%n수동으로 구매할 번호를 입력해 주세요.%n";
	private static final String INPUT_WINNING_LOTTO_NUMBERS = "%n지난 주 당첨 번호를 입력해 주세요.%n";
	private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.%n";
	private static final String DELIMITER = ",";
	private static final String BLANK = "";
	private static final int INITIAL_INDEX = 0;
	private static final int COUNT_OF_LOTTO_NUMBERS = 6;

	private InputView() {
	}

	public static Money inputMoney() {
		System.out.println(INPUT_MONEY);
		return new Money(SCANNER.nextInt());
	}

	public static int inputManualLottoTicketsCount() {
		System.out.printf(INPUT_NUMBER_OF_MANUAL_LOTTO_TICKETS);
		return SCANNER.nextInt();
	}

	public static List<LottoNumbers> inputManualLottoNumbers(int manualLottoTicketsCount) {
		System.out.printf(INPUT_MANUAL_LOTTO_TICKET_NUMBERS);
		return IntStream.range(INITIAL_INDEX, manualLottoTicketsCount)
				.mapToObj(index -> LottoNumbers.from(lottoNumbersFromUser()))
				.collect(toList());
	}

	public static LottoNumbers inputWinningLottoNumbers() {
		System.out.printf(INPUT_WINNING_LOTTO_NUMBERS);
		List<Integer> numbers = lottoNumbersFromUser();
		return LottoNumbers.from(numbers);
	}

	public static int inputBonusNumber() {
		System.out.printf(INPUT_BONUS_NUMBER);
		return SCANNER.nextInt();
	}

	private static List<Integer> lottoNumbersFromUser() {
		return IntStream.range(INITIAL_INDEX, COUNT_OF_LOTTO_NUMBERS)
				.mapToObj(index -> Integer.parseInt(SCANNER.next().replace(DELIMITER, BLANK)))
				.collect(collectingAndThen(toList(), Collections::unmodifiableList));
	}

}
