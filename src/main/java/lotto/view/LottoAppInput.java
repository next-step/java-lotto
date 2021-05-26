package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoAppInput {
	private static final String LOTTO_NUMBER_SPLIT_REGEX = ", |,";
	private static final String NUMBER_EXCEPTION_MESSAGE = "숫자를 입력해주세요";
	private final Scanner scanner;

	public LottoAppInput(Scanner scanner) {
		this.scanner = scanner;
	}

	public int inputNumber() {
		String input = scanner.nextLine();
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(NUMBER_EXCEPTION_MESSAGE);
		}
	}

	public List<Integer> inputNumbers() {
		String inputNumbers = scanner.nextLine();
		try {
			return splitAndParseInt(inputNumbers);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(NUMBER_EXCEPTION_MESSAGE);
		}
	}

	private List<Integer> splitAndParseInt(String inputNumbers) {
		String[] numbers = inputNumbers.split(LOTTO_NUMBER_SPLIT_REGEX);
		return Stream.of(numbers)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	public <T> T requireValidInput(Supplier<T> input, Consumer<String> errorMessageConsumer) {
		try {
			return input.get();
		} catch (IllegalArgumentException e) {
			errorMessageConsumer.accept(e.getMessage());
			return requireValidInput(input, errorMessageConsumer);
		}
	}
}
