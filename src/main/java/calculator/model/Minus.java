package calculator.model;

public class Minus implements ArithmeticStrategy {
	private final Integer left;
	private final Integer right;

	public Minus(Integer left, Integer right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Integer calculate() {
		return left - right;
	}
}
