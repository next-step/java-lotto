package calculator.model;

public class Multiply implements ArithmeticStrategy{
	private final Integer left;
	private final Integer right;

	public Multiply(Integer left, Integer right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Integer calculate() {
		return left * right;
	}
}
