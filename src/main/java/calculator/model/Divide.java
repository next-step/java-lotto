package calculator.model;

public class Divide implements ArithmeticStrategy {
	private final Integer left;
	private final Integer right;

	public Divide(Integer left, Integer right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Integer calculate() {
		return left / right;
	}
}
