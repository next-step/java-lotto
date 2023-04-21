package calculator;

import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ArithmeticSymbol {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> calculate;

    ArithmeticSymbol(String symbol, BiFunction<Integer, Integer, Integer> calculate) {
        this.symbol = symbol;
        this.calculate = calculate;
    }

    private static final Map<String, ArithmeticSymbol> ARITHMETIC_SYMBOL_MAP
            = Collections.unmodifiableMap(Stream.of(values())
                                                .collect(Collectors.toMap(ArithmeticSymbol::getSymbol, x -> x)));

    public Integer calculate(Integer firstNumber, Integer secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException("null 은 계산할 수 없습니다.");
        }
        return calculate.apply(firstNumber, secondNumber);
    }

    public static ArithmeticSymbol find(String symbol) {
        if (ARITHMETIC_SYMBOL_MAP.containsKey(symbol)) {
            return ARITHMETIC_SYMBOL_MAP.get(symbol);
        }

        throw new IllegalArgumentException("symbol 을 찾을 수 없습니다. symbol: " + symbol);
    }

    public String getSymbol() {
        return symbol;
    }
}
