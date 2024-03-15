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
		validate();
		return left / right;
	}

	private void validate() {
		if (right == 0) {
			throw new IllegalArgumentException("0으로 나눌 수 없습니다. 0보다 큰 숫자를 입력해주세요.");
		}
	}
}
