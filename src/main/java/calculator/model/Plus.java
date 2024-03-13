package calculator.model;

public class Plus implements ArithmeticStrategy {
	private final Integer left;
	private final Integer right;

	public Plus(Integer left, Integer right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Integer calculate() {
		return left + right;
	}
}
