package calculator;

import java.util.Queue;

public class Numbers {
	private final Queue<Integer> numbers;

	public Numbers(Queue<Integer> numbers) {
		this.numbers = numbers;
	}

	public int poll() {
		return numbers.poll();
	}

	public void add(int number) {
		numbers.add(number);
	}
}
