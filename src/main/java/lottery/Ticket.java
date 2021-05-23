package lottery;

import java.util.List;

import lottery.exceptions.InvalidTicketSizeException;

public final class Ticket {

	private final static int SIZE_OF_TICKET = 6;
	private List<Integer> numbers;

	public Ticket(List<Integer> numbers) {
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
