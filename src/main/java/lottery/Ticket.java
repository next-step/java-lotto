package lottery;

public final class Ticket {

	public final static int SIZE_OF_TICKET = 6;
	private Numbers numbers;

	public static Ticket of(Numbers numbers) {
		return new Ticket(numbers);
	}

	private Ticket(Numbers numbers) {
		setNumbers(numbers);
	}

	private void setNumbers(Numbers numbers) {
		this.numbers = numbers;
	}

	public Numbers numbers() {
		return numbers;
	}
}
