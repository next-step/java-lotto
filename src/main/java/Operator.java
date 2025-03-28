import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

enum Operator {
    ADD("+", (num1, num2) -> num1 + num2),
    SUBTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private static final Map<String, Operator> SYMBOL_MAP;

    static {
        SYMBOL_MAP = Arrays.stream(Operator.values()).collect(
            Collectors.toMap(Operator::getSymbol, Function.identity())
        );
    }

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> calFunction;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> calFunction) {
        this.symbol = symbol;
        this.calFunction = calFunction;
    }

    static Operator fromSymbol(String symbol) {
        Operator operator = SYMBOL_MAP.get(symbol);
        if (operator == null) {
            throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
        return operator;
    }

    String getSymbol() {
        return this.symbol;
    }

    int calculate(Integer num1, Integer num2) {
        return this.calFunction.apply(num1, num2);
    }
}