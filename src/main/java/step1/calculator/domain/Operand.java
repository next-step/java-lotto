package step1.calculator.domain;

public class Operand {
	private final int operand;

	public int getOperand() {
		return operand;
	}

	public Operand(int operand) {
		this.operand = operand;
	}

	public static Operand from(String inputOperand)  throws IllegalArgumentException {
		int operand = validate(inputOperand);

		return new Operand(operand);
	}

	public static Operand from(int inputOperand)  throws IllegalArgumentException {
		return new Operand(inputOperand);
	}

	private static int validate(String inputOperand) throws IllegalArgumentException {
		if (!isOperand(inputOperand)) {
			throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
		}

		return Integer.parseInt(inputOperand);
	}

	public static boolean isOperand(String inputOperand) {
		try {
			Integer.parseInt(inputOperand);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
