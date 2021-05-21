package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.enums.ErrorMessage;
import lotto.exceptions.DuplicateNumbersException;
import lotto.exceptions.InsufficientNumbersException;
import lotto.exceptions.InvalidPatternException;
import lotto.exceptions.NumberOutOfBoundsException;

public class Ticket {

	public static final int SIZE = 6;
	public static final int MIN_VALUE = 1;
	public static final int MAX_VALUE = 45;

	private List<Integer> numbers;

	public Ticket(String text) {
		this(tokenize(text));
	}

	public Ticket(List<Integer> numbers) {
		verifySize(numbers);
		verifyBounds(numbers);
		verifyDuplicate(numbers);

		Collections.sort(numbers);
		this.numbers = numbers;
	}

	public boolean contains(int number) {
		return this.numbers.contains(number);
	}

	public int countSameNumbers(Ticket other) {
		int count = 0;
		for (int number : this.numbers) {
			count += countIfContains(other, number);
		}
		return count;
	}

	private int countIfContains(Ticket other, int number) {
		if (other.contains(number)) {
			return 1;
		}
		return 0;
	}

	private static List<Integer> tokenize(String text) {
		if (Tokenizer.isEmpty(text)) {
			throw new InvalidPatternException(ErrorMessage.INVALID_PATTERN.toString());
		}
		return mapInteger(Tokenizer.captureNumbers(text));
	}

	private static List<Integer> mapInteger(List<String> numbers) {
		List<Integer> result = new ArrayList<>();
		for (String number : numbers) {
			result.add(Integer.parseInt(number));
		}
		return result;
	}

	private void verifySize(List<Integer> numbers) {
		if (numbers.size() != SIZE) {
			throw new InsufficientNumbersException(ErrorMessage.INSUFFICIENT_NUMBERS.toString());
		}
	}

	private void verifyBounds(List<Integer> numbers) {
		for (int number : numbers) {
			verifyIndividualBounds(number);
		}
	}

	private void verifyIndividualBounds(int number) {
		if (number < MIN_VALUE || MAX_VALUE < number) {
			throw new NumberOutOfBoundsException(ErrorMessage.NUMBER_OUT_OF_BOUNDS.toString());
		}
	}

	private void verifyDuplicate(List<Integer> numbers) {
		Set<Integer> set = new HashSet<>(numbers);
		if (set.size() < numbers.size()) {
			throw new DuplicateNumbersException(ErrorMessage.DUPLICATE_NUMBERS.toString());
		}
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
