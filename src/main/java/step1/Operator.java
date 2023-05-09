package step1;

import java.util.Map;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS('+', Integer::sum),
    MINUS('-', (num1, num2) -> num1 - num2),
    MULTIPLY('*', (num1, num2) -> num1 * num2),
    DIVIDE('/', (num1, num2) -> num1 / num2);

    private static final Map<Character, Operator> SYMBOLS = Map.of(
            Operator.PLUS.getSymbol(), Operator.PLUS,
            Operator.MINUS.getSymbol(), Operator.MINUS,
            Operator.MULTIPLY.getSymbol(), Operator.MULTIPLY,
            Operator.DIVIDE.getSymbol(), Operator.DIVIDE
    );
    private final Character symbol;
    private final BinaryOperator<Integer> operator;

    Operator(Character symbol, BinaryOperator<Integer> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static Operator fromSymbol(char symbol) {
        return SYMBOLS.get(symbol);
    }

    public static boolean isOperator(char symbol) {
        return SYMBOLS.getOrDefault(symbol, null) != null;
    }

    public Character getSymbol() {
        return symbol;
    }

    public int calculate(int num1, int num2) {
        return operator.apply(num1, num2);
    }

}
