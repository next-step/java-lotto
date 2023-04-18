package step1.arithmetic;

import java.util.Arrays;

public enum FourArithmeticSymbols {
    PLUS("+", new Plus()),
    MINUS("-", new Minus()),
    MULTIPLICATION("*", new Multiplication()),
    DIVISION("/", new Division());

    private final String symbol;
    private final FourArithmetic arithmetic;

    FourArithmeticSymbols(String symbol, FourArithmetic arithmetic) {
        this.symbol = symbol;
        this.arithmetic = arithmetic;
    }

    public static FourArithmeticSymbols findBy(String symbol) {
        return Arrays.stream(values())
                .filter(fourArithmetic -> fourArithmetic.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("숫자 외의 기호는 사칙연산 기호만 가능합니다."));
    }

    public int calculate(int value1, int value2) {
        return this.arithmetic.calculate(value1, value2);
    }
}
