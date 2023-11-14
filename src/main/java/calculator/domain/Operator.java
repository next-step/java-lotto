package calculator.domain;

import java.util.Arrays;

public class Operator {

    public Integer operation(String operator, String number1, String number2) {
        return getResult(operator, number1, number2);
    }

    private Integer getResult(String operator, String number1, String number2) {
        Basic basic = Arrays.stream(Basic.values())
                .filter(o -> o.getOperator().equals(operator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return basic.function.apply(number1, number2);
    }

    public int add(String number1, String number2) {
        return Integer.parseInt(number1) + Integer.parseInt(number2);
    }

    public int sub(String number1, String number2) {
        return Integer.parseInt(number1) - Integer.parseInt(number2);
    }

    public int mul(String number1, String number2) {
        return Integer.parseInt(number1) * Integer.parseInt(number2);
    }

    public int div(String number1, String number2) {
        return Integer.parseInt(number1) / Integer.parseInt(number2);
    }
}
