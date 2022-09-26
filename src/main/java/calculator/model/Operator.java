package calculator.model;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator{

    PLUS("+",(x,y)->x.plus(y)),
    MINUS("-",(x,y)->x.minus(y)),
    MULTIPLY("*",(x,y)->x.multiply(y)),
    DIVIDE("/",(x,y)->x.divide(y))
    ;

    private final String symbol;
    public final BinaryOperator<Operand> operation;
    Operator(String symbol , BinaryOperator<Operand> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static boolean isOperator(String symbol){
        return Arrays.stream(Operator.values()).anyMatch((operator)->operator.isSameSymbol(symbol));
    }

    public static Operator getOperator(String symbol){
        return Arrays.stream(Operator.values()).filter((operator)->operator.isSameSymbol(symbol)).findAny().orElseThrow(IllegalArgumentException::new);
    }

    private boolean isSameSymbol(String symbol){
        return this.symbol.equals(symbol);
    }

}
