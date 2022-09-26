package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator{

    PLUS("+",(x,y)->x+y),
    MINUS("-",(x,y)->x-y),
    MULTIPLY("*",(x,y)->x*y),
    DIVIDE("/",(x,y)->x/y)
    ;

    private final String symbol;
    public final BinaryOperator<Integer> operation;
    Operator(String symbol , BinaryOperator<Integer> operation) {
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
