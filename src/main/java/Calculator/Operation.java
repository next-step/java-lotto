package Calculator;

import java.util.Arrays;

public enum Operation {
	SUM("+", Integer::sum),
	SUBTRACT("-", (a, b) -> a - b),
	MULTIPLY("*", (a, b) -> a * b),
	DIVIDE("/", ((a, b) -> a / b));

	private final String operation;
	private final OperationStrategy strategy;

	Operation(String operation, OperationStrategy strategy) {
		this.operation = operation;
		this.strategy = strategy;
	}

	public static OperationStrategy getStrategy(String operation) {
		return Arrays.stream(Operation.values())
			.filter(it -> it.operation.equals(operation))
			.findFirst()
			.map(it -> it.strategy)
			.orElseThrow(() -> new IllegalArgumentException("operation must be - / * +"));
	}
}
