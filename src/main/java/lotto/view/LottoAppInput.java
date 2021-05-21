package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.model.Money;

public class LottoAppInput {
	private static final String LOTTO_NUMBER_INPUT_DELIMITER = ", ";

	private final Scanner scanner;

	public LottoAppInput(Scanner scanner) {
		this.scanner = scanner;
	}

	public Money inputMoney() {
		String input = scanner.nextLine();
		int inputMoney = Integer.parseInt(input);
		return Money.ofWons(inputMoney);
	}

	public List<Integer> inputWinningNumbers() {
		String inputNumbers = scanner.nextLine();
		return splitAndParseInt(inputNumbers);
	}

	private List<Integer> splitAndParseInt(String inputNumbers) {
		String[] numbers = inputNumbers.split(LOTTO_NUMBER_INPUT_DELIMITER);
		return Stream.of(numbers)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
