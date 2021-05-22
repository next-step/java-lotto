package lottery;

import lottery.exceptions.InvalidTicketSizeException;

public final class Ticket {
	private final static int SIZE_OF_TICKET = 6;
	private int[] numbers;

	public Ticket(int[] numbers) {
		setNumbers(numbers);
	}

	public static Ticket of(int[] numbers) {
		return new Ticket(numbers);
	}

	private void setNumbers(int[] numbers) {
		if (numbers.length != SIZE_OF_TICKET) {
			throw new InvalidTicketSizeException();
		}
		this.numbers = numbers;
	}

	public int[] numbers() {
		return numbers;
	}
}
