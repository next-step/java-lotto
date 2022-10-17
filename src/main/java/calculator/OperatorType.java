package calculator;

import java.util.Arrays;
import java.util.List;

public enum OperatorType {

    ADD("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String indicator;

    OperatorType(String indicator) {
        this.indicator = indicator;
    }

    public static List<OperatorType> getAllTypes(){
        return Arrays.asList(ADD, MINUS, MULTIPLY, DIVIDE);
    }

    public static List<String> getAllIndicators(){
        return Arrays.asList(ADD.indicator, MINUS.indicator, MULTIPLY.indicator, DIVIDE.indicator);
    }
}
