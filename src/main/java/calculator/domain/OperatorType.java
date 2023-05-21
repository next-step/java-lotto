package calculator.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public enum OperatorType {
    PLUS("+", (a,b) -> a.plus(b)),
    MINUS("-", Operand::minus),
    MULTIPLE("*", Operand::multiple),
    DIVIDE("/", Operand::divide),
    EMPTY("기타", null);

    private final String symbol;
    private final BiFunction<Operand, Operand, Double> function;

    OperatorType(String symbol, BiFunction<Operand, Operand, Double> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public static Operand calculate(Operand operand1, Operator operator, Operand operand2) {
        OperatorType operatorType = Arrays.stream(OperatorType.values())
                .filter(o -> o.symbol.equals(operator.getOperator()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산입니다."));
        return new Operand(operatorType.execute(operand1, operand2));
    }

    public Double execute(Operand operand1, Operand operand2) {
        return function.apply(operand1, operand2);
    }

    public boolean hasSymbol(String symbol) {
        return Arrays.stream(OperatorType.values())
                .anyMatch(operatorType -> operatorType.symbol.equals(symbol));
    }
}
