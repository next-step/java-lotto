package lottery;

import static java.util.Collections.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lottery.exceptions.InvalidTicketSizeException;

public final class Ticket {

	public final static int SIZE_OF_TICKET = 6;
	private List<Integer> numbers;

	private Ticket(List<Integer> numbers) {
		setNumbers(numbers);
	}

	public static Ticket of(List<Integer> numbers) {
		return new Ticket(numbers);
	}

	private void setNumbers(List<Integer> numbers) {
		if (numbers.size() != SIZE_OF_TICKET) {
			throw new InvalidTicketSizeException();
		}
		this.numbers = numbers;
	}

	public List<Integer> numbers() {
		return numbers;
	}
}
