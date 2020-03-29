package lotto.ui;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
	private static final String PRIZE_INPUT_MSG = "구입 금액을 입력해 주세요.";
	private static final String GET_WINNING_NUMBER_MSG = "지난 주 당첨 번호를 입력해 주세요.";

	private final Scanner scanner;

	public static InputView getInstance() {
		Scanner scanner = new Scanner(System.in);
		return new InputView(scanner);
	}

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public long getSpentMoney() {
		System.out.println(PRIZE_INPUT_MSG);
		return Integer.parseInt(scanner.nextLine());
	}

	public LottoNumber getWinningLastWeekNumber() {
		System.out.println(GET_WINNING_NUMBER_MSG);
		String numberString = scanner.nextLine();
		List<Integer> numbers = Arrays.stream(numberString.split(","))
				.map(Integer::parseInt)
				.collect(Collectors.toList());

		return new LottoNumber(numbers);
	}
}
