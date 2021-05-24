package lottery;

import static lottery.Ticket.*;

import java.util.List;

import lottery.exceptions.InvalidTicketSizeException;

public class Numbers {

	private final List<Integer> numbers;

	public static Numbers from(List<Integer> numbers) {
		if (numbers.size() != SIZE_OF_TICKET) {
			throw new InvalidTicketSizeException();
		}
		return new Numbers(numbers);
	}

	private Numbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getValues() {
		return numbers;
	}
}
