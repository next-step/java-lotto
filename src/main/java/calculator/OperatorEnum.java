package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorEnum {
    ADD ("+", (op1,op2) -> op1.getValue() + op2.getValue()),
    SUBTRACT("-", (op1,op2) -> op1.getValue() - op2.getValue()),
    MULTIPLY("*", (op1,op2) -> op1.getValue() * op2.getValue()),
    DIVIDE("/", (op1,op2) -> op1.getValue() / op2.getValue());

    private String value;
    private BiFunction<Operand, Operand, Integer> biFunction;

    OperatorEnum(String value, BiFunction<Operand, Operand, Integer> biFunction) {
        this.value = value;
        this.biFunction = biFunction;
    }

    public int calculate(Operand op1, Operand op2) {
        return this.biFunction.apply(op1, op2);
    }

    public String getValue() {
        return value;
    }

    public static OperatorEnum getEnumByValue(String inputValue) {
        return Arrays.stream(values()).filter(e -> e.getValue().equals(inputValue)).findFirst().orElse(null);
    }

}
