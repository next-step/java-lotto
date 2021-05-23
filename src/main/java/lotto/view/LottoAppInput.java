package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoAppInput {
	private static final String LOTTO_NUMBER_SPLIT_REGEX = ", |,";

	private final Scanner scanner;

	public LottoAppInput(Scanner scanner) {
		this.scanner = scanner;
	}

	public int inputNumber() {
		String input = scanner.nextLine();
		return Integer.parseInt(input);
	}

	public List<Integer> inputWinningNumbers() {
		String inputNumbers = scanner.nextLine();
		return splitAndParseInt(inputNumbers);
	}

	private List<Integer> splitAndParseInt(String inputNumbers) {
		String[] numbers = inputNumbers.split(LOTTO_NUMBER_SPLIT_REGEX);
		return Stream.of(numbers)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
