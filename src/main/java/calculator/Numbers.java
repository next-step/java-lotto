package calculator;

import java.util.Stack;

public class Numbers {
	private final Stack<Integer> numbers;

	public Numbers(Stack<Integer> numbers) {
		this.numbers = numbers;
	}

	public int pop() {
		return numbers.pop();
	}

	public void push(int number) {
		numbers.push(number);
	}

	public void pushBySign(Sign sign) {
		if (sign.isPlusSign()) {
			plus();
		}
		if (sign.isMinusSign()) {
			minus();
		}
		if (sign.isMultiplicationSign()) {
			multiplication();
		}
		if (sign.isDivisionSign()) {
			division();
		}
	}

	public void plus() {
		numbers.push(numbers.pop() + numbers.pop());
	}

	public void minus() {
		numbers.push(numbers.pop() - numbers.pop());
	}

	public void multiplication() {
		numbers.push(numbers.pop() * numbers.pop());
	}

	public void division() {
		numbers.push(numbers.pop() / numbers.pop());
	}

	public int size() {
		return numbers.size();
	}
}
