import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operator {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> operations = Map.of(
            "+", (x, y) -> x + y,
            "-", (x, y) -> x - y,
            "*", (x, y) -> x * y,
            "/", (x, y) -> x / y
    );

    private final BiFunction<Integer, Integer, Integer> operation;

    public Operator(String value) {
        validate(value);
        operation = operations.get(value);
    }

    public int operate(int x, int y) {
        return operation.apply(x, y);
    }

    private void validate(String value) {
        Pattern pattern = Pattern.compile("[^\\+\\-\\*/]");
        Matcher matcher = pattern.matcher(value);

        if (matcher.matches()) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다 : " + value);
        }
    }
}
