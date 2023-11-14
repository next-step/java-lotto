package calculator;

import java.util.function.BiFunction;

public enum Basic {

    ADD("+", (String number1, String number2) -> new Operator().add(number1, number2)),
    SUB("-", (String number1, String number2) -> new Operator().sub(number1, number2)),
    MUL("*", (String number1, String number2) -> new Operator().mul(number1, number2)),
    DIV("/", (String number1, String number2) -> new Operator().div(number1, number2));

    private final String operator;
    final BiFunction<String, String, Integer> function;

    Basic(String operator, BiFunction<String, String, Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public String getOperator() {
        return operator;
    }
}
