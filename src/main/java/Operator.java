import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
	PLUS("+") {
		public int apply(int left, int right) {
			return left + right;
		}
	},
	MINUS("-") {
		public int apply(int left, int right) {
			return left - right;
		}
	},
	MULTIPLICATION("*") {
		public int apply(int left, int right) {
			return left * right;
		}
	},
	DIVISION("/") {
		public int apply(int left, int right) {
			return left / right;
		}
	};

	private final String symbol;

	private static final Map<String, Operator> stringToEnum =
			Stream.of(values()).collect(Collectors.toMap(Object::toString, e -> e));

	Operator(String symbol) {
		this.symbol = symbol;
	}

	public String symbol() {
		return this.symbol;
	}

	public static int calculate(int left, String operator, int right) {
		return Operator.fromString(operator).apply(left, right);
	}

	public static Operator fromString(String symbol) {
		return Optional.ofNullable(stringToEnum.get(symbol))
				.orElseThrow(() -> new IllegalArgumentException("사칙연산 기호를 입력하세요"));
	}

	abstract int apply(int left, int right);

	@Override
	public String toString() {
		return this.symbol;
	}
}
