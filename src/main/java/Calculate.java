import java.util.function.BinaryOperator;

public enum Calculate {

	PLUS("+", (x, y) -> x + y),
	MINUS("-", (x, y) -> x - y),
	TIMES("*", (x, y) -> x * y),
	DIVIDE("/", (x, y) -> x / y);

	private final String symbol;
	private final BinaryOperator<Integer> operator;

	Calculate(String symbol, BinaryOperator<Integer> operator) {
		this.symbol = symbol;
		this.operator = operator;
	}

	public int calculate(int num1, int num2) {
		return operator.apply(num1, num2);
	}
}
