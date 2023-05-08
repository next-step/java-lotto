import java.util.Arrays;
import java.util.function.ToIntBiFunction;

public enum OperatorType {
    PLUS("+", (firstNumber, lastNumber) -> firstNumber + lastNumber),
    MINUS("-", (firstNumber, lastNumber) -> firstNumber - lastNumber),
    MULTIPLE("*", (firstNumber, lastNumber) -> firstNumber * lastNumber),
    DIVIDE("/", (firstNumber, lastNumber) -> firstNumber / lastNumber);

    private final String operator;
    private final ToIntBiFunction<Integer, Integer> function;

    private static final String OPERATOR_MUST_BE_FOUR_ARITHMETIC_OPERATION = "연산자는 사칙연산만 가능합니다.";


    OperatorType(String operator, ToIntBiFunction<Integer, Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public static int calculate(String operator, int firstNumber, int lastNumber) {
        return getOperator(operator).function.applyAsInt(firstNumber, lastNumber);
    }

    private static OperatorType getOperator(String operator) {
        return Arrays.stream(values())
                .filter(operatorType -> operatorType.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(OPERATOR_MUST_BE_FOUR_ARITHMETIC_OPERATION));
    }
}
