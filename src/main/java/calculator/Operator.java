package calculator;

import java.util.Objects;

public class Operator {

    public Integer operation(String operator, String number1, String number2) {
        if (Objects.equals(operator, "+")) {
            return add(number1, number2);
        }
        if (Objects.equals(operator, "-")) {
            return sub(number1, number2);
        }
        if (Objects.equals(operator, "*")) {
            return mul(number1, number2);
        }
        if (Objects.equals(operator, "/")) {
            return div(number1, number2);
        }
        return null;
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
